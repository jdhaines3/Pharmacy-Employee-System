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
		//set hourly rate with setter due to private access
		setHrRate(40.00);
		//blackbelt variables
		setJobDescr("Oversees technicians, talks to insurance companies, and involved with patients. Knowledge of drugs and their effects.");
		setBenefits("Retirement, Health and Dental Insurance, Store Discount");
		setBonus(3000);
		setYearPTO(70);
	}
	
	//needs no new methods for base assignment
}