package com.BleuCRM.step_definitions;

import com.BleuCRM.pages.UploadFile_to_MessagePage;
import com.BleuCRM.pages.LoginPage;
import com.BleuCRM.utilities.BrowserUtils;
import com.BleuCRM.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Upload_files_step_def {
    LoginPage loginpage = new LoginPage();
    UploadFile_to_MessagePage homePage = new UploadFile_to_MessagePage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
    String photo1Path = "C:\\Users\\GENCAL\\OneDrive - NTT DATA EMEA\\Pictures\\Saved Pictures\\rabbit1.jpeg";
    String photo2Path = "C:\\Users\\GENCAL\\OneDrive - NTT DATA EMEA\\Desktop\\Zugpsitze_mountain.jpg";

    String pdfPath = "C:\\Users\\GENCAL\\OneDrive - NTT DATA EMEA\\Desktop\\BleuCRM_App_info.pdf";
    String htmlPath = "C:\\Users\\GENCAL\\Downloads\\sqldeveloper-20.4.1.407.0006-no-jre\\sqldeveloper\\sqldeveloper\\extensions\\oracle.datamodeler\\xmlmetadata\\doc\\details.html";
    String pngPath = "C:\\Users\\GENCAL\\OneDrive - NTT DATA EMEA\\Desktop\\eid.png";
    String gifPath = "C:\\Users\\GENCAL\\OneDrive - NTT DATA EMEA\\Desktop\\love.gif";
    String docxPath = "C:\\Users\\GENCAL\\OneDrive - NTT DATA EMEA\\Desktop\\Short notes for selenium.docx";
    String excelPath = "C:\\Users\\GENCAL\\OneDrive - NTT DATA EMEA\\Desktop\\inventory.xlsx";


    @Given("as a user I am on the BleuCRM homepage")
    public void as_a_user_i_am_on_the_bleu_crm_homepage() {
        loginpage.loginHomePage();
    }

    @When("I click on MESSAGE button and then Upload files icon")
    public void I_click_on_MESSAGE_button_and_then_upload_files_icon() {
        homePage.openUploadFunction();
        BrowserUtils.waitFor(2);
    }

    @And("upload three files at the same time")
    public void upload_three_files_at_the_same_time() {

        homePage.uploadFilesandImages.sendKeys(photo1Path);
        homePage.uploadFilesandImages.sendKeys(photo2Path);
        homePage.uploadFilesandImages.sendKeys(pdfPath);
        BrowserUtils.waitFor(10);


    }

    @Then("I should see all together uploaded files name list")
    public void I_should_See_All_Together_Uploaded_Files_NameList() {
       try{ List< WebElement> uploadList= Driver.getDriver().findElements(By.xpath("//td[@class='files-name']"));
        for (WebElement each : uploadList) {
            Assert.assertTrue(each.isDisplayed());}

        }catch (StaleElementReferenceException e){
       }
        BrowserUtils.waitFor(5);
    }


    @And("upload files in different formats as specified")
    public void upload_files_in_different_formats_as_specified() {
        homePage.uploadFilesandImages.sendKeys(pdfPath);
        homePage.uploadFilesandImages.sendKeys(pngPath);
        homePage.uploadFilesandImages.sendKeys(docxPath);
        BrowserUtils.waitFor(5);
    }

    @Then("I should see specified formatted files at attached files section")
    public void i_should_see_specified_formatted_files_at_attached_files_section() {
        BrowserUtils.verifyElementDisplayed(By.xpath("//span[@class='f-wrap']"));
        BrowserUtils.waitFor(5);
    }

    @When("upload HTML and excel files")
    public void upload_html_and_excel_files() {
        homePage.uploadFilesandImages.sendKeys(htmlPath);
        homePage.uploadFilesandImages.sendKeys(excelPath);
        BrowserUtils.waitFor(5);
    }

    @Then("HTML and excel files couldn't be uploaded")
    public void html_and_excel_files_couldn_t_be_uploaded() {
        BrowserUtils.verifyElementNotDisplayed(By.xpath("//span[@class='f-wrap']"));
        BrowserUtils.waitFor(5);
    }

    @Then("upload pictures in JPEG, PNG and GIF formats")
    public void upload_pictures_in_jpeg_png_and_gif_formats() {
        homePage.uploadFilesandImages.sendKeys(photo1Path);
        homePage.uploadFilesandImages.sendKeys(pngPath);
        homePage.uploadFilesandImages.sendKeys(gifPath);
        BrowserUtils.waitFor(5);
    }

    @Then("I should see uploaded picture files name list")
    public void i_should_see_uploaded_picture_files_name_list() {
        List<WebElement> uploaded = Driver.getDriver().findElements(By.xpath("//span[@class='f-wrap']"));
        for (WebElement eachPicture : uploaded) {
            Assert.assertTrue(eachPicture.isDisplayed());
        }
        BrowserUtils.waitFor(5);
    }

    @When("I upload picture in JPEG, PNG or GIF formats")
    public void i_upload_picture_in_jpeg_png_or_gif_formats() {
        homePage.uploadFilesandImages.sendKeys(photo2Path);
    }

    @Then("I should see uploaded picture itself in Activity Stream.")
    public void i_should_see_uploaded_picture_itself_in_activity_stream() {
        Assert.assertTrue(homePage.eid.isDisplayed());
        BrowserUtils.waitFor(5);
    }

    @When("upload files and click to insert button")
    public void upload_files_and_click_to_insert_button() {
        homePage.uploadFilesandImages.sendKeys(pdfPath);
        homePage.insertBtn.click();
    }

    @Then("I should see inserted file in message box")
    public void i_should_see_inserted_file_in_message_box() {
        Driver.getDriver().switchTo().frame(homePage.iframe);
        BrowserUtils.waitFor(5);
        Assert.assertTrue(homePage.insertedFile.isDisplayed());
    }

    @Then("I should allow a recipient to edit documents.")
    public void i_should_allow_a_recipient_to_edit_documents() {
        Assert.assertTrue(homePage.checkbox.isEnabled());
    }

    @Then("I should be able to remove files and images at any time before sending")
    public void i_should_be_able_to_remove_files_and_images_at_any_time_before_sending() {
       Assert.assertTrue(homePage.deleteBtn.isEnabled());
    }

    @When("upload files")
    public void upload_files() {
        homePage.uploadFilesandImages.sendKeys(pdfPath);
        BrowserUtils.waitFor(2);
    }
    @Then("I should be able to rename the file before sending it.")
    public void i_should_be_able_to_rename_the_file_before_sending_it() {
        Assert.assertTrue(homePage.nameEditIcon.isEnabled());
    }


}
