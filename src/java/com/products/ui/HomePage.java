package com.products.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomePage {

    public static Target addToCartButton(String productName) {
        return Target.the("add to cart button for " + productName)
                .located(By.xpath("//div[contains(@class,'product-thumb')]" +
                        "//h4/a[normalize-space(.)='" + productName + "']" +
                        "/ancestor::div[contains(@class,'product-thumb')]" +
                        "//button[contains(@onclick,'cart.add')]"));
    }

    public static final Target CART_BUTTON = Target.the("cart button")
            .located(By.cssSelector("#cart > button"));

    public static final Target SUCCESS_ALERT = Target.the("success alert")
            .located(By.cssSelector(".alert-success"));

    public static final Target ALERT_CLOSE_BUTTON = Target.the("close alert button")
            .located(By.cssSelector(".alert-success .close"));
}
