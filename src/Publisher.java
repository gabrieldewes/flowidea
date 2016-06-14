import javax.xml.ws.Endpoint;

/**
 * Created by Dewes on 11/06/2016.
 */
public class Publisher {
    public static void main(String[] args) {
        //Endpoint.publish("http://localhost:9000/flowidea/obj", new dao.MyDAO() );
        Endpoint.publish("http://localhost:8080/flowidea/login", new dao.LoginDAO() );
        Endpoint.publish("http://localhost:8080/flowidea/user", new dao.UserDAO() );
        Endpoint.publish("http://localhost:8080/flowidea/idea", new dao.IdeaDAO() );
    }
}
