/*Michael Blackburn
  CSCI 221
  Exercise08_07.java*/
  
/*This creates a class for an account object*/

public class Exercise08_07 {
  public static void main (String[] args) {
    Account account = new Account(1122, 20000);
    Account.setAnnualInterestRate(4.5);
    
    account.withdraw(2500);
    account.deposit(3000);
    System.out.println("Balance is " + account.getBalance());
    System.out.println("Monthly interest is " +
      account.getMonthlyInterest());
    System.out.println("This account was created at " +
      account.getDateCreated());
  }
}

class Account{
	private int id;
	private double balance;
	private double annualInterestRate;
	private Date dateCreated;
	
	Account(){
		id = 0;
		balance = 0.0;
		annualInterestRate = 0.0;
		dateCreated = 0;
	}
	
	Account(int i, double b){
		id = i;
		balance = b;
	}
	
	int getID(){
		return id;
	}
	
	void setID(int i){
		id = i;
	}
	
	double getBalance(){
		return balance;
	}
	
	void setBalance(double b){
		balance = b;
	}
	
	double getAnnualInterestRate(){
		return annualInterestRate;
	}
	
	void static setAnnualInterestRate(double a){
		annualInterestRate = a;
	}
	
	Date getDateCreated(){
		return dateCreated;
	}
	
	double getMonthlyInterest(){
		return balance * (annualInterestRate / 12);
	}
	
	double getMonthlyInterestRate(){
		return annualInterestRate / 12;
	}
	
	void withdraw(double a){
	 	balance = balance - a;
	}
	
	void deposit(double a){
		balance = balance + a;
	}
}
	
	
	