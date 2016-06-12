import javax.xml.ws.Endpoint;

/**
 * Created by Dewes on 11/06/2016.
 */
public class Publisher {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:9000/dao", new dao.UserDAO() );
    }
}
