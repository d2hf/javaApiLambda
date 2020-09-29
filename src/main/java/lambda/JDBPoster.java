package lambda;

import java.sql.Connection;
import java.sql.DriverManager;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;

public class JDBPoster {

    private String url;
    private String user;
    private String password;
    private Context context;
    private final String jdbc = "org.postgresql.Driver";
    private Connection c;


    public JDBPoster(){
        // empty
    }

    public JDBPoster(String url, String user, String password, Context context) {
        this.url = url;
        this.user = user;
        this.password = password;
        this.context = context;
    }

    public void connect() {
        LambdaLogger logger = this.context.getLogger();
        try {
            Connection conn = DriverManager.getConnection(this.url,
                    this.user,
                    this.password);
            this.c = conn;
        } catch (Exception e) {
            logger.log(e.getMessage());
        }
    }

    public Connection getC() {
        return c;
    }
}