/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.datingapp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

/**
 *
 * @author Tomi
 */
public class matchAlgorithms extends userHome{
    
    
    String priority1, priority2, priority3, priority4,  gender;
    malesdates maledate;
    femaledates femaledate;
    userHome user;
    

    public matchAlgorithms(userHome user) {
        this.user = user;
        priority1 = user.getPriorityOne();
        priority2= user.getPriorityTwo();
        priority3 = user.getPriorityThree();
        priority4 = user.getPriorityFour();
        gender= user.getChosenGender();
       
        
       maledate = new malesdates();
       femaledate = new femaledates();
       
    } 
   
    public int match(){
        
       //set the rank factor for the first priority to 4 and decrease it with a decrease in prioroty
        
        rank(priority1, 4);       
        rank(priority2, 3);       
        rank(priority3, 2);        
        rank(priority4, 1);
       
        
        // compare the total ranks of the dates and return the index person with the highest rank
        double highestValue = 0;
        int highestIndex = -1;
        switch(gender){
            case "male":
                
                for(int i =0; i<maledate.rank.size() ; i++){
                    if(highestValue < maledate.rank.get(i)) {
                        highestValue =  maledate.rank.get(i);
                        highestIndex = i;
                   
                    }            
                }
                
                if(highestIndex == -1){
                
                    return RandomDate();
                }
                else
                    //returns the person ranked with the most matches
                    return highestIndex;
                
            case "female":
                
                for(int i =0; i<femaledate.rank.size() ; i++){
                    if(highestValue < femaledate.rank.get(i)) {
                        highestValue = (femaledate.rank.get(i));
                        highestIndex = i;
                     
                    }                   
                
                }
                
                if(highestIndex == -1){
                
                    return RandomDate();
                }
                else
                    //returns the person ranked with the most matches
                    return highestIndex;
            default :
                return -1;
                    
        }
    
    }
    
     public void rank (String matchFactor, int rankFactor) {
         ArrayList<Integer> options;
         
         //based on the match factor, rank all the users in the array returned from the match factor
         //algorithms and increase their rank by the specified 'rank factor'
        
         switch (matchFactor){
            case "Age range":           
                            
               options = ageRange(user.getAge());    
               
                for (int option: options){
                    
                switch(gender){
                    case "male":
                       maledate.rank.set(option, maledate.rank.get(option) + rankFactor);
                       break;
                            //increases its rank by a certain factor.
                    case "female":
                        femaledate.rank.set(option, femaledate.rank.get(option) + rankFactor);
                        break;
                }
                }
             
                return;
            case "Eye Colour":
                options = eyeColour(user.getEyeColour());   
                
                for (int option: options){
                switch(gender){
                    case "male":
                       maledate.rank.set(option, maledate.rank.get(option) + rankFactor);
                       break;
                            //increases its rank by a certain factor.
                    case "female":
                        femaledate.rank.set(option, femaledate.rank.get(option) + rankFactor);
                        break;
                }
                }
                return;
                
            case "Hair Colour":
                options = hairColour(user.getHairColour());
                for (int option: options){
                switch(gender){
                    case "male":
                       maledate.rank.set(option, maledate.rank.get(option) + rankFactor);
                       break;
                            //increases its rank by a certain factor.
                    case "female":
                        femaledate.rank.set(option, femaledate.rank.get(option) + rankFactor);
                        break;
                }
                }
                return;
                
             
            
            case "Interests" :
               
                
                HashMap<Integer, Double> interestOptions = interests(user.getInterests());
                
                for(int k: interestOptions.keySet()){
                    
                    double interestFactor =  (interestOptions.get(k) * rankFactor);
  
                switch(gender){
                   
                    case "male":
                       
                         maledate.rank.set(k, maledate.rank.get(k) + interestFactor);
                         
                       break;
                       
                    case "female":
                         femaledate.rank.set(k, (femaledate.rank.get(k) + interestFactor));
                         break;
                }
                }
                
                
        
        }
    }
     
     //the algorithms based on ageRange, hairColour, Eye colour and interests.
    
     //AGE
   
     public ArrayList<Integer> ageRange(int age){
        ArrayList<Integer> index = new ArrayList<>();
        
        /*access either maledates class/ femaledates class based on chosen gender and enters 
        the index of any dates within a 5 year AGE bracket of the user, into an arraylist so
        that all possible users can be considered*/
        switch(gender){
        case "male" :           
            
            for (int i =0; i< maledate.age.size(); i++){
             if( age <= ( maledate.age.get(i) + 5) && age >= (maledate.age.get(i) - 5) ){
              index.add(i);
             }
            }
             return index;
        
        
        case "female": 
         
         for (int i =0; i< femaledate.age.size(); i++){
             if( age <= ( femaledate.age.get(i) + 5) && age >= (femaledate.age.get(i) - 5) ){
              index.add(i);
             }
            }  
          return index;
        default:
             return index;
          }
        
       
    }
    
    //HAIRCOLOUR
    
    public ArrayList<Integer> hairColour (String hairColour){
     ArrayList<Integer> index = new ArrayList<>();
     
     /*access either maledates class/ femaledates class based on desired gender and enters 
        the index of any dates within a similar HAIRCOLOUR as the user, into an arraylist so
        that all possible users can be considered*/
    
     switch(gender){
         case "male":
            for (int i =0; i< maledate.hairColour.size(); i++){
             if (hairColour.equals(maledate.hairColour.get(i))){
             index.add(i);
             
             }
             
            } 
            return index;
         case "female":
         for (int i =0; i< femaledate.hairColour.size(); i++){
             if (hairColour.equals(femaledate.hairColour.get(i))){
             index.add(i);
             
             }
            
         }
          return index;
         default:
             return index;
             
     }
    }
  
    //EYECOLOUR
   
    public ArrayList<Integer> eyeColour (String eyeColour){
     ArrayList<Integer> index = new ArrayList<>();
     
     /*access either maledates class/ femaledates class based on desired gender and enters 
        the index of any dates within a similar EYECOLOUR as the user, into an arraylist so
        that all possible users can be considered*/
     
     switch(gender){
         case "male":
            for (int i =0; i < maledate.eyeColour.size(); i++){
             if (eyeColour.equals(maledate.eyeColour.get(i))){
             index.add(i);
             
             }
             
            } 
            return index;
         case "female":
         for (int i =0; i< femaledate.eyeColour.size(); i++){
             if (eyeColour.equals(femaledate.eyeColour.get(i))){
             index.add(i);
               }
              }
         return index;
         default:
             return index;
             
     }
    }
    
    
    //INTERESTS
    
    public HashMap<Integer, Double > interests(ArrayList<String> interests){
       
       HashMap<Integer, Double> index = new HashMap<>();
       double percent;
       
       /* Loops through the INTERESTS of the possible dates and compares it to the INTERESTS of the user
       As both have multiple INTERESTS, the index of any date with at least one similarity, is
       mapped in the Hashmap with the ratio of the similar interests they have.
       (the would be 1 when the date shares all the user's interest)*/
        
       switch (gender){
            case "male":
        
                for(int i = 0; i <maledate.interests.size(); i++){
                     int  count = 0;
                    for (int j = 0; j< maledate.interests.get(i).size(); j ++){
                     
                      for(String interest : interests){
                          if(interest.equals(maledate.interests.get(i).get(j))){
                             count++; // count represents the amount of similar interests they have
                          }
                      }
                     
                }
                    
                    if(count > 0){
                     if (count <= interests.size()){
                          percent = ((double)count/ interests.size());
                      }
                      else{
                          percent = 1;
                      }
                      index.put(i, percent );
                     }// percent is the ratio of the dates interest to the user's

                    }

                
                return index;
                
            case "female":
                 for(int i = 0; i <femaledate.interests.size(); i++){
                       int  count = 0;                    
                    for (int j = 0; j< femaledate.interests.get(i).size(); j ++){

                      for(String interest : interests){
                          if(interest.equals(femaledate.interests.get(i).get(j))){
                             count++;

                          }

                      }
                    

                    }
                     if(count > 0){
                        if (count <= interests.size()){
                          percent = ((double)count/ interests.size());
                      }
                      else{
                          percent = 1.0;
                      }
                      index.put(i, percent );
                     } 
                }
                return index;
                
            default:
                return index;
        }    
    }
        
       

    
     public int RandomDate(){
           
         //generate random index of the length of the male/femaledates array
             Random rand = new Random();
             int index  =  rand.nextInt(maledate.names.size()-1);
             return index;
     }
     
     
     
     public String dateIdeas(ArrayList<String> userInterests, ArrayList<String> dateInterests){
     
     String dateIdea = "null";
     
     //create an array list 'dateIdeas' of possible date Ideas .
     ArrayList<String> dateIdeas = new ArrayList<>(Arrays.asList("Movie in the Cinema", "Musical in the Theatre", "Restaurant ", "Football games", "Netflix and Chill", "Gaming Marathon", "Writer's retreat", "Reading in the Garden", "Cooking Ratatouille" ,"Hiking Trail in the Woods", "Dancing Show", "Painting landscapes"));
    
     for (int i =0; i<  userInterests.size(); i++){
         for(int  j= 0; j < dateInterests.size(); j ++){
         
             /*check if the users and chosen dates have similar interest and return one of the date ideas that 
         is related to that interest. It returns a random date if none is found */
         
         if(userInterests.get(i).equals(dateInterests.get(j))){       
           
              for(int k = 0; k <dateIdeas.size(); k++){
                  
                  if (dateIdeas.get(k).contains(dateInterests.get(j))){
                        dateIdea = dateIdeas.get(k);   
                        break;
                  }                  
              }                   
         }
         
         }
     }
     if (dateIdea.equals("null")){
     
         
             Random rand = new Random();
             int index  =  rand.nextInt(dateIdeas.size()-1);
             
             dateIdea = dateIdeas.get(index);
     
     }
     
     return dateIdea;
     }
    
}
