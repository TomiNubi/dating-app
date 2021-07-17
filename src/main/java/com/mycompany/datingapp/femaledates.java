/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.datingapp;

import java.util.ArrayList;
import java.util.Arrays;


/**
 *
 * @author Tomi
 */
public class femaledates extends dates{
    
   //creates a dynamic arraylist of preset possible female dates and their details
    
   ArrayList<String> names = new ArrayList<>(Arrays.asList("Amelie", "Rihal", "Joanna", "Yiyao", "Stephanie"));
   ArrayList<Integer> age = new ArrayList<>(Arrays.asList(34, 43, 17, 32, 22));
   ArrayList<String> eyeColour = new ArrayList<>(Arrays.asList("brown", "blue", "green", "grey", "hazel"  ));
   ArrayList<String> hairColour = new ArrayList<>(Arrays.asList("red", "black", "brunette", "blonde", "white" ) );
   ArrayList<ArrayList<String>> interests = new ArrayList<>();
   
   /*the dates ranks come to play during the matching to rank dates that match the most 
      to the user's characteristics according  to the user's preferences*/
   ArrayList<Double> rank = new ArrayList<>(Arrays.asList(0.0,0.0,0.0,0.0,0.0));
  
   public femaledates(){
       
     interests.add(new ArrayList<> (Arrays.asList("Hockey", "Dancing", "Writing" )));
     interests.add(new ArrayList<> (Arrays.asList("Yoga", "Photography", "Cooking" )));
     interests.add(new ArrayList<> (Arrays.asList("Painting", "Singing", "Hiking" )));
     interests.add(new ArrayList<> (Arrays.asList("Gaming", "Theatre", "Cooking" )));
     interests.add(new ArrayList<> (Arrays.asList("Football", "Drama", "Dancing")));
          
                             
   }
    
}
