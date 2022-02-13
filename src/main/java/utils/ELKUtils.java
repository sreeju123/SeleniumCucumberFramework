package utils;

import enums.ConfigProperties;
import io.cucumber.plugin.event.Result;
import io.restassured.response.Response;
import org.testng.Assert;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

/**
 * @author Sreej
 */
public class ELKUtils {


    private ELKUtils() {

    }

    /**
     * Sends the request to Elastic Search to create Index Pattern
     * <p>
     * //     * @param scenario parameter to get run time data
     */
    public static void sendDetailsToElk(Result result, PicoContainer picoContainer, String status) {

        if (ConfigFileReader.get(ConfigProperties.SENDRESULTTOELK).equalsIgnoreCase("yes")) {
            System.out.println("Results to ELK");
            Map<String, Object> map = new HashMap<>();
            map.put("feature", picoContainer.dataStore.get("featureName"));
            map.put("scenarioName", picoContainer.dataStore.get("scenarioName"));
            map.put("status", status);
            map.put("executionTime", LocalDateTime.now().toString());
            map.put("duration", picoContainer.dataStore.get("duration"));
            map.put("build", "11"); // Can use this to filter the results in Kibana
            if (result.getStatus().toString().equals("FAILED")) {
                map.put("logs", picoContainer.dataStore.get("error"));
            }


            Response response = given().header("Content-Type", "application/json")
                    .log().all().
                            body(map)
                    .post(ConfigFileReader.get(ConfigProperties.ELKURL));

            Assert.assertEquals(response.statusCode(), 201);
            response.prettyPrint();
        }
    }


}
