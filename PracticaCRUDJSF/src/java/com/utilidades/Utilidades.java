/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utilidades;

import java.util.ArrayList;

/**
 *
 * @author Fabio
 */
public final class Utilidades {
    
    public static  final ArrayList<String>separarString(String completo, String seperador)
    {
        ArrayList<String> flag;
        String [] completoVector;
        System.out.println("Completo: " +completo);
        flag = new ArrayList<>();
        completoVector=completo.split(seperador);
        
        for(String str:completoVector)
        {
        flag.add(str);
        }
        
        return flag;
    }
    
    
    public static final String unirString(ArrayList<String> partes)
    {
    String flag;
    String str;
    flag="";
    for(int i=0; i<partes.size();i++)
    {
    str=partes.get(i);
    if(i==partes.size()-1)
    {
    flag += str;
    }
    else
    {
    flag += str + ",";
    }
        
    }
    return flag;
    }
}
