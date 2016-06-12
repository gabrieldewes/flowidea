package service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.ArrayList;

/**
 * Created by gabriel on 12/06/16.
 */
@WebService
public interface GenericDAO<T> {
    @WebMethod boolean save (@WebParam(name = "obj") T obj);
    @WebMethod boolean update (@WebParam(name = "obj") T obj);
    @WebMethod boolean delete (@WebParam(name = "obj") T obj);
    @WebMethod T get (@WebParam(name = "id") int id);
    @WebMethod ArrayList<T> getAll ();

}
