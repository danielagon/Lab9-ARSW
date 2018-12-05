/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.lab9;

import edu.eci.arsw.lab9.services.ChainServices;
import java.util.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author danielagonzalez
 */
@RunWith(SpringRunner.class)
@SpringBootTest()
public class ChainServicesTest {
    
    @Autowired
    private ChainServices services;
    
    @Test
    public void contextLoads(){           
    }
    
    @Test
    public void chainServicesTest(){
        int size = services.getChains().size();
        services.postChain("prueba", new Date().toString());
        services.postChain("monitor", new Date().toString());
        services.postChain("parcial", new Date().toString());
        services.postChain("cadena", new Date().toString());
        services.postChain("arquitectura", new Date().toString());
        org.junit.Assert.assertEquals(services.getChains().size(),size+5);
    }
}
