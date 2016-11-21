package com.server.sms;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication      //启动入口
public class Application {
    private static Logger logger = Logger.getLogger(Application.class);

    /**
     * Main Start
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        logger.info("============= SpringBoot Start Success =============");
    }
}
