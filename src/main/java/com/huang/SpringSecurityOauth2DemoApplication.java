package com.huang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class SpringSecurityOauth2DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityOauth2DemoApplication.class, args);
        System.out.println("http://localhost:8080/oauth/authorize?response_type=password&client_id=admin&redirect_uri=http://www.baidu.com&scope=all");
    }

}
