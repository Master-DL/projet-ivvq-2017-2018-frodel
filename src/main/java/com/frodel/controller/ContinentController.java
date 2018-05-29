package com.frodel.controller;

import com.frodel.model.Continent;
import com.frodel.services.ContinentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by leafo on 29/05/2018.
 */
@RestController
public class ContinentController {

    @Autowired
    private ContinentService continentService;

    @RequestMapping("/continent/{name}")
    public Continent getContinent(@PathVariable String name) {
        return continentService.findContinentByName(name);
    }

}
