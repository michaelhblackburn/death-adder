#formatting practice
# Michael Blackburn and Ian Mathies

def main():

    print("It’s raining {1} and {0}.".format("dogs", "cats"))
    #expected output:
    #It's raining cats and dogs

    print("{0:0.2f} {1:0.3f}".format(2.3, .4567))
    #expected output:
    #2.30 0.457

    print("Time left {0:0>2}:{1:0>5.2f}".format(3, 7.4589))
    #expected output:
    #Time left 03:07.46

main()
