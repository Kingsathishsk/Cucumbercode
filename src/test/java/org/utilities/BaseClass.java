 package org.utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
public static WebDriver driver;
public static Actions a;
public static Robot r;
public static Select s;
public static WebDriverWait w;
public static FluentWait f;
public static Alert al;
public static JavascriptExecutor js;

//1---> Launch the url in Chrome Browser
public static void launchChrome() {
WebDriverManager.chromedriver().setup();
driver = new ChromeDriver();
}

//2---> Launch the url in Edge Browser
public static void launchFirefox() {
WebDriverManager.edgedriver().setup();
driver = new EdgeDriver();
}

//3---> Maximize the window
public static void winMax() {
driver.manage().window().maximize();
}

//4---> Load the Url
public static void loadUrl(String url) {
driver.get(url);
}

//5---> Print the Title
public static void printTitle() {
	String title = driver.getTitle();
	System.out.println(title);
}

//6---> Fill the value
public static void fill(WebElement ele, String value) {
ele.sendKeys(value);
}

//7---> Click the button
public static void btnClick(WebElement ele) {
ele.click();
}

//8---> Print the Current Url
public static void printCurrentUrl() {
String currentUrl = driver.getCurrentUrl();
System.out.println(currentUrl);
}

//9--->close the current tab
public static void tabclose() {
driver.close();
}

//10---> Quit the entire browser
public static void browserquit() {
driver.quit();
}

//11---> Double click
public static void dclick(WebElement ele) { 
a = new Actions(driver);
a.doubleClick(ele).perform();
}

//12---> Right click
public static void rclick(WebElement ele) {
a = new Actions(driver);
a.contextClick(ele).perform();
}

//13---> MoveToElement
public static void mousehover(WebElement ele) {
a = new Actions(driver);
a.moveToElement(ele).perform();;
}

//14---> Drag and Drop
public static void pull(WebElement src,WebElement des) {
a = new Actions(driver);
a.dragAndDrop(src, des);
}

//15---> KeyUp                                                             
public static void acopy() {
a = new Actions(driver);
a.keyDown(Keys.CONTROL).perform();
a.sendKeys("c").perform();
a.keyUp(Keys.CONTROL).perform();
}

//16---> KeyDown                                                
public static void apaste() {
a = new Actions(driver);
a.keyDown(Keys.CONTROL).perform();
a.sendKeys("v").perform();
a.keyUp(Keys.CONTROL).perform();
}

//17---> Enter button
public static void enter() throws AWTException {
r = new Robot();
r.keyPress(KeyEvent.VK_ENTER);
r.keyRelease(KeyEvent.VK_ENTER);
}

//18---> Control button
public static void ctrl() throws AWTException {
r = new Robot();
r.keyPress(KeyEvent.VK_CONTROL);
r.keyRelease(KeyEvent.VK_CONTROL);	
}

//19---> Shift button
public static void sft() throws AWTException {
r = new Robot();
r.keyPress(KeyEvent.VK_SHIFT);
r.keyRelease(KeyEvent.VK_SHIFT);	
}

//20---> Escape button
public static void esc() throws AWTException {
r = new Robot();
r.keyPress(KeyEvent.VK_ESCAPE);
r.keyRelease(KeyEvent.VK_ESCAPE);	
}

//21---> Alt button
public static void alt() throws AWTException {
r = new Robot();
r.keyPress(KeyEvent.VK_ALT);
r.keyRelease(KeyEvent.VK_ALT);
}

//22---> Get text Method
public static void printText(WebElement ele) {
String text = ele.getText();
System.out.println(text);
}

//23---> Get Attribute Method
public static void printAttribute(WebElement ele , String value) {
String attribute = ele.getAttribute(value);
System.out.println(attribute);
}

//24---> Accept alert
public static void ok() {
al= driver.switchTo().alert();
al.accept();
}

//25---> Dismiss alert
public static void cancel() {
al = driver.switchTo().alert();
al.dismiss();
}

//26---> SendKeys in Alert
public static void userInput(String value) {
al = driver.switchTo().alert();
al.sendKeys(value);
}

//27---> GetText in Alert
public static void alertText() {
al = driver.switchTo().alert();
String text = al.getText();
System.out.println(text);
}

//28---> TakeScreenShot
public static void screenShot(String file) throws IOException {
TakesScreenshot tk = (TakesScreenshot) driver;
File src = tk.getScreenshotAs(OutputType.FILE);
File des = new File("C:\\Users\\Lenovo\\eclipse-workspace\\MavenProject\\ScrrenShot\\" +file+".jpg");
FileUtils.copyFile(src, des);
}

//29---> JavaScriptExecutor
public static void jsExecute(WebElement ele ,String value ) {
js.executeScript("arguments[0].setAttribute('value' ,'"+value+"')", ele);
}

//30--->Dropdown Select by value
public static void valueSelect(WebElement ele , String value) {
s = new Select (ele);
s.selectByValue(value);
}

//31--->Dropdown deSelect by value
public static void valueDeSelect(WebElement ele , String value) {
s = new Select (ele);
s.deselectByValue(value);
}

//32--->Dropdown Select by visibletext
public static void visibleTextSelect(WebElement ele , String value) {
s = new Select (ele);
s.selectByVisibleText(value);
}

//33--->Dropdown deSelect by visibletext
public static void visibleTextDeSelect(WebElement ele , String value) {
s = new Select (ele);
s.deselectByVisibleText(value);
}

//34--->Dropdown Select by index
public static void indexSelect(WebElement ele , int a) {
s = new Select (ele);
s.selectByIndex(a);
}
																													
//35--->Dropdown deSelect by index
public static void indexDeSelect(WebElement ele , int a) {
s = new Select (ele);
s.deselectByIndex(a);
}

//36--->Dropdown deSelectall 
public static void allDeSelect(WebElement ele) {
s = new Select (ele);
s.deselectAll();
}

//37--->Dropdown isMultiple
public static void multiple(WebElement ele) {
s = new Select (ele);
s.isMultiple();
}

//38--->Dropdown getoptions
public static void options(WebElement ele) {
s = new Select (ele);
List<WebElement> option = s.getOptions();
for (WebElement x : option){
String text = x.getText();
System.out.println(text);
}
}

//39--->Dropdown getAllSelectedoptions
public static void allSelectOptions(WebElement ele) {
s = new Select (ele);
List<WebElement> allSelect = s.getAllSelectedOptions();
for (WebElement x : allSelect) {
String text = x.getText();
System.out.println(text);
}
System.out.println(allSelect);
}

//40--->Dropdown getFirstSelectedoptions
public static void firstSelectOption(WebElement ele) {
s = new Select (ele);
WebElement x = s.getFirstSelectedOption();
String text = x.getText();
System.out.println(text);
}

//41--->Frame switch to parent
public static void parenFram() {
driver.switchTo().parentFrame();
}

//42--->Frame switch to default
public static void defContent() {
driver.switchTo().defaultContent();
}

//43. WindowHandle												check
public static void windowHandle() {
String parentId = driver.getWindowHandle();
System.out.println(parentId);
}

//44. WindowHandles												check
public static void windowHandles(WebElement ele) {
Set<String> allWindowId = driver.getWindowHandles();
System.out.println(allWindowId);
}

//45---> Tab button
public static void tab() throws AWTException {
r = new Robot();
r.keyPress(KeyEvent.VK_TAB);
r.keyRelease(KeyEvent.VK_TAB);
}

//46---> Copy button
public static void copy() throws AWTException {
r = new Robot();
r.keyPress(KeyEvent.VK_CONTROL);
r.keyPress(KeyEvent.VK_C);
r.keyRelease(KeyEvent.VK_CONTROL);
r.keyRelease(KeyEvent.VK_C);
}

//47---> Cut button
public static void cut() throws AWTException {
r = new Robot();
r.keyPress(KeyEvent.VK_CONTROL);
r.keyPress(KeyEvent.VK_X);
r.keyRelease(KeyEvent.VK_CONTROL);
r.keyRelease(KeyEvent.VK_X);
}

//48---> Paste button
public static void paste() throws AWTException {
r = new Robot();
r.keyPress(KeyEvent.VK_CONTROL);
r.keyPress(KeyEvent.VK_V);
r.keyRelease(KeyEvent.VK_CONTROL);
r.keyRelease(KeyEvent.VK_V);
}

//49---> SelectAll button
public static void Select() throws AWTException {
r = new Robot();
r.keyPress(KeyEvent.VK_CONTROL);
r.keyPress(KeyEvent.VK_A);
r.keyRelease(KeyEvent.VK_CONTROL);
r.keyRelease(KeyEvent.VK_A);
}

//50---> Undo button
public static void undo() throws AWTException {
r = new Robot();
r.keyPress(KeyEvent.VK_CONTROL);
r.keyPress(KeyEvent.VK_Z);
r.keyRelease(KeyEvent.VK_CONTROL);
r.keyRelease(KeyEvent.VK_Z);
}

//51---> JavaScriptExecutor
public static void jsExecuteBottomScroll(WebElement ele) {
js = (JavascriptExecutor) driver;
js.executeScript("arguments[0].scrollIntoView(false)", ele);
}

//52---> JavaScriptExecutor
public static void jsExecuteTopScroll(WebElement ele) {
js = (JavascriptExecutor) driver;
js.executeScript("arguments[0].scrollIntoView(true)", ele);
}

//53--->JavaScriptExecutor
public static void jHighLightElement(String value , WebElement ele) {
js = (JavascriptExecutor) driver;
js.executeAsyncScript("arguments[0].setAttribute('style','" +value+"')" , ele);
}

//54---> JavaScriptExecutor
public static void jsExecutesend(WebElement ele) {
js = (JavascriptExecutor) driver;
js.executeScript("arguments[0].click()", ele);
}

//55---> Frame using Id
public static void frameId(String id) {
driver.switchTo().frame(id);
}

//56---> Frame using name
public static void frameName(String name) {
driver.switchTo().frame(name);
}

//57---> Frame using WebElement
public static void frameWebRef(WebElement ele) {
driver.switchTo().frame(ele);
}

//58---> Frame using Index
public static void frameIndex(int i) {
driver.switchTo().frame(i);
}

//59.Switch window using Url
public static void windowUrl(String url) {
driver.switchTo().window(url);
}

//60.Switch window using title
public static void windowTitle(String title) {
driver.switchTo().window(title);
}


//61---> Static Wait
public static void waitSleep(int value) throws InterruptedException {
Thread.sleep(value);
}

//62---> Implicit wait
public static void impliwait(int w) {
driver.manage().timeouts().implicitlyWait(w, TimeUnit.SECONDS);
}

//63---> Explicit wait - WebDriver wait - Alert is Present 
public static void alertPresentWebWait(int seconds , WebElement ele) {
w = new WebDriverWait (driver ,seconds);
w.until(ExpectedConditions.alertIsPresent());
}

//64---> Explicit wait - WebDriver wait - Element Clickable
public static void elementClickableWebWait(int seconds , WebElement ele) {
w = new WebDriverWait (driver ,seconds);
w.until(ExpectedConditions.elementToBeClickable(ele));
}

//65---> Explicit wait - We bDriver wait - FramePresent
public static void framePresentWebWait(int seconds , WebElement ele) {
w = new WebDriverWait (driver ,seconds);
w.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(ele));
}

//66---> Explicit wait - WebDriver wait - Element Selected
public static void elementSelectedtWebWait(int seconds , WebElement ele) {
w = new WebDriverWait (driver ,seconds);
w.until(ExpectedConditions.elementToBeSelected(ele));
}

//67---> Explicit wait - WebDriver wait - Invisibility of element Located
public static void invisibilityElementtWebWait(int seconds , WebElement ele) {
w = new WebDriverWait (driver ,seconds);
w.until(ExpectedConditions.invisibilityOf(ele));
}

//68---> Explicit wait - Fluent wait - Clickable Element
public static void clickableElementFluentWait(WebElement ele) {
f = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(5)).ignoring(Throwable.class);
f.until(ExpectedConditions.elementToBeClickable(ele));
}

//69---> Explicit wait - Fluent wait - Frame Available and Switch to it
public static void frameAvailSwitchFluentWait(WebElement path) {
f = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(5)).ignoring(Throwable.class);
f.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(path));
}

//70---> Explicit wait - Fluent wait - Visibility of Element
public static void visibilityElementFluentWait(String path) {
f = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(5)).ignoring(Throwable.class);
f.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(path)));
}

//71---> Explicit wait - Fluent wait - Invisibility of Element
public static void inVisibilityElementFluentWait(String path) {
f = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(5)).ignoring(Throwable.class);
f.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(path)));
}

//72---> Explicit wait - Fluent wait - Presence of Element
public static void presenceOfElementFluentWait(String path) {
f = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(5)).ignoring(Throwable.class);
f.until(ExpectedConditions.presenceOfElementLocated(By.xpath(path)));
}

//73---> Locators   - id (Sendkeys)
public static void idWithFill(String name , String value) {
driver.findElement(By.id(name)).sendKeys(value);
}

//74---> Locators   - id (click)
public static void idWithClick(String name) {
driver.findElement(By.id(name)).click();
}

//75---> Locators   - name (Sendkeys)
public static void nameWithFill(String value) {
driver.findElement(By.name(value)).click();
}

//76---> To get the rows and cell values
public static String getData (int rownumber , int cellnumber) throws IOException{
//1.Mention the file location
File f = new File("C:\\Users\\Lenovo\\eclipse-workspace\\MyProject\\target\\TestData\\Myproject.xlsx");
//2.Read the Value from Excel
FileInputStream fin = new FileInputStream (f);
//3.Type of workbook
Workbook w = new XSSFWorkbook(fin);
//4.Select the Sheet
Sheet s = w.getSheet("Project");
//5.Get the desired row
Row row = s.getRow(rownumber);
//6.Get the desired cell
Cell cell = row.getCell(cellnumber);
int cellType = cell.getCellType();

String value = "";
if(cellType==1) {
value = cell.getStringCellValue();
}
else if (cellType==0) {
if (DateUtil.isCellDateFormatted(cell)) {
Date d = cell.getDateCellValue();
SimpleDateFormat sim = new SimpleDateFormat("dd.MMMM,yyyy");
sim.format(d);
}	
else {
double d = cell.getNumericCellValue();
long l = (long)d;
value = String.valueOf(l);
}
}
return value;
}


//77 ---> Down button
public static void dwn() throws AWTException {
r = new Robot();
r.keyPress(KeyEvent.VK_DOWN);
r.keyRelease(KeyEvent.VK_DOWN);
}
}




