/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.rest.services.parsers;

import com.prueba.rest.models.Instruction;

/**
 *
 * @author lbautisp
 */
public interface CodeParser {
    public Instruction parse(String code);
}
