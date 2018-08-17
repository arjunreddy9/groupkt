import com.groupkt.services.api.GetStateService;
import com.groupkt.services.api.GetStateServiceImpl;
import com.groupkt.services.util.ConfigReader;
import com.jayway.jsonpath.JsonPath;
import com.jayway.restassured.response.Response;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * @author amasthipur
 * Created on : 8/16/18
 */
public class TestGetAllStates {

    final int STATE = 55;

    String basePath;

    @Before
    public void setUp() {

        try {
            ConfigReader configReader = new ConfigReader();
            basePath = configReader.getServiceURL("getStatesService");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void countTotalStates() {
        GetStateService getStateService = new GetStateServiceImpl(basePath);
        Response response = getStateService.getAllStatesByCountry();
        Assert.assertEquals(response.getStatusCode(), 200);
        List<String> resultList = JsonPath.read(response.getBody().asString(),  "RestResponse.result");
        String message = JsonPath.read(response.getBody().asString(),  "$.RestResponse.messages[0]");
        Assert.assertEquals("Count should be 55", STATE, resultList.size());
        Assert.assertEquals(message, "Total [55] records found.");
    }

    @Test
    public void checkAState() {
        GetStateService getStateService = new GetStateServiceImpl(basePath);
        Response response = getStateService.getAllStatesByCountry();
        String abbr = JsonPath.read(response.getBody().asString(), "RestResponse.result[6].abbr");
        Assert.assertEquals(abbr, "CA");
    }
}
