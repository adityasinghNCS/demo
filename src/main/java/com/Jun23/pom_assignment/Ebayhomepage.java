package com.Jun23.pom_assignment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Ebayhomepage {
	
	WebDriver driver;
	
	public Ebayhomepage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="//input[@id='gh-ac']")
	WebElement search_bar;
	
	public void enterSearch(String text) {
		search_bar.sendKeys(text);
	}
	
	@FindBy(xpath ="//select[@class=\"gh-sb \"]")
	WebElement dropdown;
	
	public void clickDropdown() {
		dropdown.click();
	}
	
	@FindBy(xpath ="//select[@class=\"gh-sb \"]/option[@value=15032]")
	WebElement dropdownItem;
	
	public void clickdropdownitem() {
		dropdownItem.click();
	}
	
	@FindBy(xpath = "//input[@type='submit']")
	WebElement searchbutton;
	
	public void clicksearchbutton() {
		searchbutton.click();
	}
}
