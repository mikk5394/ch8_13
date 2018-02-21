package ch8.ch8_opg13;

public class ch8_13_run {
    public static void main(String[] args) {

        BankAccount bankAccountMikkel =  new BankAccount("Mikkel");
        bankAccountMikkel.deposit(50);
        BankAccount bankAccountWhatever =  new BankAccount("Whatever");
        bankAccountWhatever.deposit(100);


        bankAccountMikkel.transfer(bankAccountWhatever,70);
        System.out.println();
        System.out.println(bankAccountMikkel);
        System.out.println(bankAccountWhatever);

    }
}
