package com;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Edvard Piri on 13.10.2016.
 */
@Repository
public interface MessageDAO {

    Messages saveMessage(Messages message);

    List<Messages> getByUserId(long id);

    List<Messages> getByUser(UserOld user);

    List<Messages> getAll();
}