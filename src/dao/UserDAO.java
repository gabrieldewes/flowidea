package dao;

import database.DBHelper;
import model.User;
import service.UserService;
import util.ResponseDataArrayList;

import javax.jws.WebService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dewes on 11/06/2016.
 */
@WebService(endpointInterface = "service.UserService")
public class UserDAO implements UserService {

    private static Connection conn = null;

    public UserDAO () {
        //conn = DBHelper.getConnection();
    }

    @Override
    public boolean save(String fullname, String username, String password) {
        final String INSERT = "INSERT INTO users (fullname, username, password) VALUES (?, ?, ?); ";
        User u = new User(0, fullname, username, password);
        try {
            conn = DBHelper.getConnection();
            PreparedStatement stmt = conn.prepareStatement(INSERT);
            stmt.setString(1, u.getFullname());
            stmt.setString(2, u.getUsername());
            stmt.setString(3, u.getPassword());
            stmt.executeUpdate();
            stmt.close();
            conn.close();
            System.out.println( "("+ u.getId_user() +")"+ u.getFullname() +" : "+ u.getUsername() +" : "+ u.getPassword() +" salvo. ");
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
        final String UPDATE = "UPDATE users SET fullname=?, username=?, password=? WHERE id_user=?; ";
        User u = getById(id_user);
        User aux = new User(id_user, fullname, username, password);

        if (u.equals(aux)) return true;

        try {
            conn = DBHelper.getConnection();
            PreparedStatement stmt = conn.prepareStatement(UPDATE);
            stmt.setString(1, aux.getFullname());
            stmt.setString(2, aux.getUsername());
            stmt.setString(3, aux.getPassword());
            stmt.setLong(4, id_user);
            stmt.executeUpdate();
            stmt.close();
            conn.close();
            System.out.println("=> ("+ u.getId_user() +") "+ u.getFullname() +" : "+ u.getUsername() +" : "+ u.getPassword() );
            System.out.println("=> alterado para  ("+ aux.getId_user() +") "+ aux.getFullname() +" : "+ aux.getUsername() +" : "+ aux.getPassword() );
            return true;
        }
        catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro "+ e.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(long id_user) {
        final String DELETE = "DELETE FROM users WHERE id_user= ?; ";
        User u = getById(id_user);
        if (u != null)
            try {
                conn = DBHelper.getConnection();
                PreparedStatement stmt = conn.prepareStatement(DELETE);
                stmt.setLong(1, u.getId_user());
                stmt.executeUpdate();
                stmt.close();
                conn.close();
                System.out.println("=> ("+ u.getId_user() +") "+ u.getUsername() +" apagado.");
                return true;
            }
            catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Erro "+ e.getMessage());
            }
        return false;
    }

    @Override
    public User getById(long id_user) {
        final String SELECT = "SELECT * FROM users WHERE id_user=?; ";
        User u = null;
        try {
            conn = DBHelper.getConnection();
            PreparedStatement stmt = conn.prepareStatement(SELECT);
            stmt.setLong(1, id_user);
            ResultSet rs = stmt.executeQuery();
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    long id = rs.getLong("id_user");
                    String name = rs.getString("fullname");
                    String user = rs.getString("username");
                    String pass = rs.getString("password");

                    u = new User(id, name, user, pass);
                    System.out.println( "Pegou ("+ u.getId_user() +") "+ u.getFullname() +" : "+ u.getUsername() +" : "+ u.getPassword() );
                }
            }
            else
                System.out.println("Não achou nada com o ID ("+ id_user +"). ");

            stmt.close();
            conn.close();
            return u;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro "+ e.getMessage());
        }
        return null;
    }

    @Override
    public User getByUsername(String username) {
        final String SELECT = "SELECT * FROM users WHERE username=?; ";
        User u = null;
        try {
            conn = DBHelper.getConnection();
            PreparedStatement stmt = conn.prepareStatement(SELECT);
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    long id = rs.getLong("id_user");
                    String name = rs.getString("fullname");
                    String user = rs.getString("username");
                    String pass = rs.getString("password");

                    u = new User(id, name, user, pass);
                    System.out.println( "Pegou ("+ u.getId_user() +") "+ u.getFullname() +" : "+ u.getUsername() +" : "+ u.getPassword() );
                }
            }
            else
                System.out.println("Não achou nada com o USERNAME ("+ username +"). ");

            stmt.close();
            conn.close();
            return u;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro "+ e.getMessage());
        }
        return null;
    }

    @Override
    public ResponseDataArrayList getAll() {
        final String GET = "SELECT * FROM users; ";
        ArrayList<User> users = new ArrayList<>();
        ResponseDataArrayList rdarray = new ResponseDataArrayList();

        try {
            conn = DBHelper.getConnection();
            PreparedStatement stmt = conn.prepareStatement(GET);
            ResultSet rs = stmt.executeQuery();
            if (rs.isBeforeFirst()) {
                System.out.println("=> => => Listando todos usuários...");
                while (rs.next()) {
                    long id = rs.getLong("id_user");
                    String name = rs.getString("fullname");
                    String user = rs.getString("username");
                    String pass = rs.getString("password");

                    User u = new User(id, name, user, pass);
                    users.add(u);
                    System.out.println( "("+ u.getId_user() +") "+ u.getFullname() +" : "+ u.getUsername() +" : "+ u.getPassword() );
                }
            }
            rdarray.setList(users);
            stmt.close();
            conn.close();

            return rdarray;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro "+ e.getMessage());
        }
        return null;
    }

}
