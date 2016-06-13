package dao;

import model.User;
import service.LoginService;

import javax.jws.WebService;

/**
 * Created by gabriel on 13/06/16.
 */
@WebService(endpointInterface = "service.LoginService")
public class LoginDAO implements LoginService {
    @Override
    public boolean login(String username, String password) {
        User u = getUser(username);
        if (u != null) {
            if (checkPassword(u, password)) {
                return true;
            }
            else System.out.println("Os dados "+ username +" : "+ password +" não conincidem. ");
        }
        else System.out.println("Nenhum usuário encontrado com o user: "+ username);
        return false;
    }

    @Override
    public boolean userExists (String username) {
        UserDAO ud = new UserDAO();
        User u = ud.getByUsername(username);
        return u != null;
    }

    public User getUser (String username) {
        UserDAO ud = new UserDAO();
        User u = ud.getByUsername(username);
        return u;
    }

    public boolean checkPassword (User u, String pass) {
        if (u != null) {
            if (u.getPassword().contentEquals(pass)) {
                return true;
            }
            else System.out.println("Senha incorreta para o usuário "+ u.getUsername());
        }
        return false;
    }
}
