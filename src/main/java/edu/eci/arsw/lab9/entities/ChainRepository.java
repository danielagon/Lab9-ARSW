/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.lab9.entities;

/**
 *
 * @author danielagonzalez
 */
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChainRepository extends MongoRepository<Chain, String>  {

    @Override
    public List<Chain> findAll();
    public Chain findByIdentifier(String identifier);
}
