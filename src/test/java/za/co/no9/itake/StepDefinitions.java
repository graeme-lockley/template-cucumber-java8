package za.co.no9.itake;

import cucumber.api.java8.En;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class StepDefinitions implements En {
    private Belly belly;
    private int waitingTime;

    public StepDefinitions() {
        Given("^I have (\\d+) cukes in my belly$", (Integer cukes) -> {
            belly = new Belly();
            belly.eat(cukes);
        });

        When("^I wait (\\d+) hour$", (Integer waitingTime) -> {
            this.waitingTime = waitingTime;
        });

        Then("^my belly should (.*)$", (String expectedSound) -> {
            String actualSound = belly.getSound(waitingTime);
            assertThat(actualSound, is(expectedSound));
        });
    }
}
