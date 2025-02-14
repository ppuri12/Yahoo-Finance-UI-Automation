import org.example.Pages.YahooFinancePage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class YahooFinancePageTest extends BaseTest {

    @Test(dataProvider = "validStockData")
    public void verifyStockPrice(String stocks) throws InterruptedException {
        YahooFinancePage yahooFinancePage = new YahooFinancePage(getWebDriver());
        yahooFinancePage.openURL();
        yahooFinancePage.searchStock(stocks);
        yahooFinancePage.verifyStockName(stocks);
        yahooFinancePage.verifyStockPrice(stocks);
        yahooFinancePage.GetadditionalInfo("Previous Close");
        yahooFinancePage.GetadditionalInfo("Volume");
    }

    @Test(dataProvider = "invalidStockData")
    public void verifyInvalidStockPrice(String stocks) throws InterruptedException {
        YahooFinancePage yahooFinancePage = new YahooFinancePage(getWebDriver());
        yahooFinancePage.openURL();
        yahooFinancePage.searchStock(stocks);
        yahooFinancePage.verifyStockName(stocks);
    }

    @DataProvider(name = "validStockData")
    public Object[][] getValidStockNames() {
        return new Object[][]{
                {"TSLA"},
                {" TSLA"},
                {" TSLA "},

        };
    }

    @DataProvider(name = "invalidStockData")
    public Object[][] getInvalidStockNames() {
        return new Object[][]{
                {"TSL#"},
                {"@TSL"},
                {"TSL"},
                {"T SLA"},
        };
    }
}


