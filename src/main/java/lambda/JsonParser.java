package lambda;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonParser {

    public JsonParser(){
        // empty
    }

    public DailyReport parseReportBody(String body){
        // creates gson object
        // interprets jsonObject to desired class object

        Gson gson = new GsonBuilder().setPrettyPrinting().setDateFormat("dd-MM-yyyy").create();
        return gson.fromJson(body, DailyReport.class);
    }
}
