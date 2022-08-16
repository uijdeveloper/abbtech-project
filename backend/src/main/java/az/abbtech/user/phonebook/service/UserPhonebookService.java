package az.abbtech.user.phonebook.service;

import az.abbtech.user.phonebook.dto.UserPhonebookOperation;
import az.abbtech.user.phonebook.entity.UserPhonebookEntity;

import java.util.List;

public interface UserPhonebookService {

    List<UserPhonebookEntity> getUsers();

    UserPhonebookOperation postUser(UserPhonebookEntity userPhonebookEntity);

    UserPhonebookOperation updateUser(UserPhonebookEntity userPhonebookEntity);

    UserPhonebookOperation removeUser(Long userId);
}
