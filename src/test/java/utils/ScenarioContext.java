package utils;

import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScenarioContext {
    public WebDriver selectedDriver;
    public Map<String, List<String>> vars = new HashMap<String, List<String>>();
}
