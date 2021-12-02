package iCheck;
import java.util.Scanner;
import java.io.*;

public class MainProgram {

	  static Scanner kb = new Scanner(System.in);
	  static Driver[] accounts = new Driver[100];		// the array that stores data read from the Driver file
	  static Driver[] person = new Driver[100];		// the array that stores data from the Infringement file
	  static int offender[] = new int[100];								// the array that stores data about the speed from the Infringement file
		
	  public static void main(String[] args) throws IOException {
	    String fileName;				// the name of the file to read data from if the Driver file does not contain
	    int selections;					// user's selection for the menu
	    String fileName1 = null; 		// the name of the Infringement file
	    File myFile1 = null;			// the Infringement file
	    int change = 0;					// to check whether data has changed or not
	    int save = 0;					// to check whether data has saved or not
	    String choice = null;			// user's choice to exit the program or not
			
	    File myFile = new File("Driver.Txt");
	    while(!myFile.exists()) {
	      System.out.println("The Driver file does not exists.");
	      System.out.println("Please provide another filename that contains the Driver data.");
	      fileName = kb.next();
	      myFile = new File(fileName);
	    }
		    
		Scanner inputFile = new Scanner(myFile);
		processingDriver(inputFile);
			
		usersSelection();
		do {
		  selections = kb.nextInt();
		  System.out.println("You chose option " + selections);
		  System.out.println();
			  
		  switch (selections) {
		    case 1:
		      selectionSort();
		      displayingDriver(inputFile);
		      break;
			      
		    case 2:
		      fileName1 = choosingInfringement();
		      myFile1 = new File(fileName1);
		      Scanner inputFile1 = new Scanner(myFile1);
		      importingInfringement(inputFile1);
		      applyingPenalties();
		      change = 1;
		      save = 0;
			  break;
				  
		    case 3:
		      generatingSuspension();
			  break;
				  
		    case 4:
		      savingRecords(myFile);
		      save = 1;
		      change = 0;
			  break;
				  
		    case 5:
		      choice = exitingProgram(change, save);
			  break;
				  
			default:
			  System.out.println("Your selection was out of range.");
			  System.out.println("Please re-enter your choice.");
			  break;
		  }
			  
		  if( (selections != 5) || ((choice != null) && (choice.equalsIgnoreCase("N"))) )
		    usersSelection();
		  else
			System.out.println("Bye!");
			  
		} while( (selections != 5) || ((choice != null) && (choice.equalsIgnoreCase("N"))) );
			
		kb.close();
		inputFile.close();
	  }
	  
	  /**
	   * read data from the input file and store them in an array
	   * @param file - the input file
	   */
	  public static void processingDriver(Scanner file) {
		String str;
		String[] tokens;
	    
	    for (int i = 0; i < accounts.length; i++) {
	      accounts[i] = new Driver();
	      
		  if (file.hasNext()) {
		    str = file.nextLine();
		    tokens = str.split(",");
		    for (int j = 0; j < tokens.length; j++) {
		      
		      switch(j) {
			    case 0:
		 	      accounts[i].setLicenceNo(tokens[j]);
				  break; 
				  
			    case 1:
				  accounts[i].setLicenceClass(tokens[j]);
				  break;
				  
				case 2:
		  		  accounts[i].setFirstName(tokens[j]);
				  break;
				  
				case 3:
				  accounts[i].setLastName(tokens[j]);
				  break;
				  
			    case 4:
				  accounts[i].setAddress(tokens[j]);
				  break;
				  
			    case 5:
				  accounts[i].setSuburb(tokens[j]);
				  break;
				  
			    case 6:
			      accounts[i].setPostCode(tokens[j]);
				  break;
				  
			    case 7:
			      int point = Integer.valueOf(tokens[j]);
			      accounts[i].setDemeritPoint(point);
				  break;	
				  
				case 8:
				  accounts[i].setLicenceStatus(tokens[j]);
				  break;
	          }
			}
	      }
		} 
	    
	  }
	  
	  /**
	   * sorting the array in descending-order of the Demerit Point
	   */
	  public static void selectionSort() {
	    String selection;		// users' decision
	    int pos;				// position of the value need swapped
	    String licNo;			// stores the temporary value of licence number
	    String licClass;		// stores the temporary value of licence class
	    String fName;			// stores the temporary value of first name
	    String lName;			// stores the temporary value of last name
	    String add;				// stores the temporary value of address
	    String sub;				// stores the temporary value of suburb
	    String code;			// stores the temporary value of post code
	    int point;				// stores the temporary value of demerit point
	    String stt;				// stores the temporary value of licence status
	    
		System.out.println("Do you want to display the report in descending-order of the Demerit Points?");
	    System.out.println("Please enter 'Y' for yes or 'N' for no ");
	    selection = kb.next();
	    
	    if(selection.equalsIgnoreCase("Y")) {
	      for (int i = 0; i < accounts.length - 1; i++) {
	        if(accounts[i].getLicenceNo() != null) {
	          pos = i;
	          licNo = accounts[i].getLicenceNo();
	          licClass = accounts[i].getLicenceClass();
	          fName = accounts[i].getFirstName();
	          lName = accounts[i].getLastName();
	          add = accounts[i].getAddress();
	          sub = accounts[i].getSuburb();
	          code = accounts[i].getPostCode();
	          point = accounts[i].getDemeritPoint();
	          stt = accounts[i].getLicenceStatus();
	          
	          for(int j = i + 1; j < accounts.length; j++) {
	            if(accounts[j].getLicenceNo() != null && accounts[j].getDemeritPoint() > point) {
	              pos = j;
	              licNo = accounts[j].getLicenceNo();
	              licClass = accounts[j].getLicenceClass();
	              fName = accounts[j].getFirstName();
	              lName = accounts[j].getLastName();
	              add = accounts[j].getAddress();
	              sub = accounts[j].getSuburb();
	              code = accounts[j].getPostCode();
	              point = accounts[j].getDemeritPoint();
	              stt = accounts[j].getLicenceStatus();
	            }
	          }
	          
	          accounts[pos].setLicenceNo(accounts[i].getLicenceNo());
	          accounts[i].setLicenceNo(licNo);
	          accounts[pos].setLicenceClass(accounts[i].getLicenceClass());
	          accounts[i].setLicenceClass(licClass);
	          accounts[pos].setFirstName(accounts[i].getFirstName());
	          accounts[i].setFirstName(fName);
	          accounts[pos].setLastName(accounts[i].getLastName());
	          accounts[i].setLastName(lName);
	          accounts[pos].setAddress(accounts[i].getAddress());
	          accounts[i].setAddress(add);
	          accounts[pos].setSuburb(accounts[i].getSuburb());
	          accounts[i].setSuburb(sub);
	          accounts[pos].setPostCode(accounts[i].getPostCode());
	          accounts[i].setPostCode(code);
	          accounts[pos].setDemeritPoint(accounts[i].getDemeritPoint());
	          accounts[i].setDemeritPoint(point);
	          accounts[pos].setLicenceStatus(accounts[i].getLicenceStatus());
	          accounts[i].setLicenceStatus(stt);
	        }
	      }
	    }
	  }
	  
	  /**
	   * displays an on-screen list of all drivers that were loaded into memory
	   * @param file - the input file
	   */
	  public static void displayingDriver(Scanner file) {  
	    for (int i = 0; i < accounts.length; i++) {
	      if(accounts[i].getLicenceNo() != null) {
	        System.out.println("Licence Number: \t" + accounts[i].getLicenceNo());
	        System.out.println("Licence Class: \t\t" + accounts[i].getLicenceClass());
	        System.out.println("First Name: \t\t" + accounts[i].getFirstName());
	        System.out.println("Last Name: \t\t" + accounts[i].getLastName());
	        System.out.println("Address: \t\t" + accounts[i].getAddress());
	        System.out.println("Suburb: \t\t" + accounts[i].getSuburb());
	        System.out.println("Post code: \t\t" + accounts[i].getPostCode());
	        System.out.println("Demerit Points: \t" + accounts[i].getDemeritPoint());
	        System.out.println("Licence Status: \t" + accounts[i].getLicenceStatus());
	        System.out.println();
	      }
	    }
	    
	  }
	  
	  /**
	   * displays the main menu
	   */
	  public static void usersSelection() {
	    System.out.println("Please choose what you want to do: ");
	    System.out.println("1. Display Drivers");
	    System.out.println("2. Import Imfregement File");
	    System.out.println("3. Generate Suspension Report");
	    System.out.println("4. Save Drivers Record");
	    System.out.println("5. Exit Program");
	  }
	  
	  /**
	   * prompt the user for the name of the infringement file that is to be imported
	   * @return the name of the infringement file
	   */
	  public static String choosingInfringement() {
		String name = null;
		int choice;
		
	    System.out.println("There are four infringment files which are numbered in sequence.");
	    System.out.println("Each file represents a different set of infringement in different periods.");
	    System.out.println("Please enter the number of the file you want to read data from.");
	    
	    do{
	      choice = kb.nextInt();
	      if( (choice < 1) || (choice > 4) ) {
	        System.out.println("There are four infringment files in total.");
	        System.out.println("The number must be between 1 and 4.");
	        System.out.println("Please re-enter the number of the file you want to read data from.");
	      }
	    } while ((choice < 1) || (choice > 4) );
	    
	    switch(choice) {
	      case 1:
	        name = "Infringements1.Txt";
	        break;
	        
	      case 2:
	        name = "Infringements2.Txt";
	        break;
	        
	      case 3:
	        name = "Infringements3.Txt";
	        break;
	        
	      case 4:
	    	name = "Infringements4.Txt";
	    	break;
	    }
	    
	    return name;
	  }
	  
	  /**
	   * imports the chosen infringement file into memory
	   * @param file - the infringement file
	   */
	  public static void  importingInfringement(Scanner file) {
	    String str;
	    String tokens[];
	    
	    for (int i=0; i<offender.length; i++) {
	      person[i] = new Driver();
	      
	  	  if (file.hasNext()) {
	  	    str = file.nextLine();
	  	    tokens = str.split(",");
	  	    
	        for (int j=0; j<tokens.length; j++) {
	          switch(j){
	            case 0:
	        	  break;
	        	  
	            case 1:
	              person[i].setLicenceNo(tokens[j]);
	              break;
	              
	            case 2:
	              break;
	              
	            case 3:
	              int speed = Integer.parseInt(tokens[j]);
	              offender[i] = speed;
	              break;
	          }
	        }
	      }
	  	}
	    
	  }
	  
	  /**
	   * applies the penalties based upon the excess speed
	   */
	  public static void applyingPenalties() {
		int count = 0;						// the total number of infringements correctly applied to drivers
		int suspended = 0;					// the total number of licences suspended
		int[] totalPoint = new int[100];    // the array stores data each's offender demerit points
		float totalFine = 0;				// the total revenue from fines correctly applied to drivers
		
	    for(int i = 0; i < person.length; i++) {
	      for(int j = 0; j < accounts.length; j++) {
	    	if( (person[i].getLicenceNo() != null) && (person[i].getLicenceNo().equals(accounts[j].getLicenceNo())) ) {
	          
	    	  if(totalPoint[j] == 0)
	            totalPoint[j] = SpeedingPenalty.findDemeritPoint(offender[i]);
	          else
	        	totalPoint[j] += SpeedingPenalty.findDemeritPoint(offender[i]);
	          
	          totalFine += SpeedingPenalty.findFine(offender[i]);
	          count++;
	          
	          if ( (SpeedingPenalty.licenceSuspended(offender[i])) || (totalPoint[j]>13) ) {
	            accounts[i].setLicenceStatus("Suspended");
	        	suspended++;
	          }
	        }
	      }
	    }
	    
	    System.out.println("The total number of infrigements correctly applied to drivers is: " + count);
	    System.out.println("The total revenue from fines correctly applied to drivers is: " + totalFine);
	    System.out.println("The total number of licences suspended is: " + suspended);
	    System.out.println();
	  }
	  
	  /**
	   * generates an on-screen list of the driver licences that are currently suspended
	   */
	  public static void generatingSuspension() {
	    for(int i = 0; i < accounts.length; i++) {
	      if( (accounts[i].getLicenceStatus() != null) && ((accounts[i].getLicenceStatus().equals("Suspended")) || (SpeedingPenalty.licenceSuspended(offender[i]))) ) {
	    	System.out.println("Licence Number: \t" + accounts[i].getLicenceNo());
	        System.out.println("First Name: \t\t" + accounts[i].getFirstName());
	        System.out.println("Last Name: \t\t" + accounts[i].getLastName());
	        System.out.println("Address: \t\t" + accounts[i].getAddress());
	        System.out.println("Suburb: \t\t" + accounts[i].getSuburb());
	        System.out.println("Demerit Points: \t" + accounts[i].getDemeritPoint());
	        System.out.println();
	      }
	    }
	  }
	  
	  /**
	   * writes all driver licence records back to the selected text file
	   * @param file - the "Driver.Txt" file - the selected text file
	   * @throws IOException
	   */
	  public static void savingRecords(File file) throws IOException {
		PrintWriter outputFile = new PrintWriter(file);
		
	    for(int i = 0; i < accounts.length;i++) {
	      if(accounts[i].getLicenceNo() != null) {
	    	outputFile.print(accounts[i].getLicenceNo() + ",");
	    	outputFile.print(accounts[i].getLicenceClass() + ",");
	    	outputFile.print(accounts[i].getFirstName() + ",");
	    	outputFile.print(accounts[i].getLastName() + ",");
	    	outputFile.print(accounts[i].getAddress() + ",");
	    	outputFile.print(accounts[i].getSuburb() + ",");;
	    	outputFile.print(accounts[i].getPostCode() + ",");
	    	outputFile.print(accounts[i].getDemeritPoint() + ",");
	    	outputFile.print(accounts[i].getLicenceStatus() + ",");
	    	outputFile.println();
	      }
	    }
	    
	    System.out.println("All driver records have been updated.");
	    System.out.println();
	    outputFile.close();
	  }
	  
	  /**
	   * warning the user that data has changed but they haven't saved them
	   * @param count - checks whether the user has imported any infringement files
	   * @param count1 - checks whether the user has saved data
	   * @return user's decision whether continue to exit the program or not
	   */
	  public static String exitingProgram(int check, int check1) {
		String decision = null;
		
	    if(check > check1) {
	      System.out.println("WARNING - The driver record data has changed.");
	      System.out.println("These changes will be lost if program exit is continued.");
	      System.out.println("Do you want to continue to exit the program?");
	      System.out.println("Please enter 'Y' for yes or 'N' for no ");
	      decision = kb.next();
	    }
	    
	    return decision;
	  }

}
