package psn.austus.maple.tree.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;
import psn.austus.maple.tree.constant.KafkaQueue;
import psn.austus.maple.tree.dao.TalkLogDAO;
import psn.austus.maple.tree.entity.TalkLog;

import java.util.Date;

@Component
public class KafkaConsumer {


    @Autowired
    TalkLogDAO talkLogDAO;

    @KafkaListener(topics = KafkaQueue.TEST_TOPIC, groupId = "my-group")
    public void listen(String message, Acknowledgment ack) {


        TalkLog log = new TalkLog();
        log.setQuestion("1");
        log.setResponse(message);
        log.setCreateTime(new Date());
         talkLogDAO.insert(log);
        ack.acknowledge();
    }
}
