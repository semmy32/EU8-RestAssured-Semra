package com.BleuCRM.pages;

import com.BleuCRM.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Filter_and_SearchPage {

    public Filter_and_SearchPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//*[@class='main-ui-filter-sidebar-item']")
    public List<WebElement> defaultFilters;

    @FindBy(xpath = "//*[@class='main-ui-filter-field-add-item']")
    public WebElement addFieldBtn;

    @FindBy(xpath = "//*[@class='main-ui-filter-field-restore-items']")
    public WebElement restoreDefaultFieldBtn;

    @FindBy(xpath ="main-ui-control-field")
    public WebElement dateDropdown;

    @FindBy(xpath = "//*[@class='main-ui-control main-ui-multi-select']")
    public WebElement typeCheckBtn;

    @FindBy(xpath = "//*[@class='main-ui-filter-add-item']")
    public WebElement saveFilterBtn;

    @FindBy(className = "main-ui-select-inner-label")
    public List<WebElement> addFilterCheckboxes;

    @FindBy(xpath = "//span[@class='ui-btn ui-btn-light-border main-ui-filter-field-button main-ui-filter-reset']")
    public WebElement resetBtn;

}
