package ch8.ch8_opg13;
/*
Add a transfer method to the BankAccount class from the previous exercises.
Your method should move money from the current bank account to another account.
The method accepts two parameters: a second BankAccount to accept the money,
and a real number for the amount of money to transfer. There is a $5.00 fee for transferring money,
so this much must be deducted from the current account’s balance before any transfer.
The method should modify the two BankAccount objects such that “this” current object
has its balance decreased by the given amount plus the $5 fee, and the other account's
balance is increased by the given amount. If this account object does not have enough
money to make the full transfer, transfer whatever money is left after the $5 fee is deducted.
If this account has under $5 or the amount is 0 or less, no transfer should occur and neither
account's state should be modified. The following are some example calls to the method:
BankAccount ben = new BankAccount();
ben.deposit(80.00);
BankAccount hal = new BankAccount();
hal.deposit(20.00);
ben.transfer(hal, 20.00);
ben.transfer(hal, 10.00);
hal.transfer(ben, 60.00);
// ben $55, hal $40  (ben -$25, hal +$20)
// ben $40, hal $50  (ben -$15, hal +$10)
// ben $85, hal $ 0  (ben +$45, hal -$50)
 */
public class BankAccount {
    String name;
    double balance;
    double transactionFee = 0.0;

    public BankAccount(String name){
        this.name = name;
    }

    public void deposit(double amount){
        balance = balance + amount;
    }

    //sørger for at transactionFee ikke kan få ens balance til at blive negativ ved at bruge et if- statement
    public void withdraw(double amount){
        if (balance-amount-transactionFee < 0){
            return;
        } else {
            balance = balance - amount - transactionFee;
        }
    }
    // laver en transfer metode som kan fører penge fra en account til en anden.
    // Simpel metode, ikke meget at forklare. Første if statement tjekker om
    // der er nok funds at overføre - hvis ikke overfører den det der nu er
    // tilbage på kontoen og sætter balancen til 0.
    public void transfer (BankAccount account, double amount){
        int fee = 5;

        if(balance < amount + fee){
            System.out.println("You don't have enough funds to transfer that much.");
            System.out.println("The system will transfer as much as possible from your account.");
            account.deposit(balance - fee);
            balance = 0;

        } else if (balance > amount + fee) {
            account.deposit(amount);
            this.withdraw(amount + fee);

        } else {
            System.out.println("Not enough funds to make a transfer.");
        }
    }

    //En af kravene er at clienten skal kunne ændre transactionfee'en.
    public void setTransactionFee(double transactionFee) {
        this.transactionFee = transactionFee;
    }

    // Overrider den defaulte toString
    @Override
    public String toString() {
        return name + ", " + balance;
    }
}
