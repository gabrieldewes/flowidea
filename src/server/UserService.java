package server;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * Created by Dewes on 11/06/2016.
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface UserService {
    @WebMethod boolean save(String fullname, String username, String password);
    @WebMethod boolean update(long id_user, String fullname, String username, String password);
    @WebMethod boolean delete(long id_user);
}
