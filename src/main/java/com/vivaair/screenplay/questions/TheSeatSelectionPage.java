package com.vivaair.screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.vivaair.screenplay.userinterface.SeatSelectionPage.SEAT_PAGE;

public class TheSeatSelectionPage implements Question<Boolean> {

    public static Question<Boolean> isVisible() { return new TheSeatSelectionPage(); }

    @Override
    public Boolean answeredBy(Actor actor) {
        return SEAT_PAGE.resolveFor(actor).isVisible(); }

    @Override
    public String getSubject() { return "the seat selection page is visible"; }

}
