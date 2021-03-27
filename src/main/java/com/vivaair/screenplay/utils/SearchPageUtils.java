package com.vivaair.screenplay.utils;

import net.serenitybdd.screenplay.Performable;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SearchPageUtils {

    public static String getTomorrowDateAsStr(){
        DateTimeFormatter dateFormat_yyyyMMdd = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDateTime.now().plusDays(1).format(dateFormat_yyyyMMdd);
    }

    public static Performable waitSomeSeconds(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

}
