import java.util.*;

public class Loan{
	public static void main(String[] args){
		
		double annualInterestRate;
		int numOfYears;
		double loanAmount;
		
		Scanner input = new Scanner(System.in);
		boolean continueInput = true;
		NewLoan a = new NewLoan();
		
		do{
			try {
				System.out.print("Enter the annualInterestRate");
				annualInterestRate = input.nextDouble();
				a.setAnnualInterestRate(annualInterestRate);
				continueInput = false;
			}
			catch(Exception ex){
				System.out.println(ex);
			}
		
		
		}while(continueInput);
	
	continueInput = true;
	
	do{
		try {
			System.out.print("Enter the numOfYears");
			numOfYears = input.nextInt();
			a.setNumOfYears(numOfYears);
			continueInput = false;
		}
		catch(Exception ex){
			System.out.println(ex);
		}
	
	
	}while(continueInput);
	
	continueInput = true;
	
	do{
		try {
			System.out.print("Enter the loanAmount");
			loanAmount = input.nextDouble();
			a.setLoanAmount(loanAmount);
			continueInput = false;
		}
		catch(Exception ex){
			System.out.println(ex);
		}
	}while(continueInput);
	
	System.out.println("End of program");

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
		if(loanAmount <= 0)
			throw new IllegalArgumentException("Loan amount must be positive.");
		setAnnualInterestRate(annualInterestRate);
		setNumOfYears(numOfYears);
		setLoanAmount(loanAmount);
	}
	
	public double getAnnualInterestRate(){
		return annualInterestRate;
	}
	
	public void setAnnualInterestRate(double annualInterestRate)
			throws IllegalArgumentException{
		if(annualInterestRate <= 0)
			throw new IllegalArgumentException("Annual interest rate must be positive.");
		this.annualInterestRate = annualInterestRate;
	}
	
	public int getNumOfYears(){
		return numOfYears;
	}
	
	public void setNumOfYears(int numOfYears)
			throws IllegalArgumentException{
		if(numOfYears <= 0)
			throw new IllegalArgumentException("Number of years must be positive.");
		this.numOfYears = numOfYears;
	}
	
	public double getLoanAmount() {
	    return loanAmount;
	}
	
	public void setLoanAmount(double loanAmount) 
			throws IllegalArgumentException{
		if (loanAmount <= 0)
		     throw new IllegalArgumentException("Loan amount must be positive.");
		this.loanAmount = loanAmount;
	}
	
	public double monthlyPayment(){
		double monthlyInterestRate = annualInterestRate / 1200;
		return loanAmount * monthlyInterestRate / (1 - (Math.pow(1/(1 + monthlyInterestRate),numOfYears * 12)));
	}
	
	public double totalPayment() {
	    return monthlyPayment() * numOfYears * 12;
	}
}
}