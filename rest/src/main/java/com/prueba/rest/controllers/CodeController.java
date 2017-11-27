package com.prueba.rest.controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.prueba.rest.models.Code;
import com.prueba.rest.services.CodeService;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author lbautisp
 */
@RestController
public class CodeController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
   
    @Autowired
    private CodeService service;

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value="/code", method = RequestMethod.POST)
    public ResponseEntity<Code> codeToHtml(@RequestBody Code code) {   
        System.out.println("content:"+code.getContent());
        return new ResponseEntity<Code>(new Code(service.TraductorToHtml(code)), HttpStatus.OK);
    }
    
    public void setService(CodeService service) {
        this.service = service;
    }
    
}
