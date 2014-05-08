# starter.py
# Michael Blackburn

def main():
    weight = eval(input("Enter the players's weight: "))
    numWins = eval(input("Enter the number of wins for the player: "))
    if weight >= 199 or numWins > 20:
        print("The player should start.")
    elif weight >= 150 and weight <= 160:
        if numWins >= 5:
            print("The player should start.")
        else:
            print("The player should not start.")
    else:
        print("The player should not start.")

main()
