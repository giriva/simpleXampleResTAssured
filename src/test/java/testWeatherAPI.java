import java.util.Arrays;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.equalTo;


//parameters and headers can be set

public class testWeatherAPI {
    @Test
    public void shouldReturnPersonForTheId() {
        given().
                param("key1", "value1")
                .header("header", "VAlue1").
        when().
                get("http://services.groupkt.com").
//                get("api.openweathermap.org/data/2.5/forecast?id=524901&APPID=1111111111").
        then().
                statusCode(200).
                log().all();

    }


    @Test
    public void testEqualToFunction() {
        given().
                get("http://services.groupkt.com/country/get/iso2code/us").
        then().
                body("RestResponse.result.name",equalTo("United States of America"));
    }

    //To test the items in function
    //@Test
    public void testHasItemFunction() {
        given().
                  get("https://api-adresse.data.gouv.fr/search/?q=8+bd+du+port").
        then().
                  body("point.point.point.point",equalTo("null"));
    }
    @Test
    //XML ITEM HAS CONTENT
    public void testSingleContent() {
        given().
                get("http://www.thomas-bayer.com/sqlrest/CUSTOMER/10/").
        then().
                body("CUSTOMER.ID",equalTo("10")).
                log().all();
    }

    @Test
    //XML ITEM HAS CONTENT
    public void testMultipleContent() {
        given().
                get("http://www.thomas-bayer.com/sqlrest/CUSTOMER/10/").
        then().
                body("CUSTOMER.ID",equalTo("10")).
                body("CUSTOMER.FIRSTNAME",equalTo("Sue")).body("CUSTOMER.LASTNAME",equalTo("Fuller")).
                body("CUSTOMER.STREET",equalTo("135 Upland Pl.")).body("CUSTOMER.CITY",equalTo("Dallas")).
                log().all();
    }

    /**
     * Authentication of user name and password
     * given().auth().basic("username", "password").expect().statusCode(200).when().get("/secured/hello");
     */

    /**
    * In GET request we can set query parameter. Its a queryParam for GET
    */
    @Test
    public void testGetQueryParamers(){

        given().
                queryParam("A","A val").
                queryParam("B","B val").
        when().
               get("https://api.fonts.com/rest/json/Acoounts/").
        then().
               statusCode(400);
    }


    /**
     * In POST request we can set query parameter. Its a formParameter for PUT
     */
    @Test
    public void testPostQueryParamers(){
        given().
                formParam("A","A val").
                formParam("B","B val").
        when().
                put("https://api.fonts.com/rest/json/Acoounts/").
        then().
                statusCode(400);
    }


    /**
     * To set parameters
     *
     * If request is GET then param will be treated as QueryParameter
     *
     */
    public void testSetParameters(){
        given().param("A","A-valie").
                param("B","B-Value").
        when().
                get("https://api.fonts.com/rest/json/Accounts").
        then().
                statusCode(400);

    }

}


