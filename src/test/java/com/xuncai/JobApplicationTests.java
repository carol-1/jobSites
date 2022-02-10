package com.xuncai;

import com.xuncai.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class JobApplicationTests {
      //如何使用：测试redis
    @Autowired
    private RedisTemplate redisTemplate;
    @Test
    void contextLoads() {
        redisTemplate.opsForValue().set("name","xiaoming");
        System.out.println(redisTemplate.opsForValue().get("name"));
        User user = new User();
        user.setId(1);
        user.setUserName("admin");
        redisTemplate.opsForValue().set("user",user);
        User user1 = (User)redisTemplate.opsForValue().get("user");
        System.out.println(user1.getId());
        System.out.println(user1.getUserName());
    }

}
