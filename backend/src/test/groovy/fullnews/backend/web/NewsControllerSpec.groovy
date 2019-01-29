package fullnews.backend.web

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@AutoConfigureMockMvc
@WebMvcTest
class NewsControllerSpec extends Specification {

    @Autowired
    MockMvc mvc

    def "should get poland technology news"() {
        given:
        def country = "pl"
        def category = "technology"
        when:
        def result = mvc.perform(get("/facade/news/" + country + "/" + category))
        then:
        result.andExpect(status().isOk())
    }

}