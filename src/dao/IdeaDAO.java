package dao;

import database.DBHelper;
import model.Idea;
import service.IdeaService;
import util.ResponseDataArrayList;
import javax.jws.WebService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by gabriel on 13/06/16.
 */
@WebService(endpointInterface = "service.IdeaService")
public class IdeaDAO implements IdeaService {

    Connection conn = null;

    @Override
    public boolean save(long id_user, String content) {
        final String INSERT = "insert into idea (content, in_date, likes, id_has_user) values (?, current_timestamp(), 0, ?); ";
        try {
            conn = DBHelper.getConnection();
            PreparedStatement stmt = conn.prepareStatement(INSERT);
            stmt.setString(1, content);
            stmt.setLong(2, id_user);
            stmt.execute();
            stmt.close();
            conn.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println( e.getMessage() );
        }

        return false;
    }

    @Override
    public boolean update(long id_idea, String content, int likes) {

        return false;
    }

    @Override
    public boolean delete(long id_idea) {
        return false;
    }

    @Override
    public Idea getById(long id_idea) {
        return null;
    }

    @Override
    public ResponseDataArrayList getAllByUser(long id_user) {

        final String GET = "select * from idea where id_has_user = ?; ";
        ResponseDataArrayList rdarray = new ResponseDataArrayList();
        ArrayList<Idea> ideas = new ArrayList<>();

        try {
            conn = DBHelper.getConnection();
            PreparedStatement stmt = conn.prepareStatement(GET);
            stmt.setLong(1, id_user);
            ResultSet rs = stmt.executeQuery();
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    Idea idea = new Idea (
                            rs.getLong("id_idea"),
                            rs.getString("content"),
                            rs.getDate("in_date"),
                            rs.getInt("likes"),
                            rs.getInt("id_has_user"));
                    System.out.println( idea.toString() );
                    ideas.add(idea);
                }
            }
            rdarray.setList(ideas);
            return rdarray;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println( e.getMessage() );
        }
        return null;
    }

    @Override
    public ResponseDataArrayList getAllUserLikes(long id_idea, long id_user) {
        return null;
    }

    @Override
    public int getLikesCount(long id_idea) {

        return 0;
    }

}
