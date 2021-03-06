/* Honor Pledge: I pledge that I have neither 
* given nor receieved any help on this assignment.
* A5, Senior Technician Class
* David Haines */


///---Senior Technician subclass---///
//use keyword extends to make subclass of employee
public class SeniorTech extends Employee
{
	
	//no new variables needed for basic assignment
	
	//--Default Constructor--//
	public SeniorTech()
	{
		//call default superclass
		super();
	}
	
	
	//--Senior Tech CSV constructor--//
	public SeniorTech(String ident, String fstNm, String lstNm, String stDt)
	{
		//call super class constructor
		super(ident, fstNm, lstNm, stDt);
		//set hourly rate with setter due to private access
		setHrRate(25.00);
	}
	
	//needs no new methods for base assignment
}