package service;

import database.DBHelper;
import server.UserService;
import javax.jws.WebService;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Dewes on 11/06/2016.
 */
@WebService(endpointInterface = "server.UserService")
public class UserDAO implements UserService {
    private static Connection conn;

    public UserDAO () {

    }

    @Override
    public boolean save(String fullname, String username, String password) {

        try {
            if (conn == null)
                conn = DBHelper.getConnection();
            System.out.println("Quem chegou aqui foi o " + fullname);
            conn.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
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
}
