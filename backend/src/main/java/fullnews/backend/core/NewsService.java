package fullnews.backend.core;

import fullnews.backend.api.NewsResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class NewsService {

    public NewsResponse getNews(String country, String category){
        var newsResponse = new NewsResponse(country, category, new ArrayList<>());
        // FIXME integration with https://newsapi.org
        // Think about next test (where should it be? Should test integration with news api)
        return newsResponse;
    }

}

