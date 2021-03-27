package com.vivaair.screenplay.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SeatSelectionPage {
    public static final Target SEAT_PAGE = Target
            .the("Seat selection - map container")
            .located(By.id("seats-modal-body"));
    //Ocasionalmente alguno no es encontrado, se debe cambiar WaitUntil por otro que no
    //asuma su existencia temprana
    //By.id("seats-modal-body")
    //By.xpath("//div[@class='seat-map-container']")
    //By.xpath("//div[@class='seat-map-container']"))
}
