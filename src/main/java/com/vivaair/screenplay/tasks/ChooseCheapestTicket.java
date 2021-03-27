package com.vivaair.screenplay.tasks;

import com.vivaair.screenplay.exceptions.NoFlightsFoundError;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static com.vivaair.screenplay.exceptions.NoFlightsFoundError.MESSAGE_NO_FLIGHT_FOUND;
import static com.vivaair.screenplay.userinterface.FlightSelectionPage.*;
import static com.vivaair.screenplay.userinterface.SeatSelectionPage.SEAT_PAGE;
import static com.vivaair.screenplay.utils.FlightSelectionPageUtils.getRealMinPrice;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

public class ChooseCheapestTicket implements Task {

    public static ChooseCheapestTicket fromList() {
        return instrumented(ChooseCheapestTicket.class);
    }

    @Override
    @Step("{0} try to choose the cheapest ticket")
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(PRICES_LIST, WebElementStateMatchers.isCurrentlyVisible())
                );

        actor.should(seeThat(the(PRICES_LIST), isVisible())
                .orComplainWith(NoFlightsFoundError.class,
                        MESSAGE_NO_FLIGHT_FOUND));

        actor.attemptsTo(
                Scroll.to(PRICES_LIST.resolveAllFor(actor)
                        .get(getRealMinPrice(PRICES_LIST.resolveAllFor(actor))[1])),

                //Resolver problema de intercepción para poder usar Click y no JavaScripClick
                JavaScriptClick.on(PRICES_LIST.resolveAllFor(actor)
                        .get(getRealMinPrice(PRICES_LIST.resolveAllFor(actor))[1])),

                WaitUntil.the(A_LA_CARTA_OPTION, WebElementStateMatchers.isClickable()),
                Scroll.to(A_LA_CARTA_OPTION),

                Check.whether(PEOPLE_SEEN_FLIGHT_CLOSE_BUTTON
                        .resolveAllFor(actor).size() > 0)
                        .andIfSo(JavaScriptClick.on(PEOPLE_SEEN_FLIGHT_CLOSE_BUTTON)),
                Check.whether(LAST_PURCHASE_CLOSE_BUTTON
                        .resolveAllFor(actor).size() > 0)
                        .andIfSo(JavaScriptClick.on(LAST_PURCHASE_CLOSE_BUTTON)),

                JavaScriptClick.on(A_LA_CARTA_OPTION),

                Scroll.to(CONTINUE_BUTTON),
                WaitUntil.the(CONTINUE_BUTTON, WebElementStateMatchers.isClickable()),
                Click.on(CONTINUE_BUTTON),

                //Esperar carga de la siguiente página
                WaitUntil.the(SEAT_PAGE, WebElementStateMatchers.isVisible())
        );

    }


}
