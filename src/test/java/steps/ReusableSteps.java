package steps;

import cucumber.api.java.en.Given;
import utils.ScenarioContext;

import static utils.BrowserSetup.*;

public class ReusableSteps extends BaseStepDef{

    public ReusableSteps(ScenarioContext context) {
        super(context);
    }

    @Given("^I select the browser \"([^\"]*)\"$")
    public void iSelectTheBrowser(String browser) {
        switch (browser) {
            case "Chrome":
                context.selectedDriver = chromeDriver();
                break;
            case "Firefox":
                context.selectedDriver = firefoxDriver();
                break;
            case "Edge":
                context.selectedDriver = edgeDriver();
                break;
            default:
                System.out.println("Wrong Input");
        }
    }
}
