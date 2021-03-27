package com.vivaair.screenplay.userinterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

import static com.vivaair.screenplay.utils.SearchPageUtils.getTomorrowDateAsStr;

@DefaultUrl("https://www.vivaair.com/co/es")
public class SearchPage extends PageObject {

    //To close unwanted elements
    public static final Target NO_NOTIFICATIONS_BUTTON = Target
            .the("no notifications - button")
            .located(By.id("onesignal-slidedown-cancel-button"));
    public static final Target CLOSE_PRIVACY_POLICY_BUTTON = Target
            .the("Notification of privacy policy - close button")
            .located(By.className("cookie-container-content__button"));
    public static final Target CLOSE_SUBSCRIPTION_BUTTON = Target
            .the("Notice of subscriptions and discounts - close button")
            .located(By.className("icon material-icons newsletter_popup_close"));

    //To fill data
    public static final Target ONE_WAY_CHECKBOX = Target.the("one way - checkbox")
            .located(By.xpath("//span[contains(text(),'Solo ida')]"));
    public static final Target ORIGIN_FIELD = Target.the("origin - textbox")
            .located(By.id("criteria-airport-select-departure-input"));
    public static final Target DESTINATION_FIELD = Target.the("destination - textbox")
            .located(By.id("criteria-airport-select-destination-input"));
    public static final Target DATE_FIELD = Target.the("date field")
            .located(By.id("criteria-dates-from"));
    public static final Target TOMORROW_DATE_BUTTON = Target.the("tomorrow date - button")
            .located(By.xpath("//button[@date='" + getTomorrowDateAsStr() +"']"));
    public static final Target SEARCH_BUTTON = Target.the("search - button")
            .located(By.id("criteria-search-button-desktop"));

}
