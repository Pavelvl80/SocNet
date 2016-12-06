package com.dao;

import com.model.Messages;
import com.model.Users;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.Date;
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

//    @Override
//    public List<Messages> getByUser(Users user) {
//        return null;
//    }
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

    @Override
    public Messages changeActiveStatus(Messages message, int i) {
        message.setActive(i);
        return entityManager.merge(message);
    }

    @Override
    public List<Messages> getTenLastMessagesByUserId(Long id) {
        String hql = "from Messages t where t.fromUser.id = :idParam order by t.id DESC";
        Query query = getSession().createQuery(hql);
        query.setParameter("idParam", id);
        query.setMaxResults(10);
        return query.list();
    }

    @Override
    public List<Messages> getMessagesByDate(Long id, String ddMMyyyy) throws Exception {
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(ddMMyyyy);


        String hql = "FROM Messages t WHERE t.fromUser.id = :idParam AND t.toUser.id = :idParam OR t.dateSent >= :dateParam AND t.dateSent < :dateParamPlus ";

        long plus = date.getTime() + 1 * 24 * 60 * 60 * 1000;
        Date datePlus = new Date(plus);


        Query query = getSession().createQuery(hql);
        query.setParameter("dateParam", date);
        query.setParameter("dateParamPlus", datePlus);
        query.setParameter("idParam", id);
        return query.list();
    }
}
