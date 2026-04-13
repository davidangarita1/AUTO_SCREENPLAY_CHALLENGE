package com.products.stepdefinitions;

import com.products.questions.CartContainsProduct;
import com.products.questions.CartItemCount;
import com.products.questions.OrderConfirmationMessage;
import com.products.questions.PaymentMethodIsVisible;
import com.products.tasks.AcceptTermsAndContinuePayment;
import com.products.tasks.AddProductToCart;
import com.products.tasks.ConfirmOrder;
import com.products.tasks.FillBillingDetails;
import com.products.tasks.NavigateToCheckout;
import com.products.tasks.NavigateToHomePage;
import com.products.tasks.OpenCart;
import com.products.tasks.SelectGuestCheckout;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

public class ShoppingStepDefinitions {

    private Actor customer;

    @Given("el usuario se encuentra en la pagina principal de la tienda")
    public void userIsOnHomePage() {
        customer = OnStage.theActorCalled("Cliente");
        customer.attemptsTo(NavigateToHomePage.open());
    }

    @When("agrega el producto {string} al carrito")
    public void addProductToCart(String productName) {
        customer.attemptsTo(AddProductToCart.named(productName));
    }

    @And("accede al carrito de compras")
    public void navigateToCart() {
        customer.attemptsTo(OpenCart.page());
    }

    @And("accede al checkout")
    public void navigateToCheckout() {
        customer.attemptsTo(NavigateToCheckout.page());
    }

    @And("selecciona la opcion de checkout como invitado")
    public void selectGuestCheckout() {
        customer.attemptsTo(SelectGuestCheckout.asGuest());
    }

    @And("completa los datos de facturacion")
    public void fillBillingDetails() {
        customer.attemptsTo(FillBillingDetails.withDefaults());
    }

    @And("acepta los terminos y continua con el metodo de pago")
    public void acceptTermsAndContinuePayment() {
        customer.attemptsTo(AcceptTermsAndContinuePayment.now());
    }

    @And("confirma el pedido")
    public void confirmOrder() {
        customer.attemptsTo(ConfirmOrder.now());
    }

    @Then("el carrito muestra {int} productos en total")
    public void cartShowsProductCount(int expectedCount) {
        customer.should(seeThat(CartItemCount.displayed(), is(expectedCount)));
    }

    @Then("el carrito muestra el producto {string}")
    public void cartShowsProduct(String productName) {
        customer.should(seeThat(CartContainsProduct.named(productName), is(true)));
    }

    @Then("el paso de metodo de pago es visible")
    public void paymentMethodStepIsVisible() {
        customer.should(seeThat(PaymentMethodIsVisible.onCheckout(), is(true)));
    }

    @Then("el sistema muestra el mensaje {string}")
    public void systemShowsMessage(String message) {
        customer.should(seeThat(OrderConfirmationMessage.displayed(), containsString(message)));
    }
}
