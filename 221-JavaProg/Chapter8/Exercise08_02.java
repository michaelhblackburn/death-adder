/*Michael Blackburn
  CSCI 221
  Exercise08_02.java*/

/*This is a class for a stock that defines the stock symbol, name, closing price, and
  current price.*/
  
class Stock{
	String symbol;
	String name;
	double previousClosingPrice;
	double currentPrice;
	
	Stock(String s, String n){
		symbol = s;
		name = n;
	}
	
	void setCurrentPrice(double p){
		currentPrice = p;
	}
	
	void setPreviousClosingPrice(double p){
		previousClosingPrice = p;
	}
	
	double getPreviousClosingPrice(){
		return previousClosingPrice;
	}
	
	double getCurrentPrice(){
		return currentPrice;
	}
	
	double getChangePercent(){
		return (currentPrice - previousClosingPrice) / previousClosingPrice;
	}
}