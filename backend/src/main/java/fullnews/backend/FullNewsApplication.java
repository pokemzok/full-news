package fullnews.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(value = "classpath:news-api-key.properties")
@EnableConfigurationProperties
public class FullNewsApplication {

    public static void main(String[] args) {
        SpringApplication.run(FullNewsApplication.class, args);
    }

}