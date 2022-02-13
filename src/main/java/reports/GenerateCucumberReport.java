package reports;


import enums.ConfigProperties;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import utils.ConfigFileReader;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Sreej
 */
public class GenerateCucumberReport {

    // Execute using main method

    /*
    public static void main(String[] args) throws IOException, ParseException {
          generateReport("src/test/resources/cucumberReport/cucumberReport.json");
    }
    */

    public static void generateReport(String jsonFile) throws IOException, ParseException {

        FileReader reader = new FileReader(jsonFile);
        JSONParser parser = new JSONParser();

        JSONArray jsonArray = (JSONArray) parser.parse(reader);
        for (Object obj : jsonArray) {
            JSONObject tempObject = (JSONObject) obj;
            String uri = tempObject.get("uri").toString().replace("file:", "");
            tempObject.replace("uri", uri);
            System.out.println(tempObject.get("uri"));
            System.out.println(tempObject.toJSONString());
        }

        FileWriter file = new FileWriter(jsonFile);
        file.write(jsonArray.toJSONString());
        System.out.println("File : " + file);
        file.close();

        Configuration con = new Configuration(new File("src/test/resources/cucumberReport/"), "Report");
        con.addClassifications("Author", System.getProperty("user.name").toUpperCase());
        con.addClassifications("Browser", ConfigFileReader.get(ConfigProperties.BROWSER).toUpperCase());


        List<String> jsonFiles = new ArrayList<>();
        jsonFiles.add(jsonFile);

        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, con);
        reportBuilder.generateReports();

    }


}
