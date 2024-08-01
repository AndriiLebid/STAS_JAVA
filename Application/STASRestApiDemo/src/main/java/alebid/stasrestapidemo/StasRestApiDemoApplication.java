package alebid.stasrestapidemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"alebid.stasrestapidemo", "alebid.stasjavademo"})
public class StasRestApiDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(StasRestApiDemoApplication.class, args);
    }

}
