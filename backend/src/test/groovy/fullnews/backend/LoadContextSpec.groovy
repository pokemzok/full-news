package fullnews.backend

import fullnews.backend.web.NewsController
import org.springframework.test.annotation.IfProfileValue
import org.springframework.test.context.ActiveProfiles
import spock.lang.Specification
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
@IfProfileValue(name="run.intregration.tests", value="true")
class LoadContextSpec extends Specification {

    @Autowired(required = false)
    private NewsController newsController

    def "when context is loaded then all expected beans should be created"() {
        expect: "the newsController is created"
        newsController
    }

}
