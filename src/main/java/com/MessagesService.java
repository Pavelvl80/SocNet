package com;

/**
 * Created by Edvard Piri on 23.11.2016.
 */
public interface MessagesService {
    Messages sendMessage(Messages message);

    int msgCount(long userId);

    Integer isLogged();


}
