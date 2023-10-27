package ninja.starkweather.nodice;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import ninja.starkweather.nodice.dice.dice;

import io.restassured.RestAssured;
import io.restassured.response.Response;


public class SpringBootBootstrapLiveTest {

    private static final String API_ROOT
      = "http://localhost:8081/api/dice";
   
    
    @Test
    public void whenGetAllDice_thenOK() {
    Response response = RestAssured.get(API_ROOT);
 
    assertEquals(HttpStatus.OK.value(), response.getStatusCode());
    }

    @Test
    public void whenGetDiceByName_thenOK() {
      final dice dice = createRandomDice();
      createDiceAsUri(dice);

      final Response response = RestAssured.get(API_ROOT + "/name/" + dice.getName());
      assertEquals(HttpStatus.OK.value(), response.getStatusCode());
      assertTrue(response.as(List.class)
          .size() > 0);
    }

    @Test
    public void whenGetCreatedDiceById_thenOK() {
        final dice dice = createRandomDice();
        final String location = createDiceAsUri(dice);

        final Response response = RestAssured.get(location);
        assertEquals(HttpStatus.OK.value(), response.getStatusCode());
        assertEquals(dice.getName(), response.jsonPath()
            .get("name"));
    }

    @Test
    public void whenGetNotExistDiceById_thenNotFound() {
        final Response response = RestAssured.get(API_ROOT + "/" + randomNumeric(4));
        assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatusCode());
    }

    // POST
    @Test
    public void whenCreateNewDice_thenCreated() {
        final dice dice = createRandomDice();

        final Response response = RestAssured.given()
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .body(dice)
            .post(API_ROOT);
        assertEquals(HttpStatus.CREATED.value(), response.getStatusCode());
    }

    @Test
    public void whenInvalidDice_thenError() {
        final dice dice = createRandomDice();
        dice.setName(null);

        final Response response = RestAssured.given()
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .body(dice)
            .post(API_ROOT);
        assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatusCode());
    }

    @Test
    public void whenUpdateCreatedDice_thenUpdated() {
        final dice dice = createRandomDice();
        final String location = createDiceAsUri(dice);

        dice.setId(Long.parseLong(location.split("api/dice/")[1]));
        dice.setName("newName");
        Response response = RestAssured.given()
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .body(dice)
            .put(location);
        assertEquals(HttpStatus.OK.value(), response.getStatusCode());

        response = RestAssured.get(location);
        assertEquals(HttpStatus.OK.value(), response.getStatusCode());
        assertEquals("newName", response.jsonPath()
            .get("name"));

    }

    @Test
    public void whenDeleteCreatedDice_thenOk() {
        final dice dice = createRandomDice();
        final String location = createDiceAsUri(dice);

        Response response = RestAssured.delete(location);
        assertEquals(HttpStatus.OK.value(), response.getStatusCode());

        response = RestAssured.get(location);
        assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatusCode());
    }

    // ===============================

    private dice createRandomDice() {
      final dice dice = new dice();
      dice.setSides(Integer.parseInt(randomNumeric(2)));
      dice.setValue(Integer.parseInt(randomNumeric(3)));
      dice.setName(randomAlphabetic(10));
      dice.setBorder(randomAlphabetic(10));
      dice.setFont(randomAlphabetic(10));
      dice.setTexture(randomAlphabetic(10));
      dice.setBorderColor(Integer.parseInt(randomNumeric(6)));
      dice.setFontColor(Integer.parseInt(randomNumeric(6)));
      dice.setBackgroundColor(Integer.parseInt(randomNumeric(6)));
      return dice;
    }

    private String createDiceAsUri(dice dice) {
        Response response = RestAssured.given()
          .contentType(MediaType.APPLICATION_JSON_VALUE)
          .body(dice)
          .post(API_ROOT);
        return API_ROOT + "/" + response.jsonPath().get("id");
    }

}