package com.BleuCRM.pages;

import com.BleuCRM.utilities.BrowserUtils;
import com.BleuCRM.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UploadFile_to_MessagePage {
    public UploadFile_to_MessagePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(id="feed-add-post-form-tab-message")
    public WebElement messageBtn;

    @FindBy(id = "bx-b-uploadfile-blogPostForm")
    public WebElement uploadIcon;

    @FindBy(xpath = "//input[@name='bxu_files[]']")
    public WebElement uploadFilesandImages;

    @FindBy(className = "insert-btn-text")
    public WebElement insertBtn;

    @FindBy(xpath = "//img[@alt='love (1).gif']")
    public WebElement pngImage;

    @FindBy(xpath = "//table[@class='files-list']//td//*[text()='Zugpsitze_mountain (3).jpg']")
    public WebElement photo2;

    @FindBy(xpath = "//*[text()='inventory.xlsx']")
    public WebElement xls;

    @FindBy(xpath = "//*[text()='index.html']")
    public WebElement html;

    @FindBy(xpath = "//img[@alt='eid (3).png']")
    public WebElement eid;

    @FindBy(xpath= "//img[@class='files-preview']")
    public WebElement picture;

    @FindBy(id="blog-submit-button-save")
    public WebElement sendButton;

    @FindBy(className = "bx-editor-iframe")
    public WebElement iframe;

    @FindBy(xpath = "//span[.='BleuCRM_App_info.pdf']")
    public WebElement insertedFile;

    @FindBy(xpath = "//input[@name='BLOG_POST_DISK_ATTACHED_OBJECT_ALLOW_EDIT']")
    public WebElement checkbox;

    @FindBy(xpath = "//td[@class='files-del-btn']")
    public WebElement deleteBtn;

    @FindBy(xpath = "//span[@class='files-name-edit-btn']")
    public WebElement nameEditIcon;



    public void openUploadFunction(){
        messageBtn.click();
        uploadIcon.click();
    }

}
