## Michael Blackburn
## companyName.py

def main():
    domain = input("Enter the site domain: ")
    start = domain.find('.')
    end = domain.find('c')
    print(domain[start+1:end-1])

main()
