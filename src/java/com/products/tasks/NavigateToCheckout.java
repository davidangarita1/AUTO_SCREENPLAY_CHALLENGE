package com.products.tasks;

import com.products.ui.CheckoutPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.model.environment.SystemEnvironmentVariables;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class NavigateToCheckout implements Task {

    @Step("{0} accede al checkout")
    @Override
    public <T extends Actor> void performAs(T actor) {
        String baseUrl = EnvironmentSpecificConfiguration
                .from(SystemEnvironmentVariables.currentEnvironmentVariables())
                .getProperty("webdriver.base.url");
        actor.attemptsTo(
                Open.url(baseUrl + "/index.php?route=checkout/checkout"),
                WaitUntil.the(CheckoutPage.GUEST_CHECKOUT_RADIO, isVisible()).forNoMoreThan(15).seconds()
        );
    }

    public static Performable page() {
        return Tasks.instrumented(NavigateToCheckout.class);
    }
}
