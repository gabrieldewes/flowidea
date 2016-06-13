import model.User;
import util.ResponseDataArrayList;

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
            URL url = new URL("http://localhost:9000/flowidea/login?wsdl");
            URL url2 = new URL("http://localhost:9000/flowidea/user?wsdl");
            URL url3 = new URL("http://localhost:9000/flowidea/idea?wsdl");

            QName qname = new QName("http://dao/","LoginDAOService");
            QName qname2 = new QName("http://dao/","UserDAOService");
            QName qname3 = new QName("http://dao/","IdeaDAOService");

            Service ws = Service.create(url, qname);
            Service ws2 = Service.create(url2, qname2);
            Service ws3 = Service.create(url3, qname3);

            service.LoginService s = ws.getPort(service.LoginService.class);
            service.UserService s2 = ws2.getPort(service.UserService.class);
            service.IdeaService s3 = ws3.getPort(service.IdeaService.class);

            //service.GenericDAO sus = ws.getPort(service.GenericDAO.class);
            //Object obj = new Object();
            //sus.save(obj);

            //s2.save("Dewes", "dewes", "dewes");

            String user = "dewes";
            String pass = "dewes";
            if (s.userExists(user)) {
                if (s.login(user, pass)) {
                    System.out.println(user +" está logado. ");
                    User u = s2.getByUsername(user);

                    //User u2 = s2.getByUsername("gabriel");
                    //s3.save(u.getId_user(), "Primeira idéia do "+ u.getFullname() + " salva. ");

                    ResponseDataArrayList rdarray = new ResponseDataArrayList();
                    rdarray = s3.getAllByUser(u.getId_user());

                    System.out.println("Chegaram as notas do "+ u.getFullname() +". Temos "+ rdarray.getList().size() +" notas. ");


                }
                else System.out.println("Usuário e senha não coincidem. ");
            }
            else System.out.println("Usuário não existe. ");



            //ArrayList<User> users = new ArrayList<>();
            //ResponseDataArrayList rdarray = new ResponseDataArrayList();
            //rdarray.setList(users);
            //rdarray = sus.getAll();
            //users.addAll(sus.getAll());
            //users.addAll(rdarray.getList());
            //System.out.println(users.get(1).getFullname());

            //Object obj = sus.getById(2);
            //System.out.println("peguei do webservice "+ obj.getClass());
            //User u = (User) obj;
            //System.out.println("ele virou um "+ u.getFullname());

            //System.out.println("Mandei para o webservice um "+ obj.getClass());

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }
}
