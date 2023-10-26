package ninja.starkweather.nodice;

import org.junit.Test;
import org.springframework.boot.actuate.web.exchanges.HttpExchange.Response;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import ninja.starkweather.nodice.dice.DiceNotFoundException;
import ninja.starkweather.nodice.dice.DiceIdMismatchException;
import ninja.starkweather.nodice.dice.dice;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

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