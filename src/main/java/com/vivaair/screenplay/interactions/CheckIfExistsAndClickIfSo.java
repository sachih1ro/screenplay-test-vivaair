package com.vivaair.screenplay.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.targets.Target;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CheckIfExistsAndClickIfSo implements Interaction {

    private final Target target;

    public CheckIfExistsAndClickIfSo(Target target){
        this.target = target;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Check.whether(target
                .resolveAllFor(actor).size() > 0)
                .andIfSo(JavaScriptClick.on(target));
    }

    public static CheckIfExistsAndClickIfSo checkIfExistsAndClickIfSo(Target target) {
        return instrumented(CheckIfExistsAndClickIfSo.class, target);
    }
}
