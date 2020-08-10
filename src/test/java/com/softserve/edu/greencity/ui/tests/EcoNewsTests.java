package com.softserve.edu.greencity.ui.tests;

import com.softserve.edu.greencity.ui.pages.econews.EcoNewsPage;
import io.qameta.allure.Description;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class EcoNewsTests extends GreencityTestRunner {

    @Test
    @Description("Verify that all content displayed in article ")
    public void contentDisplayedTest(){
        EcoNewsPage econewsPage = loadApplication().navigateMenuEconews();
        econewsPage.updateArticlesExistCount().scrollDown();
        econewsPage.waiting(econewsPage.getElements(econewsPage.getDisplayedArticles()));
        List<WebElement> elements = econewsPage.getElements(econewsPage.getDisplayedArticles());
        econewsPage.isArticleContentDisplayed(elements.get(1));
    }
    @Test
    @Description("Verify that at least text content displayed in article")
    public void textContentDisplayedTest(){
        EcoNewsPage econewsPage = loadApplication().navigateMenuEconews();
        econewsPage.updateArticlesExistCount().scrollDown();
        econewsPage.waiting(econewsPage.getElements(econewsPage.getDisplayedArticles()));
        List<WebElement> elements = econewsPage.getElements(econewsPage.getDisplayedArticles());
        econewsPage.isArticleTextContentDisplayed(elements.get(3));
    }

    @Test
    @Description("Verify that all content in each article")
    public void allContentDisplayedTest(){
        EcoNewsPage econewsPage = loadApplication().navigateMenuEconews();
        econewsPage.updateArticlesExistCount().scrollDown();
        econewsPage.waiting(econewsPage.getElements(econewsPage.getDisplayedArticles()));
        List<WebElement> elements = econewsPage.getElements(econewsPage.getDisplayedArticles());
        econewsPage.isArticleContentDisplayed(elements);
    }

    @Test
    @Description("Verify that at least text content displayed in each article")
    public void allTextContentDisplayedTest(){
        EcoNewsPage econewsPage = loadApplication().navigateMenuEconews();
        econewsPage.updateArticlesExistCount().scrollDown();
        econewsPage.waiting(econewsPage.getElements(econewsPage.getDisplayedArticles()));
        List<WebElement> elements = econewsPage.getElements(econewsPage.getDisplayedArticles());
        econewsPage.isArticleTextContentDisplayed(elements);
    }
}
