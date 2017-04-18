/* Honor Pledge: I pledge that I have neither 
* given nor receieved any help on this assignment.
* A5, Employee Class
* David Haines */

//import formatted printing
import java.io.PrintStream;
import java.util.Scanner;

///---Employee Class---///
public class Employee
{
	//add employee variables
	private String id, firstName, lastName, startDate;
	//hourly rate will be of double type to account for the cents
	private double hourlyRate;
	
	//BlackBelt variables to add more information and dynamic classes
	private double hours;
	private String jobDescr, benefits;
	private int yearPTO, yearBonus;
	
	
	//--Default Constructor--//
	public Employee()
	{
		//make all variables null or 0; don't need to set them like that, but like to do it for good measure
		this.id = "";
		this.firstName = "";
		this.lastName = "";
		this.startDate = "";
		this.hourlyRate = 0.0;
		this.hours = 0.0;
		this.jobDescr = "";
		this.benefits = "";
		this.yearPTO = 0;
		this.yearBonus = 0;
		
	}
	
	//need constructor so that subclass can call super and enable polymorphism
	
	//--Constructor for Subclass "Super" Keyword--//
	public Employee(String ident, String fstNm, String lstNm, String stDt)
	{
		//make all variables set to constructor Strings with exception of hourlyRate which will be set in subclass
		this.id = ident;
		this.firstName = fstNm;
		this.lastName = lstNm;
		this.startDate = stDt;
		this.hourlyRate = 0.0;
		//not reading anything from CSV so set to null/zero
		this.hours = 0.0;
		this.jobDescr = "";
		this.benefits = "";
		this.yearPTO = 0;
		this.yearBonus = 0;
	}
	
	
	//--Calculate Payment Function--//
	
	public void calcPay()
	{
		//take double (hours) and multiply by hourlyRate
		double pay = hours * hourlyRate;
		
		//format print statement to make neat columns with ID and Pay (with only two decimal points)
		System.out.printf("ID: %-8s \tPay: %.2f %n", id, pay);
	}
	
	
	//--Print Employee Info Function--//
	public void printInfo()
	{
		//combine first and last name to one variable, name, for easier formatting
		String name = firstName + " " + lastName;
		//print formatted statement with ID, name variable, and startDate
		System.out.printf("ID: %-8s \tName: %-20s \tStart Date: %-10s%n", id, name, startDate);
		//print hourly rate bonus and PTO hours
		System.out.printf("Yearly Bonus: $%-4d \tYearly PTO: %-2d hours \tHourly Rate: %.2f%n", yearBonus, yearPTO, hourlyRate);
		//print line for benefits
		System.out.println("Benefits: " + benefits);
		//printf for job descr
		System.out.printf("Job Description: %s%n%n", jobDescr);
	}
	
	//add getters and setters (won't need any but hourly Rate, but added for future reusability)
	
	//--Getters and Setters for Hourly Rate--//
	public double getHrRate()
	{
		return hourlyRate;
	}
	
	public void setHrRate(double hr)
	{
		//make sure hourly Rate is correct
		if (hr < 0)
		{
			hourlyRate = 0;
			System.out.println("Hourly Rate below 0, setting hourly rate to 0");
		}
		else
		{
			hourlyRate = hr;
		}
	}
	
	//--Getters and Setters for ID--//
	public String getID()
	{
		return id;
	}
	
	public void setID(String idnt)
	{
		//make sure ID is 8 alpha-numeric digits long. If not, set to 8 zero's so user can see the error later
		if (idnt.length() != 8)
		{
			System.out.println("ID must be 8 digits");
			System.out.println("Setting ID to 00000000");
			id = "00000000";
		}
		else
		{
			id = idnt;
		}
	}
	
	//--Getters and Setters for First and Last Name--//
	public String getFirstName()
	{
		return firstName;
	}
	
	public void setFirstName(String fn)
	{
		firstName = fn;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public void setLastName(String ln)
	{
		lastName = ln;
	}
	
	//--Getter and Setter for Start Date--//
	public String getStartDate()
	{
		return startDate;
	}
	
	public void setStartDate(String sd)
	{
		//if used in future code, must parse date string to see if it is a date, then allow it to be passed as argument
		startDate = sd;
	}
	
	
	//--Getter and Setter for Job Description--//
	public String getJobDescr()
	{
		return jobDescr;
	}
	
	public void setJobDescr(String jd)
	{
		jobDescr = jd;
	}
	
	
	//--Getter and Setter for Benefits--//
	public String getBenefits()
	{
		return benefits;
	}
	
	public void setBenefits(String b)
	{
		benefits = b;
	}
	
	
	//--Getter and Setter for Yearly PTO Hours--//
	public int getYearPTO()
	{
		return yearPTO;
	}
	
	public void setYearPTO(int pto)
	{
		yearPTO = pto;
	}
	
	
	//--Getter and Setter for Yearly Bonus Pay--//
	public int getBonus()
	{
		return yearBonus;
	}
	
	public void setBonus(int bonus)
	{
		yearBonus = bonus;
	}
	
	
	//--Getter for Hours--//
	public double getHours()
	{
		return hours;
	}
	
	//--Set Hours method for individual hours setting--//
	public void setHrs()
	{
		Scanner hrsInput = new Scanner(System.in);
		
		//try catch to determine if input invalid
		try
		{
			String name = firstName + " " + lastName;
			
			//give user ID and name
			System.out.println("");
			//ask user to input the hours
			System.out.printf("For ID: %-8s, \tName: %-20s Please enter hours worked (0-1000): ", id, name); 
			
			//set hours worked variable to input
			String hrs = hrsInput.next();
		
			//convert String to double
			double hrValue = Double.parseDouble(hrs);
			
			//make sure hours is within acceptable range, don't want huge numbers that could break program
			if (hrValue < 0.0)
			{
				hours = 0.0;
				System.out.println("");
				System.out.println("Hours entered below 0, setting to 0.");
			}
			else if (hrValue > 1000.0)
			{
				hours = 1000.0;
				System.out.println("");
				System.out.println("Hours exceeds max limit, setting to 1000.");
			}
			else
			{
				hours = hrValue;
			}
		}
		catch(NumberFormatException e)
		{
			System.out.println("This is not a valid input");
			System.out.println("Setting hours to 0");
			hours = 0.0;
		}
	}
}	
