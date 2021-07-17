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
public class malesdates extends dates{
    //creates dynamic arraylists of preset possible male dates and their details
  
    ArrayList<String> names = new ArrayList<>(Arrays.asList("John", "Doe", "Patrick", "Bobby", "Deshae"));
   ArrayList<Integer> age = new ArrayList<>(Arrays.asList(21, 44, 64, 28, 35));
   ArrayList<String> eyeColour = new ArrayList<>(Arrays.asList("brown", "blue", "green", "grey", "hazel"  ));
   ArrayList<String> hairColour = new ArrayList<>(Arrays.asList("green", "black", "ginger", "blonde", "brunette" ) );
   ArrayList<ArrayList<String>> interests = new ArrayList<>();
  
    /*the dates ranks come to play during the matching to rank dates that match the most 
      to the user's characteristics according  to the user's preferences*/
   ArrayList<Double> rank = new ArrayList<>(Arrays.asList(0.0,0.0,0.0,0.0,0.0));
  
   public malesdates(){
     interests.add(new ArrayList<> (Arrays.asList("Football", "Painting", "Reading" )));
     interests.add(new ArrayList<> (Arrays.asList("Golf", "Opera", "Writing" )));
     interests.add(new ArrayList<> (Arrays.asList("Swimming", "Theatre", "Photography" )));
     interests.add(new ArrayList<> (Arrays.asList("Basketball", " Music", "Dancing")));
     interests.add(new ArrayList<> (Arrays.asList("Cooking", "Hiking", "Gaming")));
          
   }
    
    
}
