package com.frodel

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

/**
 * Created by hichem on 13/04/2018.
 */
@ContextConfiguration
@SpringBootTest
class UserServiceITest extends Specification{
    @Autowired UserService utilisateurService

    def "test sauvegarder un utilisateur valide"() {
        given: "valide utilisateur"
        User bob = new User(nom: "Deniro", prenom: "bob", email: "bob@deniro.com",sexe: "M")

        when: "l'utilisateur est enregistré"
        utilisateurService.saveUtilisateur(bob);

        then: "l'utilisateur à un id"
        bob.id != null

    }

    def "test sauvegarder un utilisateur non valide"() {
        given: "non valide utilisateur"
        User bob = new User(prenom: "bob", email: "bob@deniro.com",sexe: "M")

        when: "l'utilisateur est anregistré"
        utilisateurService.saveUtilisateur(bob);

        then: "une exception est levée"
        thrown ConstraintViolationException

        and: "bob has still null id"
        bob.id == null
    }

}
