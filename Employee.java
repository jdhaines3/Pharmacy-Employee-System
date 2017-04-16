/* Honor Pledge: I pledge that I have neither 
* given nor receieved any help on this assignment.
* A5, Employee Class
* David Haines */

//import formatted printing
import java.io.PrintStream;


///---Employee Class---///
public class Employee
{
	//add employee variables
	private String id, firstName, lastName, startDate;
	//hourly rate will be of double type to account for the cents
	private double hourlyRate;
	
	
	//--Default Constructor--//
	public Employee()
	{
		//make all variables null or 0; don't need to set them like that, but like to do it for good measure
		this.id = "";
		this.firstName = "";
		this.lastName = "";
		this.startDate = "";
		this.hourlyRate = 0.0;
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
	}
	
	
	//--Calculate Payment Function--//
	//must be passed in hours variable from Driver class
	public void calcPay(double h)
	{
		//take double (hours) and multiply by hourlyRate
		double pay = h * hourlyRate;
		
		//format print statement to make neat columns with ID and Pay (with only two decimal points)
		System.out.printf("ID: %-8s \tPay: %.2f", id, pay)
	}
	
	
	//--Print Employee Info Function--//
	public void printInfo()
	{
		//combine first and last name to one variable, name, for easier formatting
		String name = firstName + " " + lastName;
		//print formatted statement with ID, name variable, and startDate
		System.out.printf("ID: %-8s \tName: %-20s \tStart Date: %-10s \tHourly Rate: %.2f", id, name, startDate, hourlyRate)  
	}
	
	//add getters and setters
	
}	