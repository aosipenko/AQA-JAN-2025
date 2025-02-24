package homeworks;

import api.serialization.Address;
import api.serialization.AddressDto;
import api.serialization.ResultsDto;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//TODO: usual Homework: Create table Addresses, where you write
// Person's Name, LastName, City Name, Street Name, Address
//TODO: usual homework + : re-write this test using BeforeSuite and AfterSuite
//TODO: Homework * : Create table Phones : PhoneId, PhoneName, PhonePrice
// - using selenium go to allo.ua, search for a phone
// - get phone name
// - get phone price
// - store phone name and phone price to DB
public class SQLHomeworkAddressesTable extends BaseSQLTest{


    @Test
    public void createTable() {
        try {
            STATEMENT.execute("CREATE TABLE Addresses (" +
                    "PersonID int UNIQUE AUTO_INCREMENT NOT NULL," +
                    "FirstName varchar(255) NOT NULL," +
                    "LastName varchar(255) NOT NULL," +
                    "City varchar(255) NOT NULL," +
                    "StreetName varchar(255) NOT NULL," +
                    "Address int NOT NULL)");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void deleteTable() {
        try {
            STATEMENT.execute("DROP TABLE Addresses");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void addDataToTable() throws SQLException {
        List<Address> addresses = getInfoAboutUsersAddresses(getUsersAndLocations());

        PreparedStatement preparedStatement = CONNECTION.prepareStatement(
                "INSERT INTO Addresses (FirstName, LastName, City, StreetName, Address) VALUES " +
                        "(?, ?, ?, ?, ?)");
        for (Address address : addresses) {
            preparedStatement.setString(1, address.getFirstName());
            preparedStatement.setString(2, address.getLastName());
            preparedStatement.setString(3, address.getCity());
            preparedStatement.setString(4, address.getNameOfStreet());
            preparedStatement.setInt(5, address.getNumberOfStreet());
            try {
                preparedStatement.execute();
            } catch (SQLException e) {
                System.out.println("Failed to store in DB : " + address.getFirstName() + " " + address.getLastName()
                + " " + address.getCity() + " " + address.getNameOfStreet());
            }
        }
    }

    private List<AddressDto> getUsersAndLocations() {
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://randomuser.me/");
        requestSpecification.basePath("/api");
        requestSpecification.queryParam("inc", "name, location");
        requestSpecification.queryParam("noinfo");
        requestSpecification.queryParam("results", "5");
        Response response = requestSpecification.get();
        return response.as(ResultsDto.class).getResults();
    }

    private List<Address> getInfoAboutUsersAddresses(List<AddressDto> listWithInfoAboutUsersAddresses) {
        List<Address> listWithInfoAboutAddresses = new ArrayList<>();
        for (int i = 0; i < listWithInfoAboutUsersAddresses.size(); i++) {
            listWithInfoAboutAddresses.add(new Address(
                    listWithInfoAboutUsersAddresses.get(i).getName().getFirst(),
                    listWithInfoAboutUsersAddresses.get(i).getName().getLast(),
                    listWithInfoAboutUsersAddresses.get(i).getLocation().getCity(),
                    listWithInfoAboutUsersAddresses.get(i).getLocation().getStreet().getName(),
                    listWithInfoAboutUsersAddresses.get(i).getLocation().getStreet().getNumber()));
        }
        return listWithInfoAboutAddresses;
    }

}
