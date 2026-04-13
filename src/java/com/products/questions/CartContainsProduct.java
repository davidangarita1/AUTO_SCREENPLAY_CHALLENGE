package com.products.questions;

import com.products.ui.CartPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CartContainsProduct implements Question<Boolean> {

    private final String productName;

    public CartContainsProduct(String productName) {
        this.productName = productName;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        try {
            actor.attemptsTo(
                    WaitUntil.the(CartPage.productInCart(productName), isVisible()).forNoMoreThan(10).seconds()
            );
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static Question<Boolean> named(String productName) {
        return new CartContainsProduct(productName);
    }
}
