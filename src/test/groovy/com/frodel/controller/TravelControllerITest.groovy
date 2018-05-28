package com.frodel.controller

import com.frodel.model.Travel
import com.frodel.repositories.TravelRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.test.context.ContextConfiguration
import org.springframework.util.LinkedMultiValueMap
import org.springframework.util.MultiValueMap
import spock.lang.Specification

@ContextConfiguration
@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
class TravelControllerITest extends Specification {

    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired
    private TravelRepository travelRepository

    void "add a travel by calling url"() {

        when: "add travel requested"
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("name", "A travel");
        map.add("idCreator", "1");
        Travel travel = restTemplate.postForObject("/travel", map, Travel.class)

        then: "the recover name of travel is the same that the send name"
        travel.name.equals("A travel")

    }
}
