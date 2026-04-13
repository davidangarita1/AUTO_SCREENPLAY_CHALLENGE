package com.products.tasks;

import com.products.ui.CheckoutPage;
import com.products.ui.SuccessPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ConfirmOrder implements Task {

    @Step("{0} confirma el pedido")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(CheckoutPage.CONFIRM_ORDER_BUTTON, isVisible()).forNoMoreThan(15).seconds(),
                Click.on(CheckoutPage.CONFIRM_ORDER_BUTTON),
                WaitUntil.the(SuccessPage.ORDER_SUCCESS_HEADING, isVisible()).forNoMoreThan(15).seconds()
        );
    }

    public static Performable now() {
        return Tasks.instrumented(ConfirmOrder.class);
    }
}
