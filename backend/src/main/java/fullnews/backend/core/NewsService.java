package fullnews.backend.core;

import fullnews.backend.api.NewsResponse;
import fullnews.backend.api.newsapi.response.NewsApiResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class NewsService {

    private final NewsApiConfiguration newsApiConfiguration;

    public NewsResponse getNews(@NonNull String country, @NonNull String category) {
        var responseEntity = new RestTemplate().getForEntity(newsApiUrl(country, category), NewsApiResponse.class);
        return new NewsResponseBuilder()
                .apiResponse(responseEntity.getBody())
                .category(category)
                .country(country)
                .build();
    }

    private String newsApiUrl(String country, String category) {
        return new NewsApiUrl(newsApiConfiguration, country, category).toString();
    }
}

