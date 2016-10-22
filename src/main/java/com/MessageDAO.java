package com;

import java.util.List;

/**
 * Created by Edvard Piri on 13.10.2016.
 */
public interface MessageDAO {

    Message save(Message message);

    List<Message> getByUserId(long id);

    List<Message> getByUser(User user);

    List<Message> getAll();
}