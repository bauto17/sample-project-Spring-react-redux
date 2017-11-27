/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.rest.models;

/**
 *
 * @author lbautisp
 */
public class Text implements Instruction{
    
    private String Content;

    public Text(String content){
        this.Content=content;
    }
    
    @Override
    public String printHtml(){
        return (Content==null)?"":Content;
    }

    @Override
    public void addChild(Instruction i) throws Exception {
        throw new Exception("Sintax Error");
    }
    
}
