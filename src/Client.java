import model.User;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by Dewes on 11/06/2016.
 */
public class Client {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://localhost:9000/dao?wsdl");
            QName qname = new QName("http://dao/","UserDAOService");
            Service ws = Service.create(url, qname);

            //service.GenericDAO sus = ws.getPort(service.GenericDAO.class);
            //sus.save(new User(0, "gabriel", "gabriel", "gabriel"));

            service.UserService sus = ws.getPort(service.UserService.class);
            //sus.save("Dewes", "dewes", "dewes");
            //sus.save("Fernando", "fer", "fer");

            ArrayList<User> users = new ArrayList<>();
            sus.getAll();
            System.out.println(users.isEmpty());

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }
}
