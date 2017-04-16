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


///---Driver Class---///
public class Driver
{
	//declare employee array of size 4
	private static Employee[] empArray = new Employee[4];
	
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
			System.out.println("1. Load Employees (From File)");
			System.out.println("2. Exit Program");
			
			//skip line to look better and ask user to input choice
			System.out.printf("%nPlease Enter Your Choice:");
			
			//collect input
			String in = input.next();
			
			
			//check input to see: a) is it correct input  b) if so, which selection to do
			//this time, just collecting input as string so as to avoid unwanted entries that could contain the ints
			
			if (in.equals("2"))     //exit condition
			{
				//print goodbye message and exit loop
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
				System.out.println("I'm not sure what you are trying to do...");
				System.out.printf("Please try again. %n%n");
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
				//declare array position variable
				int x = 0;
				
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
					Employee emp = new PharmMan(id, name1, name2, startDate);
				}
				else if (jobID.equals("2"))
				{
					Employee emp = new Pharmacist(id, name1, name2, startDate);
				}
				else if (jobID.equals("3"))
				{
					Employee emp = new Tech(id, name1, name2, startDate);
				}
				else if (jobID.equals("4"))
				{
					Employee emp = new SeniorTech(id, name1, name2, startDate);
				}
								
				//put in next slot in array
				empArray[x] = emp;
				
				// Get the next line in the file...
				line = br.readLine();
				
				//increment empArray position variables
				x = x + 1;
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
		
		//declare hours variable
		double hours = 0.0;
		
		//Second Menu while loop
		while (keepGoing2 == 0)
		{
			
			//Print Menu
			System.out.println("");
			System.out.println("1. Print Employee Information");
			System.out.println("2. Enter Hours Worked");
			System.out.println("3. Calculate Paychecks");
			System.out.println("4. Exit Program");
			System.out.printf("%nPlease enter your selection:");
			
			//get user input
			String inp = nmInput.next();
			
			//if loop to determine which choice user entered or if entered incorrectly
			if (inp.equals("4"))	//exit condition
			{
				//print exit message and exit both menu loops
				System.out.println("Ok, exiting now. Have a good day!");
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
				//ask user to enter hours
				System.out.printf("%n%nPlease enter hours employees worked since last paycheck (0-1000):");
				
				//try catch to determine if input invalid
				try
				{
					//set hours worked variable to input
					String hrs = nmInput.next();
				
					//convert String to double
					double hrValue = Double.parseDouble(hrs);
				}
				catch(NumberFormatException e)
				{
					System.out.println("This is not a valid input");
					System.out.println("Setting hours to 0");
					hours = 0.0;
				}
				
				//make sure hours is within acceptable range, don't want huge numbers that could break program
				if (hrValue < 0.0)
				{
					hours = 0.0;
					System.out.println("Hours entered below 0, setting to 0");
				}
				else if (hrValue > 1000.0)
				{
					hours = 1000.0;
					System.out.println("Hours exceeds max limit, setting to 1000");
				}
				else
				{
					hours = hrValue;
				}
			}
			else if (inp.equals("3"))
			{
				//blank line
				System.out.println("");
				
				/*make sure hours have been entered first and that they aren't zero
				if hours doesn't equal zero, go through emp array and calculate paychecks method
				else, print employees haven't worked any hours! */
				if (hours == 0.0)
				{
					System.out.println("No hours have been entered. All employees have earned nothing.");
					System.out.println("Please try entering hours worked");
				}
				else
				{
					for (Employee emp : empArray)
					{
					//call calcPay method for employee
					emp.calcPay(hours);
					}
				}
			}
			else
			{
				//tell user that you aren't sure what they are trying to do, and to please enter it again
				System.out.println("I'm not sure what you are trying to do...");
				System.out.printf("Please try again. %n%n");
			}
		}
	}
}
