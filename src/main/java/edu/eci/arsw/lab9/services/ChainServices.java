/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.lab9.services;

import edu.eci.arsw.lab9.entities.Chain;
import edu.eci.arsw.lab9.entities.ChainRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

/**
 *
 * @author danielagonzalez
 */
@Service
public class ChainServices implements CommandLineRunner {

    @Autowired
    private ChainRepository repository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Connection established to MongoDB");
    }

    public List<Chain> getLastChains(){
        List<Chain> chains = repository.findAll();
        if (chains.size()>9){
            chains = chains.subList(chains.size()-10, chains.size());
        }
        return chains;
    }
    
    public List<Chain> getChains(){
        return repository.findAll();
    }

    public void postChain(String data, String date){
        repository.save(new Chain(data, date));
    }
}
