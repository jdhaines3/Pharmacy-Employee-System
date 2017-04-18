/* Honor Pledge: I pledge that I have neither 
* given nor receieved any help on this assignment.
* A5, Driver Class
* David Haines */

//import java io for file input readers, exceptions, and possible formatted output (might just use system.out)
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;
//import list and array list to dynamically add elements
import java.util.List;
import java.util.ArrayList;


///---Driver Class---///
public class Driver
{
	//declare employee list as new arraylist to allow dynamic addition of employees
	private static List<Employee> empArray = new ArrayList<Employee>();
	
	//declare exit variables for menu while loops
	//could do in main if wanted to write both menus in main; but separating next menu into its own function
	private static int keepGoing = 0;
	private static int keepGoing2 = 0;
	
	//--Main Function--//
	public static void main(String[] args)
	{
		/*set up exit variables for menu while loops
		int keepGoing = 0;
		int keepGoing2 = 0; */
		
		//set up scanner utility
		Scanner input = new Scanner(System.in);
		
		//first menu
		while (keepGoing == 0)
		{
			//print menu
			System.out.println("");
			System.out.println("1. Load Employees (From File)");
			System.out.println("2. Exit Program");
			
			//skip line to look better and ask user to input choice
			System.out.printf("%nPlease Enter Your Choice:  ");
			
			//collect input
			String in = input.next();
			
			
			//check input to see: a) is it correct input  b) if so, which selection to do
			//this time, just collecting input as string so as to avoid unwanted entries that could contain the ints
			
			if (in.equals("2"))     //exit condition
			{
				//print goodbye message and exit loop
				System.out.println("");
				System.out.println("Ok, exiting now. Have a good day!");
				keepGoing = 1;
			}
			else if (in.equals("1"))	//load employee condition
			{
				//load employee file method then print that file has been loaded
				loadFile();
				nextMenu();
			}
			else		//if neither one or two condition
			{
				//print that not sure what user wanted and ask to try again, then have a couple blank lines before menu pops up
				System.out.println("");
				System.out.println("I'm not sure what you are trying to do...");
				System.out.println("Please try again.");
			}
		}
	}
	//could make functions static or initialize the class
	
	
	//--File Load Function--//
	public static void loadFile()
	{
		try 
		{
			//input stream for text file, input stream reader then buffer reader
			InputStream inpStrm = new FileInputStream("employees.txt");
			
			InputStreamReader isr = new InputStreamReader(inpStrm);
			
			BufferedReader br = new BufferedReader(isr);
			
			//burn first line of file (header)
			String line = br.readLine();
			line = br.readLine();
			
			//loop through other lines in file
			while(line != null)
			{
				//split line by comma and put each string into an array
				String[] values = line.split(",");
				
				//classify which string in the array is what (ie: first name, ID, etc)
				String jobID = values[0];
				String id = values[1];
				String name1 = values[2];
				String name2 = values[3];
				String startDate = values[4];
				
				//determine which subclass to create based on jobID
				if (jobID.equals("1"))
				{
					//create new subclass declared as Employee super class
					Employee emp = new PharmMan(id, name1, name2, startDate);
					
					//put in next slot in arraylist
					empArray.add(emp);
				}
				else if (jobID.equals("2"))
				{
					//same as last statement
					Employee emp = new Pharmacist(id, name1, name2, startDate);
					
					empArray.add(emp);
				}
				else if (jobID.equals("3"))
				{
					Employee emp = new Tech(id, name1, name2, startDate);
					
					//same as last statement
					empArray.add(emp);
				}
				else if (jobID.equals("4"))
				{
					Employee emp = new SeniorTech(id, name1, name2, startDate);
					
					//same as last statement
					empArray.add(emp);
				}
				
				
				// Get the next line in the file...
				line = br.readLine();
			}
			
			//close buffer reader
			br.close();
		}
		//if the file isn't there, print an error
		catch (IOException ex) 
		{
			System.err.println(ex);
		}
		
		//print out message that employee file is loaded, put empty line above and below
		System.out.printf("%nLoaded employee list from file! %n");
	}
	
	
	//--Second Menu Function--//
	public static void nextMenu()
	{
		//set up scanner utility
		Scanner nmInput = new Scanner(System.in);
		
		//Second Menu while loop
		while (keepGoing2 == 0)
		{
			
			//Print Menu
			System.out.println("");
			System.out.println("1. Print Employee Information");
			System.out.println("2. Enter Hours Worked");
			System.out.println("3. Calculate Paychecks");
			System.out.println("4. Exit Program");
			System.out.printf("%nPlease enter your selection:  ");
			
			//get user input
			String inp = nmInput.next();
			
			//if loop to determine which choice user entered or if entered incorrectly
			if (inp.equals("4"))	//exit condition
			{
				//print exit message and exit both menu loops
				System.out.printf("%nOk, exiting now. Have a good day!%n");
				keepGoing = 1;
				keepGoing2 = 1;
			}
			else if (inp.equals("1"))
			{
				//skip line 
				System.out.println("");
				
				//for each loop to iterate through array
				for (Employee emp : empArray)
				{
					//call printInfo method for employee
					emp.printInfo();
				}
			}
			else if (inp.equals("2"))
			{
				//skip line 
				System.out.println("");
				
				//for each loop to iterate through array
				for (Employee emp : empArray)
				{
					//call printInfo method for employee
					emp.setHrs();
				}
				
				System.out.println("");
				System.out.println("Finished setting hours worked!");
			}
			else if (inp.equals("3"))
			{
				//blank line
				System.out.println("");
				
				//iterate through array
				for (Employee emp : empArray)
				{
				//call calcPay method for employee
				emp.calcPay();
				}
			}
			else
			{
				//tell user that you aren't sure what they are trying to do, and to please enter it again
				System.out.println("");
				System.out.println("I'm not sure what you are trying to do...");
				System.out.println("Please try again.");
			}
		}
	}
}
