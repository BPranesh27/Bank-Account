class BankAccount:
    def __init__(self, Acc_holder, balance=0):
        self.Acc_holder = Acc_holder
        self.balance = balance

    def deposit(self, amount):
        self.balance += amount
        return f"Deposited amount ${amount}. Current Balance: ${self.balance}"

    def withdrawal(self, amount):
        if amount <= self.balance:
            self.balance -= amount
            return f"Withdrawal amount ${amount}. Current Balance: ${self.balance}"
        else:
            return "Insufficient Balance"

    def check_balance(self):
        return f"Current Balance: ${self.balance}"

user_name = input("Enter your name: ")
IOB = BankAccount(user_name)

choice = "yes"
while choice == "yes":
    choose = input("Choose an action: Deposit=1, Withdrawal=2, or Check balance=3: ").lower()
    if choose == "1":
        amount = int(input("Enter deposit amount: "))
        print(IOB.deposit(amount))
    elif choose == "2":
        amount = int(input("Enter withdrawal amount: "))
        print(IOB.withdrawal(amount))
    elif choose == "3":
        print(IOB.check_balance())
    else:
        print("Invalid option. Please try again.")

    choice = input("Would you like to continue? Yes or No: ").lower()
