package com.github.dmitrypopina.javaschool.lesson1.Ex3;

class ReaumurConverter extends Converter{

    @Override
    public double convertTo(double degree) {
        return degree * 0.8;
    }
}

public class AdvancedConvertBuilder extends ConvertBuilder {
    private final String myConvertTypes = "R";

    @Override
    public Converter getConverter(char type) throws IllegalArgumentException{
        if (type == 'R') {
            return new ReaumurConverter();
        }else {
            return  super.getConverter(type);
        }
    }

    public AdvancedConvertBuilder() {
        super.ConvertTypes += myConvertTypes;
    }
}
