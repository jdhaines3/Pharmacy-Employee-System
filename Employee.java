/* Honor Pledge: I pledge that I have neither 
* given nor receieved any help on this assignment.
* A4, Address Class
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
		this.hourlyRate = 0;
	}
	
	//don't need any other constructors, will be added in Derived classes
	
	
	//--Calculate Payment Function--//
	//must be passed in hours variable from Driver class
	public void calcPay(double h)
	{
		//take double (hours) and multiply by hourlyRate
		//format print statement to make neat columns with ID and Pay (with only two decimal points)
	}
	
	
	//--Print Employee Info Function--//
	public void printInfo()
	{
		//combine first and last name to one variable, name, for easier formatting
		//print formatted statement with ID, name variable, and startDate
	}	