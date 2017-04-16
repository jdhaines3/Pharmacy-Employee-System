/* Honor Pledge: I pledge that I have neither 
* given nor receieved any help on this assignment.
* A5, Pharmacist Manager Class
* David Haines */


///---Pharmacy Manager subclass---///
//use keyword extends to make subclass of employee
public class PharmMan extends Employee
{
	
	//no new variables needed for basic assignment
	
	//--Default Constructor--//
	public PharmMan()
	{
		//call default superclass
		super();
	}
	
	
	//--Pharmacy Manager CSV constructor--//
	public PharmMan(String ident, String fstNm, String lstNm, String stDt)
	{
		//call super class constructor
		super(ident, fstNm, lstNm, stDt);
		//set hourly rate; not sure if need to use setter to set hourly rate...we will see
		hourlyRate = 50.00;
	}
	
	//needs no new methods for base assignment
}