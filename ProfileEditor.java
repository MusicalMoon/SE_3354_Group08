package org.example;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//This program will allow a user to edit their profile name and description.
public class KimRuth_ProfileEditor  {

    static class Profile{

        //Variables to hold user data
        String name, description, userName;

        //User must "login" to edit their profile.
        public Profile(String userName) {
            this.userName = userName;
        }

        //Method to update entire profile
        public boolean updateProfile(String name, String description) {

            //Check name validity

            //Check if name is empty or only contains spaces
            if (name.trim().isEmpty()) {
                System.out.println("Please enter a valid name.");
                throw new IllegalArgumentException("Exception name");
            }
            //Check if name contains numerical or special characters
            Pattern p = Pattern.compile("[^a-z ]", Pattern.CASE_INSENSITIVE);
            Matcher m = p.matcher(name);
            boolean b = m.find();

            if (b) {		//name contains special characters
                System.out.println("Your name cannot contain any numbers or special characters.");
                return false;	    //Exit function
            }

            //Name has been validated. Update name
            this.name = name;




            //Check description validity

                //Check if description is empty or only contains spaces
                if(description.trim().isEmpty()) {
                    System.out.println("Please enter a valid description.");
                    throw new IllegalArgumentException("Exception description");
                }

                //Check if description exceeds maximum length
                if(description.length()> 400) {
                    System.out.println("Your description cannot exceed 400 characters.");
                    return false;	//Exit function
                }

                //Description has been validated. Update description
                this.description = description;



            //Show confirmation
            System.out.println("Your profile has been updated.");
            System.out.println("Name: " + name);
            System.out.println("Description: " + description);
            return true;
        }

        //Getters to obtain user information
        public String getName() 		{	return name;		}
        public String getDescription() 	{	return description;	}
        public String getUserName() 	{	return userName;	}


    }


}
