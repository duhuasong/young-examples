package com.young.java.examples.rocketmq;

import com.young.java.examples.mq.MessageQueueException;
import com.young.java.examples.rocketmq.mq.RocketmqMessageQueue;
import com.young.java.examples.topic.MessageTopic;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by yangyong3 on 2017/7/6.
 */
public class RocketmqMessageQueueExample {
    public static void main(String[] args) throws MessageQueueException, IOException {
        Properties properties = new Properties();
        properties.load(RocketmqMessageQueueExample.class.getResourceAsStream("/rocketmq.properties"));
        MessageTopic<User> messageQueue = new RocketmqMessageQueue<User>("test",properties,true);
        for(int i=0;i<100;i++) {
            User user = new User();
            user.setName("123");
            user.setAge(30);
            messageQueue.send(user);
        }
        messageQueue.destory();
    }
}
