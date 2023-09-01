package br.com.vicente;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Plate {
    private String value;

    public Plate(String value) {
        String regex = "[A-Z]{3}[0-9]{4}";



        Pattern pattern = Pattern.compile(regex);


        Matcher matcher = pattern.matcher(value);
        if(!matcher.matches()){
            throw  new RuntimeException("Invalid plate");
        }

        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
