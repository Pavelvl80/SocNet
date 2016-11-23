package com;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MessageDAOImpl extends AbstractDAOImplDB<Messages> implements MessageDAO {

    //    @Override
//    public Messages saveMessage(Messages message) {
//        messages.add(message);
//        return message;
//    }


    @Override
    public Messages saveMessage(Messages message) {
        return save(message);
    }

    @Override
    public List<Messages> getByUserId(long id) {
        List<Messages> res = new ArrayList<>();

        //select * from users where user.is != 101

        for (Messages messages : getAll()) {
            if (messages.getFromUser().getId() == id
                    || messages.getToUser().getId() == id) res.add(messages);
        }

        return res;
    }

    @Override
    public List<Messages> getByUser(UserOld user) {
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
