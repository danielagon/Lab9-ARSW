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
import org.springframework.data.annotation.Id;

public class Chain {

    @Id
    private String identifier;
    private String data;
    private String date;

    public Chain(String data, String date){
        this.data = data;
        this.date = date;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}