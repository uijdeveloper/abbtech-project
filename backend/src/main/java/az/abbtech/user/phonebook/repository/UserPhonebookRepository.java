package az.abbtech.user.phonebook.repository;

import az.abbtech.user.phonebook.entity.UserPhonebookEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPhonebookRepository extends JpaRepository<UserPhonebookEntity, Long> {

    List<UserPhonebookEntity> findAll();

}
