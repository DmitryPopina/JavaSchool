package com.github.dmitrypopina.javaschool.lesson4.Ex1;



public class Terminal {
    TerminalServer terminalServer = new TerminalServer(1000);
    PinChecker pinChecker = new PinChecker();

    public boolean ValidatePin(Integer pin) {
        try {
            return pinChecker.checkPin(pin);
        } catch (InvalidPinException e) {
            throw new RuntimeException("Введен некорретный пин, просьба повторить", e);
        } catch (TooManyWrongPinsException e) {
            throw new RuntimeException("Количество неудачных вводов пин кода превысило максимально допустимое, счет заблокирован на 10 секунд",e);
        }
    }

    double CheckAccount (){
        try {
            return terminalServer.checkStatus();
        } catch (AccountIsLockedException e) {
            throw new RuntimeException("Счет заблокирован до " + e.getLockTime(), e);
        } catch (UnAuthorisedException e) {
            throw new RuntimeException("Превышен таймаут сессии, необходимо авторизоваться", e);
        }
    }

    double WithdrawMoney(Integer amount) {
        double cashAmount= CheckAccount();
        try {
            return terminalServer.giveMoney(amount);
        } catch (WrongAmountException e) {
            throw new RuntimeException("Введено некорректное значение суммы для снятия, необходимо ввести сумму, кратную 100",e);
        } catch (OutOfMoneyException e) {
            throw new RuntimeException("Введена сумма, превышающая доступную к снятию со счета: " + cashAmount, e);
        }
    }
    double PutMoney(Integer amount) {
        try {
            return terminalServer.takeMoney(amount);
        } catch (WrongAmountException e) {
            throw new RuntimeException(e);
        }
    }
}