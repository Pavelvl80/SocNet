package com.dao;

import com.model.Messages;
import com.model.Users;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Edvard Piri on 13.10.2016.
 */
@Repository
public interface MessageDAO {

    Messages saveMessage(Messages message);

    List<Messages> getByUserId(Long id);

//    List<Messages> getByUser(Users user);

    List<Messages> getAll();

    Messages changeActiveStatus(Messages message, int i);
}