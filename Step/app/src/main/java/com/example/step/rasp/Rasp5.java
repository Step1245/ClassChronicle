package com.example.step.rasp;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Rasp5 {
    public static void main(String[] args) {
        String text = "ПБ-01-23 ЭЗС-01-23 ЭГНП-01-23";
        Pattern pattern = Pattern.compile("([А-Я]+\\-\\d{2}\\-\\d{2})$");
        Matcher matcher = pattern.matcher(text);

        if (matcher.find()) {
//            matcher.group(1);
            String group = (matcher.group(1));
        }
    }
}
