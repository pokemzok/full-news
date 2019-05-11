package fullnews.backend.core


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import spock.lang.Specification

@SpringBootTest
@ActiveProfiles("integration-tests")
class NewsServiceSpec extends Specification {

    @Autowired
    private NewsService newsService

    def "should get response from News API "() {
        when:
        def response = newsService.getNews(country, category)
        then:
        response.category == category
        response.country == country
        response.articles.size() >= 0
        where:
        country | category
        "pl"    | "technology"
        "en"    | "science"
        "typo"  | "typo"
    }
}
