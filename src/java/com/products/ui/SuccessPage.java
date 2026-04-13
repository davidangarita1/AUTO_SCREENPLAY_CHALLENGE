package com.products.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SuccessPage {

    public static final Target ORDER_SUCCESS_HEADING = Target.the("order success heading")
            .located(By.cssSelector("#content h1"));
}
