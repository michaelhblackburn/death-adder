/*Michael Blackburn
  CSCI 221
  Exercise10_08.java*/
  
/*This program creates a tax class for computing various taxes and tax brackets*/

public class Exercise10_08 {
  public static void main(String[] args) {
    int[][] bracketsFor2001 = {
      {27050, 65550, 136750, 297350}, // Single filer
      {45200, 109250, 166500, 297350}, // married filing jointly
      {22600, 54625, 83250, 148675}, // married filing separately
      {36250, 93650, 151650, 297350} // head of household
    };

    double[] ratesFor2001 = {0.15, 0.275, 0.305, 0.355, 0.391};

    int[][] bracketsFor2009 = {
      {8350, 33950, 82250, 171550, 372950}, // Single filer
      {16700 , 67900, 137050, 208850, 372950}, // married filing jointly
      {8350, 33950, 68525, 104425, 186475}, // married filing separately
      {11950, 45500, 117450, 190200, 372950} // head of household
    };

    double[] ratesFor2009 = {0.1, 0.15, 0.25, 0.28, 0.33, 0.35};

    Tax taxFor2001 = new Tax(0, bracketsFor2001, ratesFor2001, 50000);
    System.out.println("2001 Tax Table");
    System.out.println("taxable\tSingle\tMarried\tMarried\tHead of");
    System.out.println("Income\tSingle\tJoint\tSeparate a House");
    for (int taxableIncome = 50000; taxableIncome <= 60000; taxableIncome += 1000) {
      taxFor2001.setTaxableIncome(taxableIncome);
      taxFor2001.setFilingStatus(0);
      int taxForStatus0 = (int)taxFor2001.getTax();
      taxFor2001.setFilingStatus(1);
      int taxForStatus1 = (int)taxFor2001.getTax();
      taxFor2001.setFilingStatus(2);
      int taxForStatus2 = (int)taxFor2001.getTax();
      taxFor2001.setFilingStatus(3);
      int taxForStatus3 = (int)taxFor2001.getTax();
      System.out.println(taxableIncome + "\t" + taxForStatus0 + "\t" +
        taxForStatus1 + "\t" + taxForStatus2 + "\t" +
        taxForStatus3);
    }

    Tax taxFor2009 = new Tax(0, bracketsFor2009, ratesFor2009, 50000);
    System.out.println("2009 Tax Table");
    System.out.println("taxable\tSingle\tMarried\tMarried\tHead of");
    System.out.println("Income\tSingle\tJoint\tSeparate a House");
    for (int taxableIncome = 50000; taxableIncome <= 60000; taxableIncome += 1000) {
      taxFor2009.setTaxableIncome(taxableIncome);
      taxFor2009.setFilingStatus(0);
      int taxForStatus0 = (int)taxFor2009.getTax();
      taxFor2009.setFilingStatus(1);
      int taxForStatus1 = (int)taxFor2009.getTax();
      taxFor2009.setFilingStatus(2);
      int taxForStatus2 = (int)taxFor2009.getTax();
      taxFor2009.setFilingStatus(3);
      int taxForStatus3 = (int)taxFor2009.getTax();
      System.out.println(taxableIncome + "\t" + taxForStatus0 + "\t" +
        taxForStatus1 + "\t" + taxForStatus2 + "\t" +
        taxForStatus3);
    }
  }
}
  
class Tax{
	private int filingStatus = SINGLE_FILER;
	int [][] brackets = {{27050, 65550, 136750, 297350}, 
    					 {45200, 109250, 166500, 297350}, 
    					 {22600, 54625, 83250, 148675}, 
    					 {36250, 93650, 151650, 297350}};
	double [] rates = {0.15, 0.275, 0.305, 0.355, 0.391};
	double taxableIncome = 100000.0;
	private final static int SINGLE_FILER = 0;
	private final static int MARRIED_JOINTLY = 1;
	private final static int MARRIED_SEPARATELY = 2;
	private final static int HEAD_OF_HOUSEHOLD = 3;
	
	Tax(){
	}
	
	Tax(int fs, int[][] b, double[] r, double ti){
		this.filingStatus = fs;
		this.brackets = b;
		this.rates = r;
		this.taxableIncome = ti;
	}
	
	public int getFilingStatus() {
    	return filingStatus;
  	}

  	public void setFilingStatus(int fs) {
    	this.filingStatus = fs;
  	}
  	
  	public int [][] getBrackets(){
  		return brackets;
  	}
	
	public void setBrackets(int[][] b) {
    	this.brackets = b;
  	}
  	
  	public double [] getRates(){
  		return rates;
  	}

  	public void setRates(double[] r) {
    	this.rates = r;
  	}

  	public double getTaxableIncome() {
    	return taxableIncome;
  	}

  	public void setTaxableIncome(double ti) {
    	this.taxableIncome = ti;
  	}
  	
	public double getTax() {
    	double tax = 0.0;
    	int c = 0;
    	if (taxableIncome <= brackets[filingStatus][0])
    		tax = taxableIncome * rates[0];
    	else
    		tax = brackets[filingStatus][0] * rates[0];
    	for (int i = 1; i < brackets[0].length; i++) {
      		if (taxableIncome > brackets[filingStatus][i])
        		tax += (brackets[filingStatus][i] - brackets[filingStatus][i - 1]) * rates[i];
      		else {
        		tax += (taxableIncome - brackets[filingStatus][i - 1]) * rates[i];
        		break;
      		}
    	}
    	if (c == brackets[0].length && taxableIncome > brackets[filingStatus][c - 1])
      		tax += (taxableIncome - brackets[filingStatus][c - 1]) * rates[c];

    	return tax;
  	}
}