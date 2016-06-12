package dao;

import database.DBHelper;
import model.User;
import service.GenericDAO;

import javax.jws.WebService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by gabriel on 12/06/16.
 */
@WebService(endpointInterface = "service.GenericDAO")
public class MyDAO implements GenericDAO<User> {
    Connection conn = null;
    private static final String INSERT = "INSERT INTO users (fullname, username, password) VALUES (?, ?, ?); ";
    @Override
    public boolean save(User u) {
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
    public boolean update(User obj) {
        return false;
    }

    @Override
    public boolean delete(User obj) {
        return false;
    }

    @Override
    public User get(int id) {
        return null;
    }

    @Override
    public ArrayList<User> getAll() {
        return null;
    }
}
