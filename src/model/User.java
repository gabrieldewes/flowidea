package model;

/**
 * Created by Dewes on 11/06/2016.
 */
public class User {
    private long id_user;
    private String fullname;
    private String username;
    private String password;

    public User () {

    }

    public User (long id_user, String fullname, String username, String password) {
        this.id_user = id_user;
        this.fullname = fullname;
        this.username = username;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (getId_user() != user.getId_user()) return false;
        if (!getFullname().equals(user.getFullname())) return false;
        if (!getUsername().equals(user.getUsername())) return false;
        return getPassword().equals(user.getPassword());

    }

    @Override
    public int hashCode() {
        int result = (int) (getId_user() ^ (getId_user() >>> 32));
        result = 31 * result + getFullname().hashCode();
        result = 31 * result + getUsername().hashCode();
        result = 31 * result + getPassword().hashCode();
        return result;
    }

    public long getId_user() {
        return id_user;
    }
    public void setId_user(long id_user) {
        this.id_user = id_user;
    }
    public String getFullname() {
        return fullname;
    }
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
