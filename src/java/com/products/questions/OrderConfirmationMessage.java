package com.products.questions;

import com.products.ui.SuccessPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class OrderConfirmationMessage implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return SuccessPage.ORDER_SUCCESS_HEADING.resolveFor(actor).getText().trim();
    }

    public static Question<String> displayed() {
        return new OrderConfirmationMessage();
    }
}
