package fullnews.backend.web;

import fullnews.backend.api.NewsResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/facade/")
@Slf4j
public class NewsController {


    @GetMapping("/news/{country}/{category}")
    public NewsResponse news(@PathVariable String country, @PathVariable String category){
        log.info("Received news request for country {} and category {}",country, category);
        return new NewsResponse(); // FIXME service implementation
    }

}
