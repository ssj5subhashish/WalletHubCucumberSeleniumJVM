package steps;

import org.openqa.selenium.WebDriver;
import utils.ScenarioContext;

import java.util.HashMap;
import java.util.List;


public class BaseStepDef {
    protected final ScenarioContext context;

    public BaseStepDef( ScenarioContext context) {
        this.context = context;
    }
}