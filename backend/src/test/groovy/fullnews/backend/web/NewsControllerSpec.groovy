package fullnews.backend.web

import spock.lang.Specification

class NewsControllerSpec extends Specification {

    def "fail"(){
        when:
            def a =1
        then:
            a==2
    }
}
