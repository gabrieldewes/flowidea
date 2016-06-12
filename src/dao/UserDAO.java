package dao;

import database.DBHelper;
import model.User;
import service.UserService;

import javax.jws.WebService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    private static final String UPDATE = "UPDATE users SET fullname=?, username=?, password=? WHERE id+user=?; ";
    private static final String DELETE = "DELETE FROM users WHERE id_user=?; ";
    private static final String SELECT = "SELECT * FROM users WHERE id_user=?; ";
    private static final String GET = "SELECT * FROM users; ";

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
    public boolean getById(long id_user) {
        return false;
    }

    @Override
    public boolean getByUsername(String username) {
        return false;
    }

    @Override
    public ArrayList<User> getAll() {
        try {
            conn = DBHelper.getConnection();
            PreparedStatement stmt = conn.prepareStatement(GET);
            ResultSet rs = stmt.executeQuery();
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    long id = rs.getLong("id_user");
                    String name = rs.getString("fullname");
                    String user = rs.getString("username");
                    String pass = rs.getString("password");

                    User u = new User(id, name, user, pass);
                    users.add(u);
                    System.out.println("(" + id + ") - "+ name + " : " + user +" : "+ pass);
                }
            }
            stmt.close();
            conn.close();
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro "+ e.getMessage());
        }
        return null;
    }

    @Override
    public boolean checkPassword(String username, String password) {
        return false;
    }

}
