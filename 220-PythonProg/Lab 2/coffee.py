## coffee.py
## Michael Blackburn, CSCI 220L-01

def main():
    PRICE_PER_POUND = 10.5
    OVERHEAD = 1.5
    pounds = eval( input ("How many pounds of coffee would you like to order: "))
    while pounds > 0:
        shipping = pounds * .86
        total = (pounds * PRICE_PER_POUND) + OVERHEAD + shipping
        print ("The total cost of your order is $",total)
        pounds = eval( input ("How many pounds of coffee would you like to order: "))
    
main()
