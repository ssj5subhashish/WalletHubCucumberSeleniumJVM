package steps;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import utils.ScenarioContext;


public class WalletHubStepDefs extends BaseStepDef {

    public static String baseURL = "https://www.cowin.gov.in/home";

    public WalletHubStepDefs(ScenarioContext context) {
        super(context);
    }

    @And("^I open the Cowin website$")
    public void iOpenTheCowinWebsite() {
        context.selectedDriver.get(baseURL);
    }

    @After("@wallethub")
    public void AfterHook(){
        context.selectedDriver.quit();
    }
}