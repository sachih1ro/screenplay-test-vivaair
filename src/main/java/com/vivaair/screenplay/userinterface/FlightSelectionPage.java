package com.vivaair.screenplay.userinterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class FlightSelectionPage extends PageObject {

    // To extract data
    public static final Target SUGGESTED_MIN_PRICE = Target
            .the("Suggested minimal price")
            .located(By.xpath("//div[@id='days-0']/button[@class='day selected']" +
                    "/div[@class='price']"));
    public static final Target PRICES_LIST = Target.the("ticket price list")
            .located(By.xpath("//div[@class='from-price']"));

    //To close unwanted elements
    public static final Target PEOPLE_LOOKING_THIS_FLIGHT_CLOSE_BUTTON = Target
            .the("notification of people this this flight - close button")
            .located(By.xpath("//div[@id='bx-searches-modal__btn-close-icon']"));
    public static final Target LAST_PURCHASE_CLOSE_BUTTON = Target
            .the("notification of time since last purchase - close button")
            .located(By.xpath("//div[@id='bx-last-booked-modal__btn-close-icon']"));


    // To choose the cheapest ticket
    public static final Target MIN_PRICE_OPTION = Target
            .the("min price option - button")
            .located(By.xpath("//div[@class='fare-footer bold viva fare-disabled']"));
    public static final Target CONTINUE_BUTTON = Target.the("continue - button")
            .located(By.xpath("//button[span[contains(text(),'Continuar')]]"));





}
