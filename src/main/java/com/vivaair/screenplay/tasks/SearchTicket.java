package com.vivaair.screenplay.tasks;

import com.vivaair.screenplay.model.Flight;
import com.vivaair.screenplay.userinterface.SearchPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.conditions.Check;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.Keys;

import static com.vivaair.screenplay.interactions.CheckIfExistsAndClickIfSo.checkIfExistsAndClickIfSo;
import static com.vivaair.screenplay.userinterface.SearchPage.*;
import static com.vivaair.screenplay.utils.SearchPageUtils.getTomorrowDateAsStr;
import static com.vivaair.screenplay.utils.SearchPageUtils.waitSomeSeconds;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SearchTicket implements Task {

    private Flight flight;
    private SearchPage searchPage;

    public SearchTicket(Flight flight){
        this.flight = flight;
    }

    public static SearchTicket with(Flight flight) {
        return instrumented(SearchTicket.class, flight);
    }

    @Override
    @Step("{0} try to search flights")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.browserOn(searchPage));

        //close unwanted elements
        actor.attemptsTo(
                Check.whether(NO_NOTIFICATIONS_BUTTON.resolveAllFor(actor).size() > 0)
                        .andIfSo(Click.on(NO_NOTIFICATIONS_BUTTON)),
                Check.whether(CLOSE_PRIVACY_POLICY_BUTTON.resolveAllFor(actor).size() > 0)
                        .andIfSo(Click.on(CLOSE_PRIVACY_POLICY_BUTTON)),
                Check.whether(CLOSE_SUBSCRIPTION_BUTTON.resolveAllFor(actor).size() > 0)
                        .andIfSo(Click.on(CLOSE_SUBSCRIPTION_BUTTON))

                /*
                // No funciona aún
                checkIfExistsAndClickIfSo(NO_NOTIFICATIONS_BUTTON),
                checkIfExistsAndClickIfSo(CLOSE_PRIVACY_POLICY_BUTTON),
                checkIfExistsAndClickIfSo(CLOSE_SUBSCRIPTION_BUTTON)
                 */
        );

        // fill data and search tickets
        actor.attemptsTo(
                Click.on(ONE_WAY_CHECKBOX),
                Enter.theValue(flight.getOriginStr()).into(ORIGIN_FIELD),
                Enter.theValue(flight.getDestinationStr()).into(DESTINATION_FIELD),
                Click.on(DATE_FIELD),
                Scroll.to(TOMORROW_DATE_BUTTON),
                Click.on(TOMORROW_DATE_BUTTON),
                Scroll.to(SEARCH_BUTTON),
                Click.on(SEARCH_BUTTON)
                );

    }



}
