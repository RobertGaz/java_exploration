// lesson 11

package multithreading_tutorial;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLockLesson {
    public static void main(String[] args) throws InterruptedException {
        MyRunner runner = new MyRunner();

        Thread thread1 = new Thread() {
            @Override
            public void run() {
                runner.firstThread();
            }
        };

        Thread thread2 = new Thread() {
            @Override
            public void run() {
                runner.secondThread();
            }
        };

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        runner.finished();
    }
}

class MyRunner {

    private BankAccount account1 = new BankAccount();
    private BankAccount account2 = new BankAccount();

    private Lock lock1 = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();

    private Random random = new Random();

    private void takeLocks(Lock lockA, Lock lockB) {
        boolean firstLockTaken = false;
        boolean secondLockTaken = false;

        while (true) {
            try {
                firstLockTaken = lockA.tryLock();
                secondLockTaken = lockB.tryLock();
            } finally {
                if (firstLockTaken && secondLockTaken) {
                    return;
                }

                if (firstLockTaken) {
                    lockA.unlock();
                }

                if (secondLockTaken) {
                    lockB.unlock();
                }
            }
        }
    }

    public void firstThread() {
        for (int i = 0; i < 10000; i++) {
//            lock1.lock();
//            // тут дедлок
//            lock2.lock();
            takeLocks(lock1, lock2);
            try {
                BankAccount.transfer(account1, account2, random.nextInt(100));
            } finally {
                lock1.unlock();
                lock2.unlock();
            }
        }
    }

    public synchronized void secondThread() {
        for (int i = 0; i < 10000; i++) {
//            lock2.lock();
//            // тут дедлок
//            lock1.lock();

            takeLocks(lock2, lock1);
            try {
                    BankAccount.transfer(account2, account1, random.nextInt(100));
            } finally {
                lock2.unlock();
                lock1.unlock();
            }
        }
    }

    public void finished() {
        System.out.println("Balance 1: " + account1.getBalance());
        System.out.println("Balance 2: " + account2.getBalance());
        // Total balance should be 20000
        System.out.println("Total balance: " + (account1.getBalance() + account2.getBalance()));
    }


    public void firstThread_old() {
        for (int i = 0; i < 10000; i++) {
            synchronized (account1) {
                synchronized (account2) {
                    BankAccount.transfer(account1, account2, random.nextInt(100));
                }
            }
        }
    }

    public synchronized void secondThread_old() {
        for (int i = 0; i < 10000; i++) {
            synchronized (account2) {
                synchronized (account1){
                    BankAccount.transfer(account2, account1, random.nextInt(100));
                }
            }
        }
    }
}

class BankAccount {
    private int balance = 10000;

    public void addMoney(int amount) {
        balance += amount;
    }

    public void withdrawMoney(int amount) {
        balance -= amount;
    }

    public int getBalance() {
        return balance;
    }

    public static void transfer(BankAccount from, BankAccount to, int amount) {
        from.withdrawMoney(amount);
        to.addMoney(amount);
    }
}