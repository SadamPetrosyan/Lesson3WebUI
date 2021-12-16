import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        WebDriver webDriver = WebDriverManager.chromedriver().create();
        webDriver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject");
        Actions actions = new Actions(webDriver);
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        //TODO: выбор готового владельца счёта

        webDriver.findElement(By.xpath("//button[contains(text(),'Customer Login')]")).click(); //todo переход на страницу выбора пользователя
        webDriver.findElement(By.name("userSelect")).click();
        webDriver.findElement(By.xpath("//option[contains(text(),'Albus Dumbledore')]")).click();//todo выбор пользователя
        webDriver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();//todo авторизация под именем выбранного Клиента
        webDriver.findElement(By.xpath("//button[contains(text(),'Home')]")).click();// todo переход на Главную страницу сайта

        //TODO: выбор готового владельца и взятие депозита в "Долларах"

        webDriver.findElement(By.xpath("//button[contains(text(),'Customer Login')]")).click();//todo переход на страницу выбора пользователя
        webDriver.findElement(By.name("userSelect")).click();
        webDriver.findElement(By.xpath("//option[contains(text(),'Ron Weasly')]")).click();//todo выбор пользователя
        webDriver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();//todo авторизация под именем выбранного Клиента
        webDriver.findElement(By.xpath("//button[contains(text(),'Deposit')]")).click();//todo переход на страницу одобрения депозита
        webDriver.findElement(By.xpath("//input[@placeholder='amount']")).click();
        webDriver.findElement(By.xpath("//input[@placeholder='amount']")).sendKeys("1500");//todo сумма депозита
        webDriver.findElement(By.xpath("//button[@type='submit']")).click();//todo подтверждение суммы депозита
        webDriver.findElement(By.xpath("//button[contains(text(),'Home')]")).click();// todo переход на Главную страницу сайта


        //TODO: удаление владельца счета
        webDriver.findElement(By.xpath("//button[contains(text(),'Bank Manager Login')]")).click();//todo переход на страницу с вкладками "Добавить Клиента", "Открыть учетную запись", "Клиенты"
        webDriver.findElement(By.xpath("//button[contains(text(),'Customers')]")).click();//todo переход на страницу Клиентов
        webDriver.findElement(By.xpath("//input[@placeholder='Search Customer']")).click();
        webDriver.findElement(By.xpath("//input[@placeholder='Search Customer']")).sendKeys("Neville");//todo поиск Клиента
        webDriver.findElement(By.xpath("//button[contains(text(),'Delete')]")).click();//todo удаление Клиента
        webDriver.findElement(By.xpath("//button[contains(text(),'Home')]")).click();// todo переход на Главную страницу сайта




        // TODO: создание нового владельца счета в банке
        webDriver.findElement(By.xpath("//button[contains(text(),'Bank Manager Login')]")).click();//todo переход на страницу с вкладками "Добавить Клиента", "Открыть учетную запись", "Клиенты"
        webDriver.findElement(By.xpath("//button[contains(text(),'Add Customer')]")).click();//todo переход на страницу Добавления Клиента
        webDriver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("Tom");//todo заполнение поля Имени Клиента
        webDriver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("Marvolo");//todo заполнение поля Фамилии Клиента
        webDriver.findElement(By.xpath("//input[@placeholder='Post Code']")).sendKeys("A1ML0RD");//todo заполнение поля Почтового индекса Клиента
        webDriver.findElement(By.xpath("//button[@type='submit']")).click();//todo кнопка сохранения пользователя в системе

        Thread.sleep(5000);
        System.out.println(webDriver.getCurrentUrl());

        webDriver.quit();
    }

}

