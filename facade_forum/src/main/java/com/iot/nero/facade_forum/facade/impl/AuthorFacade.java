package com.iot.nero.facade_forum.facade.impl;

import com.iot.nero.facade.IAuthorFacade;
import com.iot.nero.facade_forum.dao.AuthorDao;
import com.iot.nero.facade_forum.dao.FollowDao;
import com.iot.nero.parent_facade.entity.Author;
import com.iot.nero.parent_facade.entity.FollowPair;
import com.iot.nero.parent_facade.exception.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.iot.nero.parent_facade.constant.CONSTANT.*;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2018/5/18
 * Time   下午7:46
 */
@Service
public class AuthorFacade implements IAuthorFacade {

    @Autowired
    private AuthorDao authorDao;

    @Autowired
    private FollowDao followDao;

    public Author initAuthor(Integer ssoid, String nickname) throws AuthorAlreadyFoundException, AuthorInitFailedException {
        Author author = authorDao.findAuthorByCloudId(ssoid);
        if(author!=null){
            throw new AuthorAlreadyFoundException(AUTHOR_ALREADY_INITED);
        }
        Integer init = authorDao.initAuthor(nickname,ssoid);
        if(init<1){
            throw new AuthorInitFailedException(AUTHOR_INIT_FAILED);
        }
        return authorDao.findAuthorByCloudId(ssoid);
    }

    public Author getAuthorBySsoID(Integer ssoid) throws AuthorNotFoundException {
        Author author = authorDao.findAuthorByCloudId(ssoid);
        if(author==null){
            throw new AuthorNotFoundException(AUTHOR_NOT_FOUND);
        }
        return author;
    }

    public Author getAuthorByID(Integer authorId) throws AuthorNotFoundException {
        Author author = authorDao.findAuthorById(authorId);
        if(author==null){
            throw new AuthorNotFoundException(AUTHOR_NOT_FOUND);
        }
        return author;
    }

    public Integer followAuthor(Author author, Integer authorId) throws AuthorNotFoundException, FollowFailedException, AlreadyFollowedException {
        if(author==null){
            throw new AuthorNotFoundException(AUTHOR_NOT_FOUND);
        }

        FollowPair followPair = followDao.getFollowPairByAuthorId(author.getAuthorId(),authorId);

        if(followPair!=null && followPair.getDel().equals(0)){
            throw new AlreadyFollowedException(ALREADY_FOLLOWED);
        }

        if(followPair.getDel().equals(0)){
            Integer isFollow = followDao.updateFollow(author.getAuthorId(),authorId);
            if(isFollow<1){
                throw new FollowFailedException(FOLLOW_FAILED);
            }
            return isFollow;
        }

        Integer isFollow = followDao.addFollow(author.getAuthorId(),authorId);
        if(isFollow<1){
            throw new FollowFailedException(FOLLOW_FAILED);
        }
        return isFollow;
    }

    public Integer unFollowAuthor(Author author, Integer authorId) throws AuthorNotFoundException, FollowFailedException, UnFollowedException {
        if(author==null){
            throw new AuthorNotFoundException(AUTHOR_NOT_FOUND);
        }

        FollowPair followPair = followDao.getFollowPairByAuthorId(author.getAuthorId(),authorId);

        if(followPair==null){
            throw new UnFollowedException(UN_FOLLOWED);
        }

        Integer isFollow = followDao.delFollow(author.getAuthorId(),authorId);
        if(isFollow<1){
            throw new FollowFailedException(FOLLOW_FAILED);
        }
        return isFollow;
    }

    public List<Author> listMyFollow(Author author, Integer page, Integer num) throws AuthorNotFoundException {
        if(author==null){
            throw new AuthorNotFoundException(AUTHOR_NOT_FOUND);
        }
        return followDao.listFollowByAuthor(author.getAuthorId(),page,num);
    }

    public List<Author> listMyFans(Author author, Integer page, Integer num) throws AuthorNotFoundException {
        if(author==null){
            throw new AuthorNotFoundException(AUTHOR_NOT_FOUND);
        }
        return followDao.listFansByAuthor(author.getAuthorId(),page,num);
    }
}
