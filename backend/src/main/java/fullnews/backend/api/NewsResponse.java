package fullnews.backend.api;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@Builder
@Getter
@Setter
@NoArgsConstructor
public class NewsResponse {

    private String country;
    private String category;
    private List<Article> articles;

}
