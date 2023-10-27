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

    //
    private dice createRandomDice() {
      final dice dice = new dice();
      dice.setSides(Integer.parseInt(randomNumeric(10)));
      dice.setValue(Integer.parseInt(randomNumeric(10)));
      dice.setName(randomAlphabetic(10));
      dice.setBorder(randomAlphabetic(10));
      dice.setFont(randomAlphabetic(10));
      dice.setTexture(randomAlphabetic(10));
      dice.setBorderColor(Integer.parseInt(randomNumeric(10)));
      dice.setFontColor(Integer.parseInt(randomNumeric(10)));
      dice.setBackgroundColor(Integer.parseInt(randomNumeric(10)));
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