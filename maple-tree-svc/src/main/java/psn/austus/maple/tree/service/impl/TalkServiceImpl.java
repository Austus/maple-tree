package psn.austus.maple.tree.service.impl;

import cn.hutool.core.util.StrUtil;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import psn.austus.maple.tree.constant.RedisKeys;
import psn.austus.maple.tree.dao.TalkLogDAO;
import psn.austus.maple.tree.entity.TalkLog;
import psn.austus.maple.tree.response.SpeakResponse;
import psn.austus.maple.tree.service.TalkService;
import psn.austus.maple.tree.tools.RedisTool;

import java.util.Date;

@Api("Talk Service")
@Slf4j
@RestController
public class TalkServiceImpl implements TalkService {

    @Autowired
    RedisTool redisTool;

    @Autowired
    TalkLogDAO talkLogDAO;


    @Override
    public SpeakResponse speak(String arg){
        SpeakResponse response = new SpeakResponse();

        String key = RedisKeys.SEPAK_REDIS_KEY+arg;
        String result =redisTool.getValue(key);

        if(StrUtil.isBlank(result)){

            switch (arg) {
                case "1":
                    result = "What should I do?";
                    break;
                case "2":
                    result = "Can we go to library?";
                    break;
                case "3":
                    result = "Let's go, we will have fun!";
                    break;
                default:
                    result = "It doesn't make sense, what do you mean?";
                    break;
            }
            redisTool.saveValue(key,result,60);
        }

        TalkLog log = new TalkLog();
        log.setQuestion(arg);
        log.setResponse(result);
        log.setCreateTime(new Date());
        talkLogDAO.insert(log);

        response.setCode("1");
        response.setMessage(result);

        return response;
    }
}
