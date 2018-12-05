/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.lab9.restcontroller;

import edu.eci.arsw.lab9.services.ChainServices;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author danielagonzalez
 */
@RestController
@RequestMapping(value = "/request")
public class ChainAPIController {
    
    @Autowired
    private ChainServices request;

    @RequestMapping(method = RequestMethod.GET)
    ResponseEntity<?> getChains() throws Exception{
        return new ResponseEntity<>(request.getLastChains(),HttpStatus.ACCEPTED);
    }

    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity<?> postChain(@RequestBody String chain){
        try{
            Date date = new Date();
            request.postChain(chain.split("=")[0], date.toString());
            request.getLastChains();
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }catch (Exception ex){
            return new ResponseEntity<>(ex, HttpStatus.FORBIDDEN);
        }
    }
}
