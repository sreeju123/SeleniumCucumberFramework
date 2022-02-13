package listeners;

import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.*;
import utils.PicoContainer;

import static utils.ELKUtils.sendDetailsToElk;

/**
 * @author Sreej
 */
public class BDDTestListener implements ConcurrentEventListener {

    @Override
    public void setEventPublisher(EventPublisher publisher) {
        publisher.registerHandlerFor(TestCaseFinished.class, this::handleTestCaseFinished);
    }

    private void handleTestCaseFinished(TestCaseFinished event) {
        PicoContainer picoContainer = new PicoContainer();
        TestCase testCase = event.getTestCase();
        Result result = event.getResult();
        Status status = result.getStatus();
        Throwable error = result.getError();

        String scenarioName = testCase.getName();
        picoContainer.dataStore.put("scenarioName", scenarioName);
        String featureName = testCase.getUri().toString().split(":")[2].split("features/")[1];
        picoContainer.dataStore.put("featureName", featureName);
        picoContainer.dataStore.put("duration", result.getDuration());

        if (status.toString().equals("PASSED")) {
            sendDetailsToElk(result, picoContainer, "PASS");
        } else if (status.toString().equals("FAILED")) {
            picoContainer.dataStore.put("error", error.getMessage());
            System.out.println("Error =" + error.getMessage());
            sendDetailsToElk(result, picoContainer, "FAIL");
        } else if (status.toString().equals("UNDEFINED")) {
            System.out.println("UNDEFINED steps in " + testCase.getName());
            sendDetailsToElk(result, picoContainer, "UNDEFINED");
        }

    }


}
