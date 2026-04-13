package com.products.tasks;

import com.products.ui.CheckoutPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class FillBillingDetails implements Task {

    @Step("{0} completa los datos de facturacion")
    @Override
    public <T extends Actor> void performAs(T actor) {
        String email = "guest" + System.currentTimeMillis() + "@test.com";
        actor.attemptsTo(
                WaitUntil.the(CheckoutPage.FIRST_NAME, isVisible()).forNoMoreThan(15).seconds(),
                Enter.theValue("John").into(CheckoutPage.FIRST_NAME),
                Enter.theValue("Doe").into(CheckoutPage.LAST_NAME),
                Enter.theValue(email).into(CheckoutPage.EMAIL),
                Enter.theValue("1234567890").into(CheckoutPage.TELEPHONE),
                Enter.theValue("123 Main Street").into(CheckoutPage.ADDRESS),
                Enter.theValue("London").into(CheckoutPage.CITY),
                Enter.theValue("EC1A1BB").into(CheckoutPage.POSTCODE),
                SelectFromOptions.byVisibleText("United Kingdom").from(CheckoutPage.COUNTRY)
        );

        new WebDriverWait(BrowseTheWeb.as(actor).getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.numberOfElementsToBeMoreThan(
                        By.cssSelector("#input-payment-zone option"), 1));

        actor.attemptsTo(
                SelectFromOptions.byIndex(1).from(CheckoutPage.REGION),
                Click.on(CheckoutPage.GUEST_CONTINUE_BUTTON)
        );
    }

    public static Performable withDefaults() {
        return Tasks.instrumented(FillBillingDetails.class);
    }
}
