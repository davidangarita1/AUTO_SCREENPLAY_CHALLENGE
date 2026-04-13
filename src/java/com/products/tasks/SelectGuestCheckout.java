package com.products.tasks;

import com.products.ui.CheckoutPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SelectGuestCheckout implements Task {

    @Step("{0} selecciona la opcion de checkout como invitado")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(CheckoutPage.GUEST_CHECKOUT_RADIO),
                Click.on(CheckoutPage.ACCOUNT_CONTINUE_BUTTON),
                WaitUntil.the(CheckoutPage.FIRST_NAME, isVisible()).forNoMoreThan(15).seconds()
        );
    }

    public static Performable asGuest() {
        return Tasks.instrumented(SelectGuestCheckout.class);
    }
}
