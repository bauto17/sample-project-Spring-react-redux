/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.rest.models;

import java.util.ArrayList;

/**
 *
 * @author lbautisp
 */
public class H3 implements Instruction{
    
    private ArrayList<Instruction> childs;
    
    public H3(){
        childs = new ArrayList<>();
    }
    
    public void addChild(Instruction child){
        childs.add(child);
    }
    
    @Override
    public String printHtml() {
       String result = "<H3>"; 
       for(Instruction child : childs){
           result+=child.printHtml()+"\n";
       }
       result+="</H3>";
       return result;
    }
    
}