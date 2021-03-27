package com.vivaair.screenplay.utils;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FlightSelectionPageUtils {

    public static int getIntPrice(WebElement webElement){
        return Integer.parseInt(webElement.getText()
                .substring(4).replaceAll(",", ""));
    }

    public static int[] getRealMinPrice(List<WebElementFacade> flightsPrices){
        int value;
        int valMinValue = getIntPrice(flightsPrices.get(0));
        int posMinValue = 0;
        for (int pos = 0; pos < flightsPrices.size(); pos++) {
            value = getIntPrice(flightsPrices.get(pos));

            if (value < valMinValue) {
                posMinValue = pos;
                valMinValue= value;
            }
        }

        return new int[]{ valMinValue, posMinValue };
    }




}
