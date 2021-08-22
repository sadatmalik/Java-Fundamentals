package labs_examples.multi_threading.labs;

/**
 * Multithreading Exercise 4:
 *
 *      Demonstrate the use of a synchronized block and a synchronized method - ensure that the synchronization is
 *      working as expected
 */

class BankAccount {

    int balance;

    public BankAccount(int balance) {
        System.out.println("Opening balance: " + balance);
        this.balance = balance;
    }

    public synchronized void deposit(int deposit, String name) {
        System.out.println("\nHello, " + name);
        System.out.println(name + ", you are depositing £" + deposit);
        balance += deposit;
        System.out.println(name + ", your new balance is £" + balance);
    }

    public void withdraw(int withdraw, String name) {
        synchronized(this) {
            System.out.println("\nHello, " + name);
            System.out.println(name + ", you are withdrawing £" + withdraw);
            balance -= withdraw;
            System.out.println(name + ", your new balance is £" + balance);
        }
    }

}

class JointBankAccountDemo {

    public static void main(String[] args) {
        BankAccount account = new BankAccount(200);
        account.deposit(20, "John");
        account.deposit(25, "Jane");
        account.withdraw(10, "John");
        account.deposit(5, "Jane");
        account.deposit(15, "Jane");
        account.withdraw(30, "John");
    }
}