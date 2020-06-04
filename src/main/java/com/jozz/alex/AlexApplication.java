package com.jozz.alex;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@Slf4j
@MapperScan("com.jozz.alex.mapper")
@SpringBootApplication
public class AlexApplication {

	public static void main(String[] args) {
		try {
			SpringApplication.run(AlexApplication.class, args);
			log.info("===========启动成功===========");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
