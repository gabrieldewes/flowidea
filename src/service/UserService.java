package service;

import dao.UserDAO;
import model.User;
import util.ResponseDataArrayList;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;

/**
 * Created by Dewes on 11/06/2016.
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface UserService {
    @WebMethod
    boolean save(
            @WebParam(name = "fullname") String fullname,
            @WebParam(name = "username") String username,
            @WebParam(name = "password") String password);

    @WebMethod
    boolean update(
            @WebParam(name = "id_user") long id_user,
            @WebParam(name = "fullname") String fullname,
            @WebParam(name = "username") String username,
            @WebParam(name = "password") String password);

    @WebMethod
    boolean delete(
            @WebParam(name = "id_user") long id_user);

    @WebMethod
    User getById(
            @WebParam(name = "id_user") long id_user);

    @WebMethod
    User getByUsername(
            @WebParam(name = "username") String username);

    @WebMethod
    ResponseDataArrayList getAll ();

}
