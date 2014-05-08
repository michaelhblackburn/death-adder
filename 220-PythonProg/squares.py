def squares(values):
    for i in range(len(values)):
        values.append(values[i] ** 2)

def main():
    nums = [5, 12, 2]
    print(nums)
    squares(nums)
    print(nums)

main()
