public class IllegalArgumentException {
	public static void main(String[] args){
		try {
			new NewLoan(7.5,30,20000);
			NewLoan m = new NewLoan(-1,3,3);
			new NewLoan(7.5,30,20000);
		}
		catch(Exception ex){
			System.out.println(ex);
		}
		
		System.out.println("End of program");
	}
}

class NewLoan{
	private double annualInterestRate;
	private int numOfYears;
	private double loanAmount;
	
	public NewLoan(){
		this(7.5,30,100000);
	}
	
	public NewLoan(double annualInterrstRate,int numOfYears,double loanAmount){
		if(annualInterrstRate <= 0)
			throw new IllegalArgumentException("Annual interest rate must be positive.");
		if(numOfYears <= 0)
			throw new IllegalArgumentException("Number of years must be positive.");
		if(loanAmout <= 0)
			throw new IllegalArgumentException("Loan amount must be positive.");
		setAnnualInterestRate(annualInterestRate);
		setNumOfYears(numOfYears);
		setLoanAmount(loanAmount);
	}
}