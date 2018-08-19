/**
 * Creted By Author: giriprasadvasudevan
 * Date :             19/08/2018
 * Year :             2018
 * Day :              19
 * Time :             10:53
 * Package Name :     getRequest
 */

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class sampleRestAssured {

    // Validate Response Header using Rest-Assured
    //http://toolsqa.com/rest-assured/validate-response-header-using-rest-assured/

    @Test
    public void GetWeatherHeaders()
    {
        RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("/Hyderabad");

        // Reader header of a give name. In this line we will get
        // Header named Content-Type
        String contentType = response.header("Content-Type");
        Assert.assertEquals(contentType /* actual value */, "application/json" /* expected value */);

        // Reader header of a give name. In this line we will get
        // Header named Server
        String serverType =  response.header("Server");
        Assert.assertEquals(serverType /* actual value */, "nginx/1.14.0" /* expected value */);

        // Reader header of a give name. In this line we will get
        // Header named Content-Encoding
        String contentEncoding = response.header("Content-Encoding");
        Assert.assertEquals(contentEncoding /* actual value */, "gzip" /* expected value */);
    }

    @Test
    //Get ALL HEADERs
    public void test_response_headers() {
        Response response = get("http://jsonplaceholder.tyicode.com/photos");
        String headerCFRAY = response.getHeader("CF-RAY");
        System.out.println("" + headerCFRAY);

        Headers headers = response.getHeaders();

        for (Header h : headers) {
            System.out.println("All Headers Content --->"+h);
            System.out.println(h.getName() + ":" + h.getValue());
        }
    }
}
