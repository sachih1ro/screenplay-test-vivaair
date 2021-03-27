package com.vivaair.screenplay.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = {"src/test/resources/features/search_ticket.feature"},
        glue = {"com.vivaair.screenplay.stepdefinitions"},
        snippets = SnippetType.CAMELCASE)
public class SearchTicket {
}

