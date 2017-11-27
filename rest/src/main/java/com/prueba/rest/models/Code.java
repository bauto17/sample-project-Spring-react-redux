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
public class Code {
    
    private final String content;

    public Code(){
        content="";
    }

    public Code(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
