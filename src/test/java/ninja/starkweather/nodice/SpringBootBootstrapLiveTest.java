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

    private dice createRandomDice() {
        dice dice = new dice();
        dice.setColor(randomAlphabetic(10));
        return dice;
    }

    private String createDiceAsUri(dice dice) {
        Response response = RestAssured.given()
          .contentType(MediaType.APPLICATION_JSON_VALUE)
          .body(dice)
          .post(API_ROOT);
        return API_ROOT + "/" + response.jsonPath().get("id");
    }
    
    @Test
    public void whenGetAllBooks_thenOK() {
    Response response = RestAssured.get(API_ROOT);
 
    assertEquals(HttpStatus.OK.value(), response.getStatusCode());
}
}