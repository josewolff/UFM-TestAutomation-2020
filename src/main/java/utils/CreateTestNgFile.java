package utils;

import com.hubspot.jinjava.Jinjava;
import org.apache.commons.io.FileUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

public class CreateTestNgFile {

    public static void main(String[] args) {
        Map<String, Object> context = new HashMap<>();
        String includeGroup = args[0];
        String apiHost = args[1];
        String seleniumHost = args[2];
        context.put("includeGroup", includeGroup);
        context.put("apiUrl", apiHost);
        context.put("seleniumHost", seleniumHost);
        String testNgTemplatePath = System.getProperty("user.dir") + "/src/test/resources/template.xml";
        String testNgFile = renderTemplate(context, testNgTemplatePath);
        String testNGFileLocation = System.getProperty("user.dir") + "/src/test/resources/testng.xml";
        writeFile(testNgFile, testNGFileLocation);
    }
    private static String renderTemplate(Map<String, Object> context, String path) {
        Jinjava jinjava = new Jinjava();
        String renderedTemplate = "";
        try {
            File file = new File(path);
            String template = FileUtils.readFileToString(file);
            renderedTemplate = jinjava.render(template, context);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return renderedTemplate;
    }
    private static void writeFile(String renderedTemplate, String fileName) {
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(fileName));
            out.write(renderedTemplate);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
