package com.products.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CheckoutPage {

    public static final Target GUEST_CHECKOUT_RADIO = Target.the("guest checkout radio")
            .located(By.cssSelector("input[value='guest']"));

    public static final Target ACCOUNT_CONTINUE_BUTTON = Target.the("account continue button")
            .located(By.cssSelector("#button-account"));

    public static final Target FIRST_NAME = Target.the("first name field")
            .located(By.cssSelector("#input-payment-firstname"));

    public static final Target LAST_NAME = Target.the("last name field")
            .located(By.cssSelector("#input-payment-lastname"));

    public static final Target EMAIL = Target.the("email field")
            .located(By.cssSelector("#input-payment-email"));

    public static final Target TELEPHONE = Target.the("telephone field")
            .located(By.cssSelector("#input-payment-telephone"));

    public static final Target ADDRESS = Target.the("address field")
            .located(By.cssSelector("#input-payment-address-1"));

    public static final Target CITY = Target.the("city field")
            .located(By.cssSelector("#input-payment-city"));

    public static final Target POSTCODE = Target.the("postcode field")
            .located(By.cssSelector("#input-payment-postcode"));

    public static final Target COUNTRY = Target.the("country select")
            .located(By.cssSelector("#input-payment-country"));

    public static final Target REGION = Target.the("region select")
            .located(By.cssSelector("#input-payment-zone"));

    public static final Target GUEST_CONTINUE_BUTTON = Target.the("guest billing continue button")
            .located(By.cssSelector("#button-guest"));

    public static final Target PAYMENT_METHOD_PANEL = Target.the("payment method panel")
            .located(By.cssSelector("#collapse-payment-method"));

    public static final Target TERMS_AGREE_CHECKBOX = Target.the("terms agree checkbox")
            .located(By.cssSelector("input[name='agree']"));

    public static final Target PAYMENT_METHOD_CONTINUE = Target.the("payment method continue button")
            .located(By.cssSelector("#button-payment-method"));

    public static final Target CONFIRM_ORDER_PANEL = Target.the("confirm order panel")
            .located(By.cssSelector("#collapse-checkout-confirm"));

    public static final Target CONFIRM_ORDER_BUTTON = Target.the("confirm order button")
            .located(By.cssSelector("#button-confirm"));
}
