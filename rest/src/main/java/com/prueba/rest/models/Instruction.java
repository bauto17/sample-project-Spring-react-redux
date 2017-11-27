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
public interface Instruction {
    
    public void addChild(Instruction i) throws Exception;
    public String printHtml();
}
