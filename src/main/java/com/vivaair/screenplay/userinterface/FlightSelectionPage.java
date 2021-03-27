package com.vivaair.screenplay.userinterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class FlightSelectionPage extends PageObject {

    // To extract data
    public static final Target SUGGESTED_MIN_PRICE = Target.the("minpricesug")
            .located(By.xpath("//div[@id='days-0']/button[@class='day selected']" +
                    "/div[@class='price']"));
    public static final Target PRICES_LIST = Target.the("priceslist")
            .located(By.xpath("//div[@class='from-price']"));

    //To close unwanted elements
    public static final Target PEOPLE_SEEN_FLIGHT_CLOSE_BUTTON = Target.the("people")
            .located(By.xpath("//div[@id='bx-searches-modal__btn-close-icon']"));
    public static final Target LAST_PURCHASE_CLOSE_BUTTON = Target.the("people")
            .located(By.xpath("//div[@id='bx-last-booked-modal__btn-close-icon']"));


    // To choose the cheapest ticket
    public static final Target A_LA_CARTA_OPTION = Target.the("a_la_carta")
            .located(By.xpath("//div[@class='fare-footer bold viva fare-disabled']"));
    public static final Target CONTINUE_BUTTON = Target.the("continuep2")
            .located(By.xpath("//button[span[contains(text(),'Continuar')]]"));





}
