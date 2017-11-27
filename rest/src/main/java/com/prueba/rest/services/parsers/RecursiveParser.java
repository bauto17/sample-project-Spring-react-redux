/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.rest.services.parsers;


import com.prueba.rest.models.Base;
import com.prueba.rest.models.Div;
import com.prueba.rest.models.H1;
import com.prueba.rest.models.H2;
import com.prueba.rest.models.H3;
import com.prueba.rest.models.H4;
import com.prueba.rest.models.H5;
import com.prueba.rest.models.H6;
import com.prueba.rest.models.Instruction;
import com.prueba.rest.models.P;
import com.prueba.rest.models.Text;
import java.util.StringTokenizer;
import org.springframework.stereotype.Service;

/**
 *
 * @author lbautisp
 */
@Service
public class RecursiveParser implements CodeParser{
    
    private final String[] KEY = {"#","##","###","####","#####","######","@","%","&"}; 

    @Override
    public Instruction parse(String code) {
        Base base = new Base();
        try {
            String[] lines = code.split("\n");
            for (int i = 0; i < lines.length; i++) {
                StringTokenizer st = new StringTokenizer(lines[i]);
                if(lines[i].charAt(0)!='%'){
                    Instruction child = getInstruction(st,1);
                    base.addChild(child);
                }else{
                    st.nextToken();
                    base.addTitle(fullText(st));
                }
            }
            return base;
        } catch (Exception e) {
            e.printStackTrace();
            return new Text(code);
        }
    }

    private Instruction getInstruction(StringTokenizer st,int stack) throws Exception {
        Instruction i= null;
        if(st.hasMoreTokens()){
            String key = st.nextToken();
            System.out.println("inicia con key: "+key);
            if(isToken(key)){
                System.out.println("es una instruccion");
                i = instructionFactory(key);
                i.addChild(getInstruction(st,stack+1));
            }else{
                System.out.println("es un texto");
                if (stack==1) {
                    throw new Exception("Error de sintaxis");
                }
                i = new Text(key+ " " + fullText(st));
            }
        }else{
            throw new Exception("Sintax Error");
        }
                
        return i;
    }

    private String fullText(StringTokenizer st) {
        String response="";
        if(st.hasMoreTokens()){
            response+=st.nextToken();
            while (st.hasMoreTokens()) {                
                response+=(" "+st.nextToken());
            }
        }
        return response;
    }

    private boolean isToken(String key) {
        boolean response = false;
        for (int i = 0; i < KEY.length && !response; i++) {
            if(KEY[i].equals(key)){
                response = true;
            }
        }
        return response;
    }

    private Instruction instructionFactory(String token) throws Exception {
        Instruction i=null;
        String key= token;
        switch(key){
            case "#":
                i= new H1();
                break;
            case "##":
                i= new H2();
                break;
            case "###":
                i= new H3();
                break;
            case "####":
                i= new H4();
                break;
            case "#####":
                i= new H5();
                break;
            case "######":
                i= new H6();
                break;
            case "@":
                i= new Div();
                break;
            case "&":
                i= new P();
                break;
            default:
                throw new Exception("Sintax Error ");
        }
        return i;
    }

}
