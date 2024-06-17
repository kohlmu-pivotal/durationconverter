package com.spring.example;


import org.apache.geode.cache.client.ClientRegionShortcut;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.data.gemfire.config.annotation.ClientCacheApplication;
import org.springframework.session.data.gemfire.config.annotation.web.http.EnableGemFireHttpSession;

@SpringBootApplication
@ClientCacheApplication
@EnableGemFireHttpSession(clientRegionShortcut = ClientRegionShortcut.CACHING_PROXY, poolName = "DEFAULT")
public class Application {
  public static void main(String[] args) {
    new SpringApplicationBuilder().web(WebApplicationType.SERVLET).sources(Application.class).run(args);
  }
}
