def main():
    n = 1
    d = 1
    su = 0
    num = eval(input("number of terms: "))
    for i in range (1, num+1):
        su = su + n/d
        d = d+1

    print("total = ", su)

main()
