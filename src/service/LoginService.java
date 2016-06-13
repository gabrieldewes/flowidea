package service;

import model.User;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * Created by gabriel on 12/06/16.
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface LoginService {
    @WebMethod
    boolean login (
            @WebParam(name = "username") String username,
            @WebParam(name = "password") String password);

    @WebMethod
    boolean userExists (
            @WebParam(name = "username") String username);

}
