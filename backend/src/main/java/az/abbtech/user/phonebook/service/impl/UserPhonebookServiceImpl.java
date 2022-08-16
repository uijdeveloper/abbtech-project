package az.abbtech.user.phonebook.service.impl;

import az.abbtech.user.phonebook.dto.UserPhonebookOperation;
import az.abbtech.user.phonebook.repository.UserPhonebookRepository;
import az.abbtech.user.phonebook.entity.UserPhonebookEntity;
import az.abbtech.user.phonebook.service.UserPhonebookService;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserPhonebookServiceImpl implements UserPhonebookService {

    private final UserPhonebookRepository userPhonebookRepository;

    @Override
    public List<UserPhonebookEntity> getUsers() {
        return userPhonebookRepository.findAll();
    }

    @Override
    public UserPhonebookOperation postUser(UserPhonebookEntity userPhonebookEntity) {

        try {
            UserPhonebookEntity user = userPhonebookRepository.save(userPhonebookEntity);
            return UserPhonebookOperation.builder().user_id(user.getUser_id()).operation_type("add")
                    .operation_status("SUCCESS").build();
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            return UserPhonebookOperation.builder().user_id(userPhonebookEntity.getUser_id()).operation_type("add")
                    .operation_status("FAILURE-" + e.getMessage()).build();
        }
    }

    @Override
    public UserPhonebookOperation updateUser(UserPhonebookEntity userPhonebookEntity) {
        System.out.println(userPhonebookEntity);
        if (userPhonebookEntity.getUser_id() == null) {
            return UserPhonebookOperation.builder().operation_status("FAILURE").operation_type("update")
                    .user_id(userPhonebookEntity.getUser_id()).build();
        }
        try {
            Optional<UserPhonebookEntity> user = userPhonebookRepository.findById(userPhonebookEntity.getUser_id());
            if (user.isPresent()) {
                userPhonebookRepository.save(userPhonebookEntity);
                return UserPhonebookOperation.builder().operation_status("SUCCESS").operation_type("update")
                        .user_id(userPhonebookEntity.getUser_id()).build();
            } else {
                return UserPhonebookOperation.builder().operation_status("FAILURE-USER NOT FOUND").operation_type("update")
                        .user_id(userPhonebookEntity.getUser_id()).build();

            }
        } catch (Exception ex) {
            return UserPhonebookOperation.builder().operation_status("FAILURE-" + ex.getMessage()).operation_type("update")
                    .user_id(userPhonebookEntity.getUser_id()).build();
        }
    }

    @Override
    public UserPhonebookOperation removeUser(Long userId) {
        try {
            if (userId != null) {
                Optional<UserPhonebookEntity> user = userPhonebookRepository.findById(userId);
                if (user.isPresent()) {
                    userPhonebookRepository.delete(new UserPhonebookEntity(userId, null, null));
                    return UserPhonebookOperation.builder().operation_status("SUCCESS").operation_type("remove")
                            .user_id(userId).build();
                } else {
                    return UserPhonebookOperation.builder().operation_status("FAILURE-USER NOT FOUND").operation_type("remove")
                            .user_id(userId).build();
                }

            } else {
                return UserPhonebookOperation.builder().operation_status("FAILURE-USER_ID IS NULL").operation_type("remove")
                        .user_id(userId).build();
            }

        } catch (Exception e) {
            return UserPhonebookOperation.builder().operation_status("FAILURE-" + e.getMessage()).operation_type("remove")
                    .user_id(userId).build();
        }
    }

}
