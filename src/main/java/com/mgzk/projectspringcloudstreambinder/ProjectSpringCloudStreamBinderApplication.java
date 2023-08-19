package com.mgzk.projectspringcloudstreambinder;

import java.time.LocalDateTime;
import java.util.function.Supplier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProjectSpringCloudStreamBinderApplication {

  Logger logger = LoggerFactory.getLogger(ProjectSpringCloudStreamBinderApplication.class);

  public static void main(String[] args) {
    SpringApplication.run(ProjectSpringCloudStreamBinderApplication.class, args);
  }

  @Bean
  public Supplier<String> ping() {
    return () -> {
      String message = String.format("[%s] Ping", LocalDateTime.now());
      logger.info("Produces message: " + message);
      return message;
    };
  }
}
