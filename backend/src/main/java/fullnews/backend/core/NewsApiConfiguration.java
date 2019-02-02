package fullnews.backend.core;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties("newsapi")
@Component
@Getter
@Setter
public class NewsApiConfiguration {

    private String topHeadlinesUrl;
    private String key;

}
