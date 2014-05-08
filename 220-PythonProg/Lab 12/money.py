# Money.py
# Michael Blackburn

class Money():
    def __init__(self):
        self.dollars = 0
        self.cents = 0

    def getDollars(self):
        return self.dollars

    def getCents(self):
        return self.cents

    def setDollars(self, d):
        if d > 0:
            self.dollars = d
        else:
            self.dollars = self.dollars

    def setCents(self, c):
        if c > 0 and c < 100:
            self.cents = c
        elif c > 100:
            self.cents = c % 100
            self.dollars += c // 100
        else:
            self.cents = self.cents

    def __str__(self):
        return "$"+str(self.dollars)+"."+str(self.cents)
        
    def compareTo(self, m):
        if self.dollars*100 + self.cents > m.getDollars()*100+m.getCents():
            return 1
        elif self.dollars*100 + self.cents < m.getDollars()*100+m.getCents():
            return -1
        else:
            return 0

    def increment(self, m):
        selfTotal = self.dollars * 100 + self.cents
        mTotal = m.getDollars() * 100 + m.getCents()
        total = selfTotal + mTotal
        self.cents = total % 100
        self.dollars = total // 100
        
