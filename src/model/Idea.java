package model;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by gabriel on 13/06/16.
 */
public class Idea {
    private long id_idea;
    private String content;
    private Date in_date;
    private int likes;
    private int id_has_user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Idea idea = (Idea) o;

        if (id_idea != idea.id_idea) return false;
        if (likes != idea.likes) return false;
        if (id_has_user != idea.id_has_user) return false;
        if (content != null ? !content.equals(idea.content) : idea.content != null) return false;
        return in_date != null ? in_date.equals(idea.in_date) : idea.in_date == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id_idea ^ (id_idea >>> 32));
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (in_date != null ? in_date.hashCode() : 0);
        result = 31 * result + likes;
        result = 31 * result + id_has_user;
        return result;
    }

    @Override
    public String toString() {
        return "Idea{" +
                "id_idea=" + id_idea +
                ", content='" + content + '\'' +
                ", in_date=" + in_date +
                ", likes=" + likes +
                ", id_has_user=" + id_has_user +
                '}';
    }

    public Idea() {

    }

    public Idea(long id_idea, String content, Date in_date, int likes, int id_has_user) {
        this.id_idea = id_idea;
        this.content = content;
        this.in_date = in_date;
        this.likes = likes;
        this.id_has_user = id_has_user;
    }

    public long getId_idea() {
        return id_idea;
    }

    public void setId_idea(long id_idea) {
        this.id_idea = id_idea;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getIn_date() {
        return in_date;
    }

    public void setIn_date(Date in_date) {
        this.in_date = in_date;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getId_has_user() {
        return id_has_user;
    }

    public void setId_has_user(int id_has_user) {
        this.id_has_user = id_has_user;
    }
}
