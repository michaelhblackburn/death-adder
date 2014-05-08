//FILE			:SavingsAccount.h
//PROGRAMMER	:Michael Blackburn
//PURPOSE		:class file for display and calculation of various values associated with a savings account

class SavingsAccount
{
	//data declarations
	private:
		string accountNumber;
		double accountBalance;
		double interestRate;
		
	//methods declaration
	public:
		SavingsAccount();
		string getAccountNumber();
		double getBalance();
		double getInterestRate();
		void addToBalance(double);
		void subtractFromBalance(double);
		void setNewAccountValues(double);
};

//implement methods
SavingsAccount::SavingsAccount()
{
	accountNumber = "A123456";
	accountBalance = 4000;
	interestRate = .004;
}

string SavingsAccount::getAccountNumber()
{
	return accountNumber;
}

double SavingsAccount::getBalance()
{
	return accountBalance;
}

double SavingsAccount::getInterestRate()
{
	return interestRate;
}

void SavingsAccount::addToBalance(double deposit)
{
	accountBalance += deposit;
}

void SavingsAccount::subtractFromBalance(double withdrawl)
{
	accountBalance -= withdrawl;
}

void SavingsAccount::setNewAccountValues(double deposit)
{
	accountNumber = "Z654321";
	accountBalance = deposit;
	interestRate = .004;
}
//end class SavingsAccount