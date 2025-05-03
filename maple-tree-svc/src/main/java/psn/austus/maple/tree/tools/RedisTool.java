package psn.austus.maple.tree.tools;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class RedisTool {

        @Autowired
        private RedisTemplate<String, Object> redisTemplate;

        public void saveValue(String key, String value) {
            redisTemplate.opsForValue().set(key, value);
        }

        public void saveValue(String key, String value,long var3) {
            redisTemplate.opsForValue().set(key, value,var3,TimeUnit.SECONDS);
        }

        public void saveValue(String key, String value,long var3, TimeUnit var5) {
            redisTemplate.opsForValue().set(key, value,var3,var5);
        }

        public String getValue(String key) {
            return (String) redisTemplate.opsForValue().get(key);
        }


        public boolean delValue(String key) {
        return redisTemplate.delete(key);
    }

}

