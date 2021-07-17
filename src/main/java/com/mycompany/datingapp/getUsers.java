/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.datingapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Tomi
 */
public class getUsers {
    
    ArrayList<String> nameArray = new ArrayList<>();
    ArrayList<String> passwordArray = new ArrayList<>();
    ArrayList<Integer> ageArray = new ArrayList<>();
    ArrayList<String> eyeColourArray = new ArrayList<>();
    ArrayList<String> hairColourArray = new ArrayList<>();
    ArrayList<ArrayList<String>> interestsArray = new ArrayList<>();
    File file = new File("src/dateFiles.txt");

    public getUsers() throws FileNotFoundException {
        //reads the data from the textfile and store the information in the created arrays.
        Scanner sc = new Scanner(file);
        int n = 0;
            
        while (sc.hasNextLine()) {

            String line = sc.nextLine();

            String[] elements = line.split(",");
            
          
            // placing the contents of each index into its own variable
            String name = elements[0];
            String age = elements[1];
            String password = elements[2];
            String eyeColour = elements[3];
            String hairColour = elements[4];
            String interests = elements[5];
            
           
            int intAge = Integer.parseInt(age); 
            //'interests' is a 2D array and has to be further split to get each of the individual interests
            String subinterest[] = interests.split("-");
            
            nameArray.add(name);
            passwordArray.add(password);
            ageArray.add(intAge);
            eyeColourArray.add(eyeColour);
            hairColourArray.add(hairColour);           
            interestsArray.add(new ArrayList());
                
            
            
            for(int i = 0; i< subinterest.length; i++){
                interestsArray.get(n).add(subinterest[i]);
            }
           // interestsArray.get(n).addAll(Arrays.asList(subinterest));
             n++;
           
            } 
       
            }
    
    public void showUsers(){
        System.out.println(nameArray);
        System.out.println(passwordArray);
        System.out.println(ageArray);
        System.out.println(eyeColourArray);
        System.out.println(hairColourArray);       
        System.out.println(interestsArray);
        
       
    }

            }
