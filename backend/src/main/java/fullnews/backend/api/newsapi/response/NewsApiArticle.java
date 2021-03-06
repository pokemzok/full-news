package fullnews.backend.api.newsapi.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;

@Getter
@Setter
@NoArgsConstructor
public class NewsApiArticle {

        private NewsSource source;
        private String author;
        private String title;
        private String description;
        private String url;
        private String urlToImage;
        private ZonedDateTime publishedAt;
        private String content;

}
