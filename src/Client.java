import server.UserService;

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
            URL url = new URL("http://localhost:9000/service?wsdl");
            QName qname = new QName("http://service/","UserDAOService");
            Service ws = Service.create(url, qname);
            server.UserService sus = ws.getPort(server.UserService.class);
            String nome = "gabriel";
            System.out.println("mandei o "+ nome +" pro webservice...");

            sus.save(nome, nome, nome);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }
}
