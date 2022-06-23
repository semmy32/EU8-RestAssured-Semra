package com.cydeo.step_definitions;

import com.cydeo.pages.WikiSearchPage;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Wiki_StepDefinitions {
    WikiSearchPage wikiSearchPage = new WikiSearchPage();


    @Given("User is on Wikipedia home page")
    public void userIsOnWikipediaHomePage() {
        Driver.getDriver().get("https://www.wikipedia.org");
    }

  /*  @When("User types Steve Jobs in the wiki search box")
    public void userTypesSteveJobsInTheWikiSearchBox() {
        wikiSearchPage.searchBox.sendKeys("Steve Jobs");


    @And("User clicks wiki search button")
    public void userClicksWikiSearchButton() {
        wikiSearchPage.searchButton.click();
    }

    @Then("User sees Steve Jobs is in the wiki title")
    public void userSeesSteveJobsIsInTheWikiTitle() {
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Steve Jobs"));
    }*/


    @When("User types {string} in the wiki search box")
    public void userTypesInTheWikiSearchBox(String string) {
        wikiSearchPage.searchBox.sendKeys(string);
    }

    @And("User clicks wiki search button")
    public void userClicksWikiSearchButton() {
        wikiSearchPage.searchButton.click();
    }

    @Then("User sees {string} is in the wiki title")
    public void userSeesIsInTheWikiTitle(String string) {
        Assert.assertTrue(Driver.getDriver().getTitle().contains(string));
    }

    @Then("User sees {string} is in the main header")
    public void userSeesIsInTheMainHeader(String string) {
        Assert.assertTrue(wikiSearchPage.mainHeader.isDisplayed());
    Assert.assertTrue(wikiSearchPage.mainHeader.getText().equals(string));
    }
}
