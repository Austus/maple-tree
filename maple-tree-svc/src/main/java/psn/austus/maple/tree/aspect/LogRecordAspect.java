package psn.austus.maple.tree.aspect;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import psn.austus.maple.tree.constant.KafkaQueue;
import psn.austus.maple.tree.entity.LogRecord;

import java.util.Date;

@Aspect
@Component
public class LogRecordAspect {


    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;


    @Around("@annotation(psn.austus.maple.tree.annotation.Log)")
    public Object LogRecord(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        Object result = null;
        String exception=null;

        try {
            result = joinPoint.proceed(); // 执行目标方法
        }catch (Exception e){
            exception = e.getMessage();
        }
        long end = System.currentTimeMillis();
        long executeTime=end - start;

        LogRecord logRecord = new LogRecord();
        logRecord.setArgs(JSON.toJSONString(joinPoint.getArgs()));
        logRecord.setClazz(joinPoint.getTarget().toString());
        logRecord.setMethod(joinPoint.getSignature().toShortString());
        logRecord.setResult(result.toString());
        logRecord.setException(exception);
        logRecord.setExecuteTime(executeTime);
        logRecord.setCreateTime(new Date());

        kafkaTemplate.send(KafkaQueue.LOG_RECORD_TOPIC, JSON.toJSONString(logRecord));


        return result;
    }

}
