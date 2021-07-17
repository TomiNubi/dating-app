/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.datingapp;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Tomi
 */
public class registerUser {
    
    
     BufferedWriter output;
    public registerUser(String name, String password, String eyecolour, String haircolour ,int age, ArrayList<String> interest ) throws IOException{
        
        //allocated the desired file to the created bufferedWriter object where any appeneded
        //information would be written to. 
        
      output = new BufferedWriter(new FileWriter("src/dateFiles.txt", true));
       
      
      output.append(name+ ","+ age+ ","+ password + ","+eyecolour+ ","+ haircolour+  "," );
         
      for (String interest1 : interest) {
             output.append(interest1 + "-");
         }
        
         
      output.newLine();
      output.close();
        
    }
}
