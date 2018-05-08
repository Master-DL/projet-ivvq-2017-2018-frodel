package com.frodel

import com.frodel.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.test.context.ContextConfiguration
import org.springframework.util.LinkedMultiValueMap
import org.springframework.util.MultiValueMap
import spock.lang.Specification

import javax.validation.ConstraintViolationException

/**
 * Created by hichem on 13/04/2018.
 */
@ContextConfiguration
@SpringBootTest(classes = TravexApplication.class,webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserControllerITest extends Specification{
    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired
    private UserRepository utilisateurRepository;

    void "test ajout d'un utilisateur"(String pseudo,String mdp,String email) {

        when: "un ajout d'utilisateur est demandé"
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("pseudo", pseudo);
        map.add("mdp", mdp);
        map.add("email", email);
        User utilisateur = restTemplate.postForObject("/inscriptions",map, User.class)

        then: "le retour fournit les informations de l'utilisateur créé"
        utilisateur.pseudo == pseudo
        utilisateur.mdp == mdp
        utilisateur.email == email
        where:
        pseudo   | mdp       | email
        "frodel" | "frodeltest"  | "frodel@frodel.fr"
    }

    void "test suppression d'un utilisateur"(Long user_id) {

        when: "un utilisateur est supprimeé"
        restTemplate.delete("/inscriptions/${user_id}")

        then: "il est effectivement supprimé de la base de donnée"
        !utilisateurRepository.findOne(user_id)

        where:
        user_id   |_
        1 |_
    }

}