package com.vivaair.screenplay.stepdefinitions;

import com.vivaair.screenplay.questions.TheSeatSelectionPage;
import com.vivaair.screenplay.tasks.ChooseCheapestTicket;
import com.vivaair.screenplay.tasks.SearchTicket;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.openqa.selenium.WebDriver;

import static com.vivaair.screenplay.model.FlightBuilder.origin;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class SearchTicketStepDefinitions {

    //ANOTACIÓN
    WebDriver driver;

    @Before
    public void prepareStage(){
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^(.*) wants to search a ticket$")
    public void megSearchAvailableTickets(String actorName) {
        //theActorCalled(actorName).wasAbleTo(Open.url("https://www.vivaair.com/co/es"));
        theActorCalled(actorName).attemptsTo(SearchTicket
                .with(origin("Medellin").andDestination("Bogota")));
    }

    @When("^Meg chooses the cheapest ticket$")
    public void megChooseCheapestTicket() {
        theActorInTheSpotlight()
                .attemptsTo(ChooseCheapestTicket.fromList());
    }

    @Then("^Meg should watch the seat selection page$")
    public void megShouldWatchTheSeatSelectionPage() {
        theActorInTheSpotlight().should(seeThat(TheSeatSelectionPage.isVisible()));
    }

}
