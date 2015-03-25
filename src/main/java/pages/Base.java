package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import support.BrowserDriver;

import java.util.List;

/**
 * Created by sam on 10/07/2014.
 *  Anything which is applicable to a page can be put into this class
 */
public class Base extends BrowserDriver{

    public void selectOptionValue(By locator, String text) {
        Select dropdown = new Select(driver.findElement(locator));
        dropdown.selectByVisibleText(text);
    }

    public String getFirstSelectedOption(By locator){
        WebElement combo = driver.findElement(locator);
        Select comboBox = new Select(combo);
        return comboBox.getFirstSelectedOption().getText().trim();
    }

    public void selectOptOptionValue(By locator, String text) {
        Select dropdown = new Select(driver.findElement(locator));
        List<WebElement> groupOptions = dropdown.getOptions();
        for (WebElement groupOption : groupOptions){
            if (groupOption.getText().equals(text)){
                groupOption.click();
            }
        }

        dropdown.selectByVisibleText(text);
    }

    public void executeJavascript(String javascript) throws Exception {
        if (driver instanceof JavascriptExecutor) {
            ((JavascriptExecutor)driver).executeScript(javascript);
        }
        else
        {
            throw new Exception("JavascriptExecutor was not enabled");
        }
    }

    public boolean checkPriceSortDescending(List<Float> arrayList){
        System.out.println("INFO: Check Descending Sort");
        boolean sorted = true;
        for(int i = 1; i < arrayList.size(); i++) {
            if(arrayList.get(i-1) < arrayList.get(i)){
                sorted = false;
                break;
            }
        }

        return sorted;
    }

    public boolean checkPriceSortAscending(List<Float> arrayList){
        System.out.println("INFO: Check Ascending Sort");
        boolean sorted = true;
        for(int i = 1; i < arrayList.size(); i++) {
            if(arrayList.get(i-1) > arrayList.get(i)){
                sorted = false;
                break;
            }
        }

        return sorted;
    }

    void clickLinkItemByName(By elements, String linkName) {
        List<WebElement> links = driver.findElements(elements);
        for (WebElement link : links){
            if (link.getText().trim().equals(linkName)){
                link.click();
                break;
            }
        }
    }


}
