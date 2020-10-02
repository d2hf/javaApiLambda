package lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.amazonaws.services.lambda.runtime.LambdaLogger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

// Handler value: example.Handler
public class Handler implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent>{

    @Override
    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent event, Context context)
    {
        LambdaLogger logger = context.getLogger();

        // get http
        String httpMethod = event.getHttpMethod();

        // creates the http response that be returned to the API
        APIGatewayProxyResponseEvent response = new APIGatewayProxyResponseEvent();
        response.setIsBase64Encoded(false);

        HashMap<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("Access-Control-Allow-Origin", "*");
        headers.put("Access-Control-Allow-Methods", "OPTIONS,POST,GET");

        response.setHeaders(headers);

        logger.log("STARTING CONNECTION");
        // creates connection
        JDBPoster jdb = new JDBPoster(
                "jdbc:postgresql://" + System.getenv("RDS_ENDPOINT") + ":5432/" + System.getenv("DB_NAME"),
                System.getenv("DB_USERNAME"),
                System.getenv("DB_PASSWORD"),
                context);
        jdb.connect();
        DBQueryer dbq = new DBQueryer();

        logger.log("CONNECTED TO DB");
        logger.log(httpMethod);

        if (httpMethod.equals("POST")) {
            try {
                // creates Parser object
                // parses APIGateway body to Relatorio object
                logger.log("POSTING RELATORIO OBJECT");
                JsonParser jsonP = new JsonParser();
                DailyReport r = jsonP.parseReportBody(event.getBody());

                logger.log("REPORT OBJECT CREATED, PERSISTING IT IN TABLE");
                dbq.persistRelatorioFullJson(jdb.getC(), r);

                logger.log("PROCESSING COMPLETED FINISHING LAMBDA EXECUTION");
                response.setBody(event.getBody());
                response.setStatusCode(200);
            } catch (Exception e) {
                logger.log(e.toString());
                response.setStatusCode(500);
            }
        }
        else if (httpMethod.equals("GET")) {
            try {
                System.out.println("SEARCHING ON DB");

                Gson gson = new GsonBuilder().setPrettyPrinting().setDateFormat("dd-MM-yyyy").create();

                // gets date from event body
                // process it as a date
                // extracts month and year from object
                String dateString = event.getQueryStringParameters().get("date");
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM");
                Date date = formatter.parse(dateString);
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);

                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH) + 1;

                logger.log(String.valueOf(month));
                logger.log(String.valueOf(year));

                List<DailyReport> dailyReports = dbq.getMonthData(jdb.getC(), year, month);
                MonthlyReport monthlyReport = new MonthlyReport(dailyReports);

                response.setStatusCode(200);
                response.setBody(gson.toJson(monthlyReport));

            } catch (Exception e) {
                logger.log("ERROR");
                logger.log(e.toString());
            }
        }

        return response;
    }
}