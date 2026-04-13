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

public class AcceptTermsAndContinuePayment implements Task {

    @Step("{0} acepta los terminos y continua con el metodo de pago")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(CheckoutPage.TERMS_AGREE_CHECKBOX, isVisible()).forNoMoreThan(15).seconds(),
                Click.on(CheckoutPage.TERMS_AGREE_CHECKBOX),
                Click.on(CheckoutPage.PAYMENT_METHOD_CONTINUE)
        );
    }

    public static Performable now() {
        return Tasks.instrumented(AcceptTermsAndContinuePayment.class);
    }
}
