/* Honor Pledge: I pledge that I have neither 
* given nor receieved any help on this assignment.
* A5, Technician Class
* David Haines */


///---Technician subclass---///
//use keyword extends to make subclass of employee
public class Tech extends Employee
{
	
	//no new variables needed for basic assignment
	
	//--Default Constructor--//
	public Tech()
	{
		//call default superclass
		super();
	}
	
	
	//--Technician CSV constructor--//
	public Tech(String ident, String fstNm, String lstNm, String stDt)
	{
		//call super class constructor
		super(ident, fstNm, lstNm, stDt);
		//set hourly rate with setter due to private access
		setHrRate(20.00);
		//blackbelt variables
		setJobDescr("Member of pharmacy team that takes calls and fills non-restricted medicine prescriptions.");
		setBenefits("Store Discount");
		setBonus(1000);
		setYearPTO(40);
	}
	
	//needs no new methods for base assignment
}