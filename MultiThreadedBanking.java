//Level 3 Task 2
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class BankAccount {
    private double balance;
    private final Lock lock = new ReentrantLock();

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void withdraw(double amount, String customerName) {
        lock.lock();
        try {
            if (balance >= amount) {
                System.out.println(customerName + " is withdrawing " + amount);
                Thread.sleep(100); 
                balance -= amount;
                System.out.println(customerName + " completed withdrawal. Remaining balance: " + balance);
            } else {
                System.out.println(customerName + " attempted to withdraw " + amount + " but insufficient balance.");
            }
        } catch (InterruptedException e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            lock.unlock();
        }
    }
}

class Customer extends Thread {
    private final BankAccount account;
    private final double withdrawalAmount;

    public Customer(BankAccount account, double withdrawalAmount, String name) {
        super(name);
        this.account = account;
        this.withdrawalAmount = withdrawalAmount;
    }

    @Override
    public void run() {
        account.withdraw(withdrawalAmount, getName());
    }
}

public class MultiThreadedBanking {
    public static void main(String[] args) {
        BankAccount sharedAccount = new BankAccount(1000);

        Customer customer1 = new Customer(sharedAccount, 500, "Customer-1");
        Customer customer2 = new Customer(sharedAccount, 700, "Customer-2");
        Customer customer3 = new Customer(sharedAccount, 300, "Customer-3");

        customer1.start();
        customer2.start();
        customer3.start();

        try {
            customer1.join();
            customer2.join();
            customer3.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted: " + e.getMessage());
        }

        System.out.println("All transactions completed.");
    }
}
