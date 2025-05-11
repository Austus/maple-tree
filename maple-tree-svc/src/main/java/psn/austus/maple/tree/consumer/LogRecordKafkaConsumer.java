package psn.austus.maple.tree.consumer;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;
import psn.austus.maple.tree.constant.KafkaQueue;
import psn.austus.maple.tree.dao.LogRecordDAO;
import psn.austus.maple.tree.entity.LogRecord;


@Component
public class LogRecordKafkaConsumer {


    @Autowired
    LogRecordDAO logRecordDAO;

    @KafkaListener(topics = KafkaQueue.LOG_RECORD_TOPIC)
    public void listen(String message, Acknowledgment ack) {

        LogRecord logRecord = JSON.parseObject(message, LogRecord.class);

        logRecordDAO.insert(logRecord);
        ack.acknowledge();

    }
}
