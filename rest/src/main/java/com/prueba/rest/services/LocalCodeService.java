/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.rest.services;

import com.prueba.rest.models.Code;
import com.prueba.rest.services.parsers.CodeParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lbautisp
 */
@Service
public class LocalCodeService implements CodeService{
    
    @Autowired
    private CodeParser parser;

    public void setParser(CodeParser parser) {
        this.parser = parser;
    }
    
    @Override
    public String TraductorToHtml(Code code) {
        String response = parser.parse(code.getContent()).printHtml();
       return response;
    }
    
    
    
}
