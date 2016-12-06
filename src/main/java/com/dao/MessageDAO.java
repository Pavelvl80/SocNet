package com.dao;

import com.model.Messages;
import com.model.Users;
import org.springframework.stereotype.Repository;

import java.util.Date;
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

    List<Messages> getTenLastMessagesByUserId(Long id);

    List<Messages> getMessagesByDate(Long id, String ddMMyyyy) throws Exception;
}