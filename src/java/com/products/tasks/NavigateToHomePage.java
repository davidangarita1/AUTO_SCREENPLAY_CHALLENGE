package com.products.tasks;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.model.environment.SystemEnvironmentVariables;

public class NavigateToHomePage implements Task {

    @Step("{0} navega a la pagina principal de la tienda")
    @Override
    public <T extends Actor> void performAs(T actor) {
        String baseUrl = EnvironmentSpecificConfiguration
                .from(SystemEnvironmentVariables.currentEnvironmentVariables())
                .getProperty("webdriver.base.url");
        actor.attemptsTo(Open.url(baseUrl));
    }

    public static Performable open() {
        return Tasks.instrumented(NavigateToHomePage.class);
    }
}
