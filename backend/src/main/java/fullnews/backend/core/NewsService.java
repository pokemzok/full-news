package fullnews.backend.core;

import fullnews.backend.api.NewsResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Service
public class NewsService {

    private String newsApiHeadlinesUrl;
    private String newsApiKey;

    public NewsService(
            @Value("${newsapi.top-headlines.url}") String newsApiHeadlinesUrl,
            @Value("${newsapi.key}") String newsApiKey
    ) {
        this.newsApiHeadlinesUrl = newsApiHeadlinesUrl;
        this.newsApiKey = newsApiKey;
    }

    //FIXME TestNG] [ERROR] No test suite found. Nothing to run
    public NewsResponse getNews(String country, String category){
        var newsResponse = new NewsResponse(country, category, new ArrayList<>());
        RestTemplate restTemplate = new RestTemplate();

        // Think about next test (where should it be? Should test integration with news api)

        return newsResponse;
    }

}

