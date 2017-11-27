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
public class Base implements Instruction{
    
    private ArrayList<Instruction> childs;
    private String title="";
    public Base(){
        childs = new ArrayList<>();
    }
    
    public void addChild(Instruction child){
        childs.add(child);
    }
    
    public void addTitle(String title){
        this.title=(title);
    }
    
    @Override
    public String printHtml() {
       String result = "";
       result +="<html>\n";
       result +="<head>\n";
       result +="<title>\n";
       result +=title;
       result +="</title>\n";
       result +="</head>\n";
       result +="</body>\n";
       for(Instruction child : childs){
           result+=child.printHtml()+"\n";
       }
       result +="</body\n";
       result +="</html>\n";
       result +="</html>\n";
       return result;
    }
    
}
