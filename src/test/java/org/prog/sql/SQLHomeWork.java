package org.prog.sql;

//TODO: usual Homework: Create table Addresses, where you write
// Person's Name, LastName, City Name, Street Name, Address

//TODO: usual homework + : re-write this test using BeforeSuite and AfterSuite

//TODO: Homework * : Create table Phones : PhoneId, PhoneName, PhonePrice
// - using selenium go to allo.ua, search for a phone
// - get phone name
// - get phone price
// - store phone name and phone price to DB


import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.prog.dto.LocationDto;
import org.prog.dto.NameDto;
import org.prog.dto.PersonDto;
import org.prog.dto.ResultsDto;
import org.testng.annotations.Test;

import java.sql.*;
import java.util.List;

public class SQLHomeWork {

    @Test
    public void insertAddresses() throws SQLException, ClassNotFoundException {
        List<ResultsDto> results = getRandomAddresses();
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection =
                DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "user", "password");

        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO Addresses (FirstName, LastName, City, Street, FullAddress) VALUES (?, ?, ?, ?, ?)");

        for (ResultsDto result : results) {
            PersonDto person = result.getResults().get(0);
            LocationDto location = person.getLocation();
            preparedStatement.setString(1, person.getName().getFirst());
            preparedStatement.setString(2, person.getName().getLast());
            preparedStatement.setString(3, location.getCity());
            preparedStatement.setString(4, location.getStreet().getName());
            preparedStatement.setString(5, location.getStreet().getNumber() + " " + location.getStreet().getName());
            try {
                preparedStatement.execute();
            } catch (SQLException e) {
                System.out.println("Failed to store in DB : " + person.getName().getFirst() + " " + person.getName().getLast());
            }
        }
        connection.close();
    }

    private List<ResultsDto> getRandomAddresses() {
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://randomuser.me/");
        requestSpecification.basePath("/api");
        requestSpecification.queryParam("inc", "gender,name,nat,location");
        requestSpecification.queryParam("noinfo");
        requestSpecification.queryParam("results", "3");

        Response response = requestSpecification.get();
        return List.of(response.as(ResultsDto.class));
    }

}





