package com.softserve.edu.greencity.ui.tests;

import com.softserve.edu.greencity.ui.pages.econews.EcoNewsPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.softserve.edu.greencity.ui.pages.habits.MyHabitsPage;

public class SmokeTest extends GreencityTestRunner {

    // @Test
    public void checkApp() {
        System.out.println("***surefire.application.password = " + System.getProperty("surefire.application.password"));
        System.out.println("***System.getenv().MY_PASSWORD = " + System.getenv().get("MY_PASSWORD"));
        Assert.assertTrue(true);
    }

    @Test
    public void checkLinks() {
        // Check main menu
        MyHabitsPage myHabitsPage = loadApplication()
                .navigateMenuEconews()
                .navigateMenuTipsTricks()
                .navigateMenuPlaces()
                .navigateMenuAbout()
                .navigateMenuMyHabits();
        presentationSleep();
     // Check footer menu
        myHabitsPage
                .footerMenuEconews()
                .footerMenuTipsTricks()
                .footerMenuPlaces()
                .footerMenuAbout()
                .footerMenuMyHabits();
        presentationSleep();
    }

    /*@Test
    public void ecoNewsSmokeTest(){
        EcoNewsPage econewsPage = loadApplication().navigateMenuEconews();
        econewsPage.waiting(econewsPage.findElement(econewsPage.getHeader()))
        .waiting(econewsPage.findElement(econewsPage.getTagsFilterBlock()))
        .waiting(econewsPage.findElement(econewsPage.getTagsFilterLabel()))
        .waiting(econewsPage.findElements(econewsPage.getTags()))
        .waiting(econewsPage.findElement(econewsPage.getArticleFoundCounter()))
        .waiting(econewsPage.findElements(econewsPage.getDisplayedArticles()))
        .waiting(econewsPage.findElement(econewsPage.getListViewButton()))
        .updateArticlesExistCount().scrollDown();
        Assert.assertEquals(econewsPage.getArticleExistCount(),econewsPage.getArticleDisplayedCount());
    }*/
    @Test
    public void ecoNewsSmokeTestAlternative(){
        EcoNewsPage econewsPage = loadApplication().navigateMenuEconews();
        econewsPage.pageExistQuickCheck();

        }

    /*-
    @DataProvider
    public Object[][] languages() {
        return new Object[][] {
            //{ SearchItemRepository.getMacItem(), SearchRefineRepository.getPriceDescUsd() },
            { Languages.UKRAINIAN }
            };
    }
    
    //@Test(dataProvider = "languages")
    public void checkElements(Languages languages) {
        // Steps
        TipsTricksPage tipstrickspage = loadApplication()
                .switchLanguage(languages);
        presentationSleep();
        //
       // /*-
        System.out.println("is menu Home text: " 
                + homepage.getMainMenuDropdown().getMenuHomeText());
        //
        System.out.println("is menu Home: " 
                + homepage.getMainMenuDropdown().isDisplayedMenuHome());
        System.out.println("is menu EcoNews: " 
                + homepage.getMainMenuDropdown().isDisplayedMenuEcoNews());
        System.out.println("is menu NaviconButton: " 
                + homepage.getMainMenuDropdown().isDisplayedNaviconButton());
      //  * /
        //
        tipstrickspage = tipstrickspage
                .navigateMenuEconews()
                .navigateMenuTipsTricks()
                .navigateMenuMap()
                .navigateMenuMyCabinet()
                .navigateMenuAbout()
                .navigateMenuTipsTricks();
        //
    //      TopPart tp = tipstrickspage;
    //      tp = tp.navigateMenuEconews();
    //      presentationSleep(2);
    //      tp = tp.navigateMenuTipsTricks();
    //      presentationSleep(2);
    //      tp = tp.navigateMenuMyCabinet();
    //      presentationSleep(2);
    //      tp = tp.navigateMenuMap();
        //
        // Check
    //      Assert.assertEquals(tipstrickspage.getLanguageSwitcherText(),
    //              Languages.UKRAINIAN.toString());
        //
        // Return to Previous State
        presentationSleep();
    }
    
    @DataProvider
    public Object[][] users() {
        return new Object[][] {
            { UserRepository.get().temporary() }
            };
    }
    
    //@Test(dataProvider = "users")
    public void checkLogin(User user) {
        TipsTricksPage tipstrickspage = loadApplication()
                .signin()
                .successfullyLogin(user);
        System.out.println("name = " + tipstrickspage.getTopUserName());
        Assert.assertEquals(tipstrickspage.getTopUserName(),
                TopPart.PROFILE_NAME);
                //user.getFirstname());
        tipstrickspage.signout();
    }
    
    //    @Test(dataProvider = "users")
    public void checkCabinet(User user) {
        MyCabinetPage myCabinetPage = loadApplication()
                .navigateMenuMyCabinet(user);
        presentationSleep();
        //
        Assert.assertEquals(myCabinetPage.getTopUserName(), TopPart.PROFILE_NAME);
        // user.getFirstname());
        presentationSleep();
        //
        myCabinetPage = myCabinetPage
                .navigateMenuTipsTricks()
                .navigateMenuEconews()
                .navigateMenuMyCabinet();
        presentationSleep();
        //
        TipsTricksPage tipstrickspage = myCabinetPage
                .signout();
        presentationSleep();
        LoginPage loginPage = tipstrickspage
                .navigateMenuMyCabinetGuest();
        presentationSleep(4);
    }
       */
}
