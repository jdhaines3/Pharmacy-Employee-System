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
		//set hourly rate with setter due to private access
		setHrRate(50.00);
		//blackbelt variables
		setJobDescr("Head Pharmacist in charge of managing the other pharmacists.");
		setBenefits("Retirement, Health and Dental Insurance, Store Discount");
		setBonus(4500);
		setYearPTO(90);
	}
	
	//needs no new methods for base assignment
}