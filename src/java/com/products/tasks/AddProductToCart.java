package com.products.tasks;

import com.products.ui.HomePage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AddProductToCart implements Task {

    private final String productName;

    public AddProductToCart(String productName) {
        this.productName = productName;
    }

    @Step("{0} agrega el producto '#productName' al carrito")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(HomePage.addToCartButton(productName), isVisible()).forNoMoreThan(10).seconds(),
                Click.on(HomePage.addToCartButton(productName)),
                WaitUntil.the(HomePage.SUCCESS_ALERT, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(HomePage.ALERT_CLOSE_BUTTON)
        );
    }

    public static Task named(String productName) {
        return Tasks.instrumented(AddProductToCart.class, productName);
    }
}
