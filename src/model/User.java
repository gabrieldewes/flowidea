package model;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by Dewes on 11/06/2016.
 */
@XmlRootElement(name = "user")
@XmlType(propOrder = {"id_user", "fullname", "username", "password"})
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
