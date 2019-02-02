package fullnews.backend.core;

import fullnews.backend.api.NewsResponse;
import fullnews.backend.api.newsapi.response.NewsApiResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class NewsService {

    private final NewsApiConfiguration newsApiConfiguration;

    public NewsResponse getNews(@NonNull String country, @NonNull String category) {
        var newsResponse = new NewsResponse(country, category, new ArrayList<>());

        var restTemplate = new RestTemplate();
        var responseEntity = restTemplate.getForEntity(newsApiUrl(country, category), NewsApiResponse.class);

        return newsResponse;
    }

    private String newsApiUrl(String country, String category) {
        return new NewsApiUrl(newsApiConfiguration, country, category).toString();
    }
}

