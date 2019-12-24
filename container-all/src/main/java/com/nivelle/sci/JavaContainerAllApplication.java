package com.nivelle.sci;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.nivelle.sci")
public class JavaContainerAllApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaContainerAllApplication.class, args);
    }

}
