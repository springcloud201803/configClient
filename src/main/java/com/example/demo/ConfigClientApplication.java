package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * 分布式配置中心 ---------客户端
 * @author pain
 *
 */
@SpringBootApplication
@RestController
@EnableEurekaClient
@RefreshScope         //自动更新配置文件属性信息
public class ConfigClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigClientApplication.class, args);
	}
	@Value("${foo}")
	String foo;
	
	@RequestMapping("getPro")
	public String getPropertiy() {
		return "this is config-server property : foo="+foo;
	}
}
