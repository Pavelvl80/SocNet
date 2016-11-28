package com.dao;

import com.model.Messages;
import com.model.Users;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MessageDAOImpl extends AbstractDAOImplDB<Messages> implements MessageDAO {

    //    @Override
//    public Messages saveMessage(Messages message) {
//        messages.add(message);
//        return message;
//    }

    @Autowired
    UserDAO userDAO;

    @Override
    public Messages saveMessage(Messages message) {
        return save(message);
    }

    @Override
//    @SuppressWarnings("unchecked")
    public List<Messages> getByUserId(Long id) {
        String hql = "from Messages t where t.fromUser.id = :fromUserId OR t.toUser.id = :toUserId";
        Query query = getSession().createQuery(hql);
        query.setParameter("fromUserId", id);
        query.setParameter("toUserId", id);
        return query.list();
    }

    @Override
    public List<Messages> getByUser(Users user) {
        return null;
    }
//
//    @Override
//    public List<Messages> getAll() {
//        return messages;
//    }
//
//    @Override
//    public Messages saveMessage(Messages message) {
//        return null;
//    }


    @Override
    public List<Messages> getAll() {
        return null;
    }
}
