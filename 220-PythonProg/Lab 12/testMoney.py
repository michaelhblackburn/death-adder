# testMoney.py
# Author: Pharr

from money import Money

def main():
    # Use these to test the constructor and getters
    
    m1 = Money()
    m2 = Money()

    print ("Constructors, getters:")
    print ("m1 dollars =", m1.getDollars())
    print ("m1 cents =", m1.getCents())
    print ("m2 dollars =", m2.getDollars())
    print ("m2 cents =", m2.getCents())

    # Use these to test the setters
    
    m1.setDollars(1)
    m1.setCents(20)
    m2.setDollars(1)
    m2.setCents(190)

    print ()
    print ("setters:")
    print ("m1 dollars =", m1.getDollars())
    print ("m1 cents =", m1.getCents())
    print ("m2 dollars =", m2.getDollars())
    print ("m2 cents =", m2.getCents())

    # Use these to test the __str__
    
    print ()
    print ("__str__:")
    print ("m1 =", m1)
    print ("m2 =", m2)

    # Use these to test the compareTo
    
    print ()
    print ("compareTo:")
    print ("m1 is less than m2:", m1.compareTo(m2) < 0)
    print ("m1 equals m2:", m1.compareTo(m2) == 0)
    print ("m1 is greater than m2:", m1.compareTo(m2) > 0)
    m2.setDollars(1)
    m2.setCents(20)
    print ("m1 =", m1)
    print ("m2 =", m2)
    print ("m1 is less than m2:", m1.compareTo(m2) < 0)
    print ("m1 equals m2:", m1.compareTo(m2) == 0)
    print ("m1 is greater than m2:", m1.compareTo(m2) > 0)

    # Use this to test increment
    
    m2.setCents(50)
    print ()
    print ("Before increment:")
    print ("m1 =", m1)
    print ("m2 =", m2)
    m1.increment(m2)
    print ("After increment, m1 =", m1)

    # Use this to test increment more
    
    m1.setDollars(1)
    m1.setCents(20)
    m2.setCents(90)
    print ()
    print ("Before increment with carry:")
    print ("m1 =", m1)
    print ("m2 =", m2)
    m1.increment(m2)
    print ("After increment with carry, m1 =", m1)
    
main()
