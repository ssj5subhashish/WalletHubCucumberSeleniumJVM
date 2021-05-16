package steps;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ScenarioContext;

public class FacebookStepDefs extends BaseStepDef {


    public FacebookStepDefs(ScenarioContext context) {
        super(context);
    }
    private String baseURL = "https://www.facebook.com/";
    private WebDriverWait wait = new WebDriverWait(context.selectedDriver, 30);

    @And("^I open the Facebook website$")
    public void iOpenTheFacebookWebsite() {
        context.selectedDriver.get(baseURL);
    }

    @And("^I login by providing the username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void iLoginByProvidingTheUsernameAndPassword(String username, String password) {
        context.selectedDriver.findElement(By.id("email")).sendKeys(username);
        context.selectedDriver.findElement(By.id("pass")).sendKeys(password);
        context.selectedDriver.findElement(By.name("login")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@aria-label='Home']")));
    }

    @And("^I navigate to the create post modal$")
    public void iNavigateToTheCreatePostModal() {
        context.selectedDriver.findElement(By.xpath("//*[@aria-label='Home']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),\"What's on your mind\")]")));
        context.selectedDriver.findElement(By.xpath("//span[contains(text(),\"What's on your mind\")]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@aria-label=\"Photo/Video\"]")));
    }

    @When("^I post the message \"([^\"]*)\"$")
    public void iPostTheMessage(String message){
        context.selectedDriver.findElement(By.xpath("//*[@class=\"notranslate _5rpu\"]")).sendKeys(message);
        context.selectedDriver.findElement(By.xpath("//*[@aria-label='Post']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@role=\"feed\"]")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'"+message+"')]")));
    }

    @Then("^the post \"([^\"]*)\" should be successfully added$")
    public void thePostShouldBeSuccessfullyAdded(String message) {
        String getExpectedValue = context.selectedDriver.findElement(By.xpath("//div[contains(text(),'"+message+"')]")).getText();
        assert getExpectedValue.equals(message);
    }

    public void removePost(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@aria-label=\"Actions for this post\"]")));
        context.selectedDriver.findElement(By.xpath("//*[@aria-label=\"Actions for this post\"]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),\"Move to Recycle bin\")]")));
        context.selectedDriver.findElement(By.xpath("//span[contains(text(),\"Move to Recycle bin\")]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@aria-label=\"Move\"]")));
        context.selectedDriver.findElement(By.xpath("//*[@aria-label=\"Move\"]")).click();
    }

    @After("@facebook")
    public void AfterHook(){
        removePost();
        context.selectedDriver.quit();
    }
}