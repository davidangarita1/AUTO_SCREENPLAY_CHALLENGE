package com.products.questions;

import com.products.ui.CheckoutPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class PaymentMethodIsVisible implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.attemptsTo(WaitUntil.the(CheckoutPage.PAYMENT_METHOD_PANEL, isVisible()).forNoMoreThan(15).seconds());
        return CheckoutPage.PAYMENT_METHOD_PANEL.resolveFor(actor).isVisible();
    }

    public static Question<Boolean> onCheckout() {
        return new PaymentMethodIsVisible();
    }
}
