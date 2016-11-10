package com;

import java.util.ArrayList;
import java.util.List;

public class MessageDAOImpl extends AbstractDAOImpl<Message> implements MessageDAO {

    //    @Override
//    public Message save(Message message) {
//        messages.add(message);
//        return message;
//    }

    @Override
    public List<Message> getByUserId(long id) {
        List<Message> res = new ArrayList<>();

        //select * from users where user.is != 101

        for (Message message : getAll()) {
            if (message.getFromUser().getId() == id
                    || message.getToUser().getId() == id) res.add(message);
        }

        return res;
    }

    @Override
    public List<Message> getByUser(User user) {
        return null;
    }
//
//    @Override
//    public List<Message> getAll() {
//        return messages;
//    }
//
//    @Override
//    public Message save(Message message) {
//        return null;
//    }


    @Override
    public List<Message> getAll() {
        return null;
    }
}
