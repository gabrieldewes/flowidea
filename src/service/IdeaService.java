package service;

import model.Idea;
import util.ResponseDataArrayList;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.sql.Timestamp;

/**
 * Created by gabriel on 13/06/16.
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface IdeaService {
    @WebMethod
    boolean save(
            @WebParam(name = "id_user") long id_user,
            @WebParam(name = "content") String content);

    @WebMethod
    boolean update(
            @WebParam(name = "id_idea") long id_idea,
            @WebParam(name = "content") String content,
            @WebParam(name = "likes") int likes);

    @WebMethod
    boolean delete(
            @WebParam(name = "id_idea") long id_idea);

    @WebMethod
    Idea getById(
            @WebParam(name = "id_idea") long id_idea);

    @WebMethod
    ResponseDataArrayList getAllByUser (
            @WebParam(name = "id_user") long id_user);

    @WebMethod
    ResponseDataArrayList getAllUserLikes (
            @WebParam(name = "id_idea") long id_idea,
            @WebParam(name = "id_user") long id_user);

    @WebMethod
    int getLikesCount (
            @WebParam(name = "id_idea") long id_idea);
}
