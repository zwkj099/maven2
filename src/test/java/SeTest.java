import org.testng.annotations.Test;

/**
 * @author huwen
 * @date 2021/4/20 9:28
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class SeTest {

    @BeforeClass
    public void beforeClass() {
        System.out.println("用例前执行打印本句！");
        System.out.println("每条Test用例是互不相干的");
        System.out.println("用例开始执行…………");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("用例结束后运行");
    }
    @Test
    public void actions() {
        //设置驱动所在位置
        System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
        //引用火狐浏览器驱动
        WebDriver driver = new ChromeDriver();
        //打开禅道界面
        driver.get("http://10.19.102.130/ecology/login");
        //以下元素使用css格式 -cssSelector
        //输入账号
        driver.findElement(By.xpath("//*[@id=\"pane-accountLoginType\"]/form/div[1]/div/div[1]/input\n")).sendKeys("ec_991199825");
        //输入密码
        driver.findElement(By.xpath("//*[@id=\"pane-accountLoginType\"]/form/div[2]/div/div/input")).sendKeys("2wsx@WSX");
        //点击登录
        driver.findElement(By.xpath("//*[@id=\"pane-accountLoginType\"]/form/div[3]/label/span/span")).click();
        driver.findElement(By.xpath("//*[@id=\"pane-accountLoginType\"]/form/button")).click();

        //抓取成功登录后的用户名信息
        String text = driver.findElement(By.cssSelector("#siteNav > a:nth-child(4)")).getText();
        //断言-校验是否登录成功
        Assert.assertEquals(text,"懵");

        try {
            //页面等待
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //关闭浏览器进程及驱动
        driver.close();

    }

}
