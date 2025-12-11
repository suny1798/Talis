package com.example.aop;

import com.example.Utils.JwtUtil;
import com.example.anno.LogOperation;
import com.example.mapper.OperateLogMapper;
import com.example.pojo.OperateLog;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Map;

@Slf4j
@Aspect
@Component
public class OperationLogAspect {

    @Autowired
    private OperateLogMapper operateLogMapper;

    // 环绕通知
    @Around("@annotation(com.example.anno.LogOperation)")
    public Object LogAspect(ProceedingJoinPoint joinPoint) throws Throwable {
        // 记录开始时间
        long startTime = System.currentTimeMillis();
        // 执行方法
        Object result = joinPoint.proceed();
        // 当前时间
        long endTime = System.currentTimeMillis();
        // 耗时
        long costTime = endTime - startTime;

        // 构建日志对象
        OperateLog operateLog = new OperateLog();
        operateLog.setOperateEmpId(getCurrentUserId());
        operateLog.setOperateTime(LocalDateTime.now());
        operateLog.setClassName(joinPoint.getTarget().getClass().getName());
        operateLog.setMethodName(joinPoint.getSignature().getName());
        operateLog.setMethodParams(Arrays.toString(joinPoint.getArgs()));
        operateLog.setReturnValue(result.toString());
        operateLog.setCostTime(costTime);

        log.info("操作日志：{}", operateLog);
        // 插入日志
        operateLogMapper.insert(operateLog);
        return result;
    }

    public Integer getCurrentUserId() {
        HttpServletRequest request =
                RequestContextHolder
                        .getRequestAttributes() instanceof ServletRequestAttributes sra
                        ? sra.getRequest() : null;
        String token = null;
        if (request != null) {
            token = request.getHeader("Token");
        }
        try {
            Claims claims = JwtUtil.parseJwt(token);
            String body = claims.get("id").toString() ;
            log.info("当前用户id: {}", body);
            return Integer.parseInt(body);
        } catch (Exception e) {
            log.warn("token 解析失败: {}", e.getMessage());
            return null;
        }
    }
}