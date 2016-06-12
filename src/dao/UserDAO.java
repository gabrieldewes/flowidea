package dao;

import com.sun.xml.ws.developer.Stateful;
import database.DBHelper;
import model.User;
import service.GenericDAO;
import service.UserService;

import javax.jws.WebService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Dewes on 11/06/2016.
 */
@WebService(endpointInterface = "service.UserService")
public class UserDAO implements UserService {

    private ArrayList<User> users = new ArrayList<>();
    private static Connection conn = null;

    public UserDAO () {

    }

    private static final String INSERT = "INSERT INTO users (fullname, username, password) VALUES (?, ?, ?); ";

    @Override
    public boolean save(String fullname, String username, String password) {
        User u = new User(0, fullname, username, password);
        System.out.println("=> "+ u.getFullname() +" chegou");
        try {
            conn = DBHelper.getConnection();
            PreparedStatement stmt = conn.prepareStatement(INSERT);
            stmt.setString(1, u.getFullname());
            stmt.setString(2, u.getUsername());
            stmt.setString(3, u.getPassword());
            stmt.executeUpdate();
            stmt.close();
            conn.close();
            return true;
        }
        catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro "+ e.getMessage());
        }
        return false;
    }

    @Override
    public boolean update(long id_user, String fullname, String username, String password) {
        return false;
    }

    @Override
    public boolean delete(long id_user) {
        return false;
    }

    @Override
    public boolean getUser(long id_user, String fullname, String username) {
        return false;
    }

    @Override
    public ArrayList<User> getAll() {
        return null;
    }
}
