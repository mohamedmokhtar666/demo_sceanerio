package utils;

import org.openqa.selenium.WebDriver;

public class WindowManager {
    private WebDriver driver;

    private WebDriver.Navigation navigate;


    public WindowManager(WebDriver driver)
    {
        this.driver=driver;
        navigate=driver.navigate();
    }
    public void goBack()
    {
        navigate.back();
    }
    public void goForward()
    {
        navigate.forward();
    }
    public void refreshPage()
    {
        navigate.refresh();
    }
    public void goToUrl(String url)
    {
        navigate.to(url);
    }
    public void switchToTabs(String tabTitle)
    {
        var windows=driver.getWindowHandles();
        System.out.println("Number Of Tabs" + windows.size());
        System.out.println("Window handles:");
        windows.forEach(System.out::println);
        for (String window:windows)
        {
            System.out.println("Switching  To Window " +  window);
            driver.switchTo().window(window);
            System.out.println("Current Window Title "+driver.getTitle());
            if(tabTitle.equals(driver.getTitle())){
                break;
            }
        }
    }
    public void switchToNewTab()
    {
        var windows=driver.getWindowHandles();
        windows.forEach(driver.switchTo()::window);
    }
}
