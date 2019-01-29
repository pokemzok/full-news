package fullnews.backend.web;

import fullnews.backend.api.NewsResponse;
import fullnews.backend.core.NewsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/facade/")
@Slf4j
@RequiredArgsConstructor
public class NewsController {

    private final NewsService newsService;

    @GetMapping("/news/{country}/{category}")
    public NewsResponse news(@PathVariable String country, @PathVariable String category){
        log.info("Received news request for country {} and category {}",country, category);
        return newsService.getNews(country, category);
    }

}
