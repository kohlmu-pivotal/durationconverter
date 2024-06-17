package com.spring.example;

import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;

@RestController
public class TestController {

  private Environment environment;

  public TestController(Environment environment) {
    this.environment = environment;
  }

  @GetMapping("/")
  public String getTest() {
    return environment.getProperty("test", Duration.class, Duration.ZERO).toString();
  }
}
