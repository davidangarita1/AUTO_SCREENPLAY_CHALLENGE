package com.products.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CartPage {

    public static final Target CART_TABLE = Target.the("cart content table")
            .located(By.cssSelector(".table-responsive"));

    public static Target productInCart(String productName) {
        return Target.the("product in cart: " + productName)
                .located(By.xpath("//div[@class='table-responsive']//td/a[contains(text(),'" + productName + "')]"));
    }

    public static final Target CHECKOUT_BUTTON = Target.the("checkout button")
            .located(By.cssSelector("a[href*='route=checkout/checkout']"));
}
