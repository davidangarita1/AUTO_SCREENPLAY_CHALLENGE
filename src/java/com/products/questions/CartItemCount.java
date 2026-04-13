package com.products.questions;

import com.products.ui.HomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class CartItemCount implements Question<Integer> {

    @Override
    public Integer answeredBy(Actor actor) {
        String text = HomePage.CART_BUTTON.resolveFor(actor).getText().trim();
        return Integer.parseInt(text.split("\\s+")[0]);
    }

    public static Question<Integer> displayed() {
        return new CartItemCount();
    }
}
