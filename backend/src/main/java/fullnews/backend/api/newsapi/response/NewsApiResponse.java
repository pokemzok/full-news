package fullnews.backend.api.newsapi.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class NewsApiResponse {

    private Integer totalResults;
    private String status;
    private List<NewsApiArticle> articles;

}
