package com.softserve.edu.greencity.ui.pages.econews;

import com.google.common.base.Function;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import com.softserve.edu.greencity.ui.pages.common.TopPart;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static com.softserve.edu.greencity.ui.pages.econews.EcoNewsPage.ArticleFields.*;
@Getter
public class EcoNewsPage extends TopPart {

    public EcoNewsPage(WebDriver driver) {
        super(driver);

    }

    private By header = By.cssSelector("H1");
    private By tagsFilterBlock = By.cssSelector("app-filter-news");
    private By tagsFilterLabel = By.cssSelector("app-filter-news>div.wrapper>span");
    private By tags = By.cssSelector("app-filter-news>div.wrapper>ul>a");
    private By activeTags = By.cssSelector("app-filter-news>div.wrapper>ul>a>li.clicked-filter-button");
    private By uncheckTagButtons = By.cssSelector("app-filter-news>div.wrapper>ul>a>li>div.close");
    private By articleFoundCounter = By.cssSelector("app-remaining-count>p");
    private By displayedArticles = By.cssSelector("ul.list.gallery-view-active > li.gallery-view-li-active");
    private By articleImage = By.cssSelector(" div.list-image>img");
    private By articleEcoButton = By.cssSelector("div.filter-tag>div.ul-eco-buttons");
    private By articleTitle = By.cssSelector("div.added-data>div.title-list>p");
    private By articleText = By.cssSelector(" div.added-data>div.list-text>p");
    private By articleCreationDate = By.cssSelector("div.user-data-added-news>p:first-child");
    private By articleAuthorName = By.cssSelector("div.user-data-added-news>p:last-child");
    private By galleryViewButton = By.cssSelector("div.gallery-view");
    private By listViewButton = By.cssSelector("div.list-view");
    private int articleExistCount;
    private int articleDisplayedCount;

    // Functional
    @Step("Verification of page condition")
    public void pageExistQuickCheck() {
        $(header);
        $(tagsFilterBlock);
        $(tagsFilterLabel);
        $(tags);
        $(articleFoundCounter);
        $(displayedArticles);
        $(listViewButton);
        $(galleryViewButton);
    }

    @Step("Get list of elements by css")
    public List<WebElement> getElements(By cssSelector) {
        return driver.findElements(cssSelector);
    }

    @Step("get content from chosen article in Map format")
    public Map<ArticleFields, WebElement> getContentFromArticle(WebElement element) {
        Map<ArticleFields, WebElement> content = new HashMap<>();
        content.put(IMAGE, element.findElement(articleImage));
        content.put(ECO_BUTTON, element.findElement(articleEcoButton));
        content.put(TITLE, element.findElement(articleTitle));
        content.put(TEXT, element.findElement(articleText));
        content.put(CREATION_DATE, element.findElement(articleCreationDate));
        content.put(AUTHOR_NAME, element.findElement(articleAuthorName));
        return content;
    }

    @Step("Set actual information from page to articleExistCount")
    public EcoNewsPage updateArticlesExistCount() {
        waiting(getElements(displayedArticles));
        articleExistCount = Integer.parseInt($(articleFoundCounter).getText().split(" ")[0]);
        return this;
    }

    @Step("Scroll under end of page")
    public EcoNewsPage scrollDown() {
        waiting($(By.cssSelector("body")));
        while (articleExistCount != articleDisplayedCount) {
            $(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
            articleDisplayedCount = getElements(displayedArticles).size();
        }
        waiting(getElements(displayedArticles));
        return this;
    }

    @Step("switch article sort to gallery format and reassign css")
    public EcoNewsPage swishToGalleryView() {
        $(galleryViewButton).click();
        displayedArticles = By.cssSelector("ul.list.gallery-view-active > li.gallery-view-li-active");
        articleImage = By.cssSelector(" div.list-image>img");
        articleEcoButton = By.cssSelector("div.filter-tag>div.ul-eco-buttons");
        articleTitle = By.cssSelector("div.added-data>div.title-list>p");
        articleText = By.cssSelector(" div.added-data>div.list-text>p");
        articleCreationDate = By.cssSelector("div.user-data-added-news>p:first-child");
        articleAuthorName = By.cssSelector("div.user-data-added-news>p:last-child");
        return this;
    }

    @Step("switch article sort to list format and reassign css")
    public EcoNewsPage swishToListView() {
        $(listViewButton).click();
        displayedArticles = By.cssSelector("ul.list > li.list-view-li-active>app-news-list-list-view>div#list-gallery-content");
        articleImage = By.cssSelector("div.list-image>.list-image-content");
        articleEcoButton = By.cssSelector("div.news-content>div.added-data>div.filter-tag>div.ul-eco-buttons");
        articleTitle = By.cssSelector("div.news-content>div.added-data>div.title-list>p");
        articleText = By.cssSelector("div.news-content>div.added-data>div.list-text>p");
        articleCreationDate = By.cssSelector("div.news-content>div.user-data-added-news>p:first-child");
        articleAuthorName = By.cssSelector("div.news-content>div.user-data-added-news>p:last-child");
        return this;
    }

    //Verifications
    //!!!!!!!!!!!!!!!!!!!!!!!!!! ZBS poisk
    public WebElement $(By locator){
        return assertThat(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public WebElement $x(String xpath){
        return assertThat(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }
    @Step("short explicit wait visibility Of element")
    public <V> V assertThat(Function<? super WebDriver, V> condition){
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        V element = (new WebDriverWait(driver,5)).until(condition);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return element;
    }
    //!!!!!!!!!!!!!!!!!!!!!!!!!!
    @Step("short explicit wait visibility Of element")
    public EcoNewsPage waiting(WebElement element) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(element));
        return this;
    }

    @Step("short explicit wait visibility Of elements list")
    public EcoNewsPage waiting(List<WebElement> elements) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfAllElements(elements));
        return this;
    }

    @Step("Verification that all content in the chosen article displayed")
    public boolean isArticleContentDisplayed(WebElement element) {
        return (
                element.findElement(articleImage).isDisplayed() &&
                        element.findElement(articleEcoButton).isDisplayed() &&
                        element.findElement(articleTitle).isDisplayed() &&
                        element.findElement(articleText).isDisplayed() &&
                        element.findElement(articleCreationDate).isDisplayed() &&
                        element.findElement(articleAuthorName).isDisplayed());
    }

    @Step("Verification that all text content in the chosen article displayed")
    public boolean isArticleTextContentDisplayed(WebElement element) {
        return (
                element.findElement(articleTitle).isDisplayed() &&
                        element.findElement(articleText).isDisplayed() &&
                        element.findElement(articleCreationDate).isDisplayed() &&
                        element.findElement(articleAuthorName).isDisplayed());
    }

    @Step("Verification that all content in the list of articles displayed")
    public void isArticleContentDisplayed(List<WebElement> elements) {
        elements.forEach(this::isArticleContentDisplayed);
    }

    @Step("Verification that all text content in the list of articles displayed")
    public void isArticleTextContentDisplayed(List<WebElement> elements) {
        elements.forEach(this::isArticleTextContentDisplayed);
    }
    // Page Object

    public enum ArticleFields {
        IMAGE,
        ECO_BUTTON,
        TITLE,
        TEXT,
        CREATION_DATE,
        AUTHOR_NAME
    }
}
