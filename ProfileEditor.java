import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//This program will allow a user to edit their profile name and description.
public class ProfileEditor {

	//Main method will check test cases for Profile Editor.
	public static void main(String[] args) {
	
		
		//Very long string to test invalid profile description
		String veryLongString = "";
		for(int i = 0; i < 100; i++) {
			veryLongString += "hello";
		}
		
		//Array to hold test cases
		String [][] tests = {
					{"John Smith", "Hello"},		//Case 1, valid, valid
					{"John Smith", veryLongString},	//Case 2, valid, invalid
					{"John Smith", " "},				//Case 3, valid, exception
					{"12345","Hello"},				//Case 4, invalid, valid
					{" ", "Hello"}};					//Case 7, exception, valid
		
		//"Login" to profile by creating profile object
		String userName = "user";
		Profile userProfile = new Profile(userName);
		
		//Case 1: Test profile editor with valid name and valid description
				System.out.println("VALID name, VALID description:");
				userProfile.updateProfile(tests[0][0], tests[0][1]);
				System.out.println();
		
		//Case 2: Test profile editor with valid name and invalid description
				System.out.println("VALID name, INVALID description:");
				userProfile.updateProfile(tests[1][0], tests[1][1]);
				System.out.println();
				
		//Case 3: Test profile editor with valid name and exception description
				System.out.println("VALID name, EXCEPTION description:");
				userProfile.updateProfile(tests[2][0], tests[2][1]);
				System.out.println();
				
		//Case 4: Test profile editor with invalid name and valid description
				System.out.println("INVALID name, VALID description:");
				userProfile.updateProfile(tests[3][0], tests[3][1]);
				System.out.println();
				
		//Case 7: Test profile editor with exception name and valid description
				System.out.println("EXCEPTION name, VALID description:");
				userProfile.updateProfile(tests[4][0], tests[4][1]);
				System.out.println();
			
		
        //Create scanner for user input
        Scanner input = new Scanner(System.in);

        //Boolean for user to update profile
        boolean testAgain = true;
        
        //Additional tests using user input (for grader's convenience)
        while (testAgain) {
	        System.out.println("Please enter a name:");
	        String inputName = input.nextLine();
	        
	        System.out.println("Please enter a profile description:");
	        String inputDescription = input.nextLine();
	        
	        userProfile.updateProfile(inputName, inputDescription);
	        System.out.println();
	        
	        System.out.println("Would you like to re-update your profile? Y/N");
	        String response = input.nextLine();
	        
	        if (response.equalsIgnoreCase("N")|| response.equalsIgnoreCase("NO")) {
	        		testAgain = false;
	        		System.out.println("Goodbye");
	        }
	     
	        }
        }
	
	static class Profile{
		
		//Variables to hold user data
		String name, description, userName;
		
		//User must "login" to edit their profile.
		public Profile(String userName) {
			this.userName = userName;
		}
		
		//Method to update entire profile
		public void updateProfile(String name, String description) {
			
			//Check name validity
			try {
				//Check if name is empty or only contains spaces
				if (name.trim().isEmpty()) {
					throw new Exception();
				}
				//Check if name contains numerical or special characters
				Pattern p = Pattern.compile("[^a-z ]", Pattern.CASE_INSENSITIVE);
				Matcher m = p.matcher(name);
				boolean b = m.find();

				if (b) {		//name contains special characters
				   System.out.println("Your name cannot contain any numbers or special characters.");
				   return;	//Exit function
				}
				
				//Name has been validated. Update name
				this.name = name;
			}
			//User entered empty input
			catch(Exception ex){
				System.out.println("Please enter a valid name.");
				return;	//Exit function
			}
		
			
			
			//Check description validity
			try {
				//Check if description is empty or only contains spaces
				if(description.trim().isEmpty()) {
					throw new Exception();
				}
				
				//Check if description exceeds maximum length
				if(description.length()> 400) {
					System.out.println("Your description cannot exceed 400 characters.");
					return;	//Exit function
				}
				
				//Description has been validated. Update description
				this.description = description;
				
			}
			catch(Exception ex) {
				System.out.println("Please enter a valid description.");
				return; //Exit function
			}
			
			//Show confirmation
			System.out.println("Your profile has been updated.");
			System.out.println("Name: " + name);
			System.out.println("Description: " + description);
			
		}

		//Getters to obtain user information
		public String getName() 		{	return name;		}
		public String getDescription() 	{	return description;	}
		public String getUserName() 	{	return userName;	}

		
	}
	
	
}