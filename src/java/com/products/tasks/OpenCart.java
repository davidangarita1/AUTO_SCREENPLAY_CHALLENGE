package com.products.tasks;

import com.products.ui.CartPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class OpenCart implements Task {

    @Step("{0} accede al carrito de compras")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url("http://opencart.abstracta.us/index.php?route=checkout/cart"),
                WaitUntil.the(CartPage.CART_TABLE, isVisible()).forNoMoreThan(15).seconds()
        );
    }

    public static Performable page() {
        return Tasks.instrumented(OpenCart.class);
    }
}
