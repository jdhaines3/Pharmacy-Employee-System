/* Honor Pledge: I pledge that I have neither 
* given nor receieved any help on this assignment.
* A5, Pharmacist Class
* David Haines */


///---Pharmacist subclass---///
//use keyword extends to make subclass of employee
public class Pharmacist extends Employee
{
	
	//no new variables needed for basic assignment
	
	//--Default Constructor--//
	public Pharmacist()
	{
		//call default superclass
		super();
	}
	
	
	//--Pharmacist CSV constructor--//
	public Pharmacist(String ident, String fstNm, String lstNm, String stDt)
	{
		//call super class constructor
		super(ident, fstNm, lstNm, stDt);
		//set hourly rate; not sure if need to use setter to set hourly rate...we will see
		hourlyRate = 40.00;
	}
	
	//needs no new methods for base assignment
}