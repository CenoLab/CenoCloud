package com.iot.nero.facade;

import com.iot.nero.parent_facade.entity.Author;
import com.iot.nero.parent_facade.exception.*;

import java.util.List;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2018/5/18
 * Time   下午7:45
 */
public interface IAuthorFacade {

    Author initAuthor(Integer ssoId, String nickname) throws AuthorAlreadyFoundException, AuthorInitFailedException;

    Author getAuthorBySsoID(Integer ssoId) throws AuthorNotFoundException;

    Author getAuthorByID(Integer authorId) throws AuthorNotFoundException;

    Integer followAuthor(Author author, Integer authorId) throws AuthorNotFoundException, FollowFailedException, AlreadyFollowedException;

    Integer unFollowAuthor(Author author, Integer authorId) throws AuthorNotFoundException, FollowFailedException, UnFollowedException;

    List<Author> listMyFollow(Author author, Integer page, Integer num) throws AuthorNotFoundException;

    List<Author> listMyFans(Author author, Integer page, Integer num) throws AuthorNotFoundException;
}
