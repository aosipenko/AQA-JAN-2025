package homeworks;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AlloUAPhonesPage;
import pages.Phone;

import java.sql.PreparedStatement;
import java.sql.SQLException;

//TODO: Homework * : Create table Phones : PhoneId, PhoneName, PhonePrice
// - using selenium go to allo.ua, search for a phone
// - get phone name
// - get phone price
// - store phone name and phone price to DB

public class SQLHomeworkPhonesTable extends BaseSQLTest {
    AlloUAPhonesPage alloUAPhonesPage = new AlloUAPhonesPage();

    @BeforeMethod
    public void before() {
        alloUAPhonesPage.openMainPage();
    }

    @Test
    public void createTable() {
        try {
            STATEMENT.execute("CREATE TABLE Phones (" +
                    "PhoneID int UNIQUE AUTO_INCREMENT NOT NULL," +
                    "PhoneName varchar(255) NOT NULL," +
                    "PhonePrice int NOT NULL)");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void addInfoAboutSamsungPhoneToTable() {
        Phone insertPhone = alloUAPhonesPage.getPhone("Samsung");
        try {
            PreparedStatement preparedStatement = CONNECTION.prepareStatement(
                    "INSERT INTO Phones (PhoneName, PhonePrice) VALUES " +
                            "(?, ?)");
            preparedStatement.setString(1, insertPhone.getName());
            preparedStatement.setInt(2, insertPhone.getPrice());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void addInfoAboutIphonePhonesToTable() {
        Phone insertPhone = alloUAPhonesPage.getPhone("iPhone");
        try {
            PreparedStatement preparedStatement = CONNECTION.prepareStatement(
                    "INSERT INTO Phones (PhoneName, PhonePrice) VALUES " +
                            "(?, ?)");
            preparedStatement.setString(1, insertPhone.getName());
            preparedStatement.setInt(2, insertPhone.getPrice());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void addInfoAboutXiaomiPhonesToTable() {
        Phone insertPhone = alloUAPhonesPage.getPhone("Xiaomi");
        try {
            PreparedStatement preparedStatement = CONNECTION.prepareStatement(
                    "INSERT INTO Phones (PhoneName, PhonePrice) VALUES " +
                            "(?, ?)");
            preparedStatement.setString(1, insertPhone.getName());
            preparedStatement.setInt(2, insertPhone.getPrice());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterMethod
    public void after() {
        alloUAPhonesPage.closeBrowser();
    }
}
