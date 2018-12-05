/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.lab9.entities;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author danielagonzalez
 */
public interface ApplicationUserRepository extends MongoRepository<ApplicationUser, Long>{
    
    ApplicationUser findByUsername(String username);
}
