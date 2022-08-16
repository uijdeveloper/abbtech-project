package az.abbtech.user.phonebook.controller;


import az.abbtech.user.phonebook.dto.UserPhonebookOperation;
import az.abbtech.user.phonebook.entity.UserPhonebookEntity;
import az.abbtech.user.phonebook.service.UserPhonebookService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
@RequiredArgsConstructor
public class UsersPhonebookController {

    private final UserPhonebookService userPhonebookService;

    @GetMapping("/status")
    public ResponseEntity<List<UserPhonebookEntity>> status() {
        return ResponseEntity.ok(userPhonebookService.getUsers());
    }

    @GetMapping("/user/list")
    public ResponseEntity<List<UserPhonebookEntity>> listUsers() {
        return ResponseEntity.ok(userPhonebookService.getUsers());
    }

    @PostMapping("/user/add")
    public ResponseEntity<UserPhonebookOperation> addUser(@RequestBody UserPhonebookEntity userPhonebookEntity) {
        return ResponseEntity.ok(userPhonebookService.postUser(userPhonebookEntity));
    }

    @PutMapping("/user/update")
    public ResponseEntity<UserPhonebookOperation> updateUser(@RequestBody UserPhonebookEntity userPhonebookEntity) {
        return ResponseEntity.ok(userPhonebookService.updateUser(userPhonebookEntity));
    }

    @DeleteMapping("/user/remove")
    public ResponseEntity<UserPhonebookOperation> removeUser(@RequestBody UserPhonebookEntity userPhonebookEntity) {
        return ResponseEntity.ok(userPhonebookService.removeUser(userPhonebookEntity.getUser_id()));
    }


}
