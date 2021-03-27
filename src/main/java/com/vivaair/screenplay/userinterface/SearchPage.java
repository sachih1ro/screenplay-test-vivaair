package com.vivaair.screenplay.userinterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

import static com.vivaair.screenplay.utils.SearchPageUtils.getTomorrowDateAsStr;

@DefaultUrl("https://www.vivaair.com/co/es")
public class SearchPage extends PageObject {

    //To close unwanted elements
    public static final Target NO_NOTIFICATIONS_BUTTON = Target.the("nonotify")
            .located(By.id("onesignal-slidedown-cancel-button"));
    public static final Target CLOSE_PRIVACY_POLICY_BUTTON = Target.the("okprivpol")
            .located(By.className("cookie-container-content__button"));
    public static final Target CLOSE_SUBSCRIPTION_BUTTON = Target.the("nosubs")
            .located(By.className("icon material-icons newsletter_popup_close"));

    //To fill data
    public static final Target ONE_WAY_CHECKBOX = Target.the("soloida")
            .located(By.xpath("//span[contains(text(),'Solo ida')]"));
    public static final Target ORIGIN_FIELD = Target.the("origin")
            .located(By.id("criteria-airport-select-departure-input"));
    public static final Target DESTINATION_FIELD = Target.the("destination")
            .located(By.id("criteria-airport-select-destination-input"));
    public static final Target DATE_FIELD = Target.the("date")
            .located(By.id("criteria-dates-from"));
    public static final Target TOMORROW_DATE_BUTTON = Target.the("date_tomorrow")
            .located(By.xpath("//button[@date='" + getTomorrowDateAsStr() +"']"));
    public static final Target SEARCH_BUTTON = Target.the("date_tomorrow")
            .located(By.id("criteria-search-button-desktop"));

}
