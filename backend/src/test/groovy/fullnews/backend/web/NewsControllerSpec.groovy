package fullnews.backend.web

import com.fasterxml.jackson.databind.ObjectMapper
import fullnews.backend.api.NewsResponse
import fullnews.backend.core.NewsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification
import spock.mock.DetachedMockFactory

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest
class NewsControllerSpec extends Specification {

    @Autowired
    private MockMvc mvc

    @Autowired
    private NewsService newsService

    @Autowired
    private ObjectMapper objectMapper

    def "should get no poland technology news"() {
        given:
        def country = "pl"
        def category = "technology"
        and:
        newsService.getNews(country, category ) >> new NewsResponse(country,category, new ArrayList<>())
        when:
        def result = mvc.perform(get("/facade/news/" + country + "/" + category))
        def response = result.andReturn().response
        then:
        result.andExpect(status().isOk())
        with(objectMapper.readValue(response.contentAsString, Map)){
            it.country == country
            it.category == category
            it.articles.size == 0
        }
    }

    @TestConfiguration
    static class MockConfig {
        def detachedMockFactory = new DetachedMockFactory()

        @Bean
        NewsService newsService() {
            return detachedMockFactory.Stub(NewsService)
        }
    }

}