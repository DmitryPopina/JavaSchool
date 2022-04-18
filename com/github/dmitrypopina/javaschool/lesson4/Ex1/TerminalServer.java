package com.github.dmitrypopina.javaschool.lesson4.Ex1;

import java.time.Instant;

class OutOfMoneyException extends Exception{
    OutOfMoneyException(String message) {
        super(message);
    }
}
class WrongAmountException extends Exception{
    WrongAmountException(String message) {
        super(message);
    }
}

class AccountIsLockedException extends Exception{
    public Instant getLockTime() {
        return lockTime;
    }

    private final Instant lockTime;
    AccountIsLockedException(String message, Instant lockTime) {
        super(message);
        this.lockTime = lockTime;
    }
}

class UnAuthorisedException extends Exception{
    UnAuthorisedException(String message) {
        super(message);
    }
}

public class TerminalServer {
    private double amount;
    private Instant lockClock, authClock;

    public void Auth(){
        lockClock = null;
        authClock = Instant.now().plusSeconds(20);
    }

    public Instant Lock()  {
        lockClock = Instant.now().plusSeconds(10);
        authClock = null;
        return lockClock;
    }

    public double checkStatus() throws AccountIsLockedException, UnAuthorisedException {
        if (lockClock != null && Instant.now().isBefore(lockClock) ) {
            throw new AccountIsLockedException("Account is locked", lockClock);
        }
        if (authClock != null && Instant.now().isBefore(authClock) ) {
            throw new UnAuthorisedException("Unauthorised!");
        }
        return this.amount;
    }

    public TerminalServer(double amount) {
        this.amount = amount;
    }

    public double giveMoney(double amount) throws WrongAmountException, OutOfMoneyException {
        if (amount <0){
            throw new WrongAmountException("Wrong money amount");
        }
        if (amount > this.amount){
            throw new OutOfMoneyException("Out of money");
        }else {
            this.amount -=amount;
            authClock = Instant.now().plusSeconds(20);
            return this.amount;
        }
    }

    public double takeMoney(double amount) throws WrongAmountException {
        if (amount <0 || amount%100!= 0){
            throw new WrongAmountException("Wrong money amount");
        }else {
            this.amount += amount;
            authClock = Instant.now().plusSeconds(20);
            return this.amount;
        }
    }

}
