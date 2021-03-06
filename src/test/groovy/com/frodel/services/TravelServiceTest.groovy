package com.frodel.services

import com.frodel.model.Article
import com.frodel.model.Travel
import com.frodel.model.User
import com.frodel.repositories.TravelRepository
import com.frodel.services.TravelService
import org.springframework.data.repository.PagingAndSortingRepository
import spock.lang.Specification

/**
 * Created by Marianna on 13/04/2018.
 */
class TravelServiceTest extends Specification{


    TravelService travelService
    TravelRepository travelRepository


    void setup() {
        travelRepository = Mock()
        travelService = new TravelService()
        travelService.travelRepository = travelRepository
    }

    def "check type of travelRepository"() {
        expect: "travelRepository is a Spring repository"
        travelRepository instanceof PagingAndSortingRepository
    }

    def "test delegation of save of an Travel to the repository"() {
        given: "a travel"
        def travel = Mock(Travel) {
            getSteps() >> Arrays.asList(Mock(Article))
            getPrincipalArticle() >> Mock(Article)
            getCreator() >> Mock(User) {
                getTravels() >> []
            }
        }

            when: "the travel is saved"
            travelService.saveTravel(travel);

            then: "the save is delegated to the travelRepository"
            1 * travelRepository.save(travel)
        }


    def "test delegation of finding all travels to the repository"() {
        when: "requesting for all travels"
        travelService.findAllTravels()

        then: "the request is delegated to the travelRepository"
        1 * travelRepository.findAll()
    }

    def "test delegation of finding a travel by its name to the repository"() {
        when: "requesting for a travel by its name"
        travelService.findTravelByName("Mon voyage au Japon")

        then: "the request is delegated to the travelRepository"
        1 * travelRepository.findTravelByName("Mon voyage au Japon")
    }

    def "test delegation of finding a travel by its id to the repository"() {
        when: "requesting for a travel by its id"
        travelService.findTravelById(1)

        then: "the request is delegated to the travelRepository"
        1 * travelRepository.findOne(1)
    }

    def "test delegation of finding all articles for a travel to the repository"() {
        when: "requesting for all articles"
        travelService.findAllArticlesForTravel(1)

        then: "the request is delegated to the travelRepository"
        1 * travelRepository.findOne(1)
    }
}
