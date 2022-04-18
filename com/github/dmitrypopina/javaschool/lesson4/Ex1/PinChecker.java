package com.github.dmitrypopina.javaschool.lesson4.Ex1;

class InvalidPinException extends Exception{
    InvalidPinException(String message) {
        super(message);
    }
}

class TooManyWrongPinsException extends Exception{
    TooManyWrongPinsException(String message) {
        super(message);
    }
}

public class PinChecker {
    private int wrongPins;

    public boolean checkPin(Integer pin) throws InvalidPinException, TooManyWrongPinsException {
        if (pin == 1234){
            wrongPins = 0;
            return true;
        }else {
            wrongPins += 1;
            if (wrongPins == 3) {
                throw new TooManyWrongPinsException("Too many wrong pin count");
            }
            throw new InvalidPinException("Invalid Pin");
        }
    }
}