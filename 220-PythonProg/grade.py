def main():
    n = eval(input("number of grades to average: "))
    total = 0
    for i in range(n):
        grade = eval(input("enter grade: "))
        total = total + grade

    average = total / n
    print("the average is: ", average)
main()
