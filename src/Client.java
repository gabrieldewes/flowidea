import model.User;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Dewes on 11/06/2016.
 */
public class Client {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://localhost:9000/dao?wsdl");
            QName qname = new QName("http://dao/","MyDAOService");
            Service ws = Service.create(url, qname);

            service.GenericDAO sus = ws.getPort(service.GenericDAO.class);
            sus.save(new User(0, "gabriel", "gabriel", "gabriel"));

            //service.UserService sus = ws.getPort(service.UserService.class);
            //sus.save("Dewes", "dewes", "dewes");
            //sus.save("Fernando", "fer", "fer");

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }
}
