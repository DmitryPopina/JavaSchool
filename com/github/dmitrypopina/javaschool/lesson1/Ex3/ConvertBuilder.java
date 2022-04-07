package com.github.dmitrypopina.javaschool.lesson1.Ex3;

class KelvinConverter extends Converter{

    @Override
    public double convertTo(double degree) {
        return degree + 273.15;
    }
}

class FahrenheitConverter extends Converter{
    @Override
    public double convertTo(double degree) {
        return (degree * 9 / 5) + 32;
    }
}

public class ConvertBuilder {
    protected String ConvertTypes = "KF";

    public Converter getConverter(char type) throws IllegalArgumentException{
        if (ConvertTypes.contains(new StringBuilder(1).append(type))){
            if (type == 'F') {
                return new FahrenheitConverter();
            }else {
                return new KelvinConverter();
            }
        }else {
            throw new IllegalArgumentException("Данный тип конвертера не поддерживается");
        }
    }

    @Override
    public String toString() {
        return "Выберите вариант конвертера: " + ConvertTypes;
    }
}

