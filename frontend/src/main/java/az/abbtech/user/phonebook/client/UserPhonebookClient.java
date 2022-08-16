package az.abbtech.user.phonebook.client;

import az.abbtech.user.phonebook.dto.UserPhonebookOperation;
import az.abbtech.user.phonebook.dto.UserPhonebookEntity;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "user-phonebook-api", url = "${endpoints.user-phonebook-api}")
public interface UserPhonebookClient {


    @GetMapping(value = "/user/list",
            produces = MediaType.APPLICATION_JSON_VALUE)
    List<UserPhonebookEntity> getUsers(@RequestHeader(value = "Host") String hostName);

    @PostMapping(value = "/user/add",
            produces = MediaType.APPLICATION_JSON_VALUE)
    UserPhonebookOperation postUser(@RequestBody UserPhonebookEntity userEntity, @RequestHeader(value = "Host") String hostName );

    @PutMapping(value = "/user/update",
            produces = MediaType.APPLICATION_JSON_VALUE)
    UserPhonebookOperation updateUser(@RequestBody UserPhonebookEntity userEntity, @RequestHeader(value = "Host") String hostName);

    @DeleteMapping(value = "/user/remove",
            produces = MediaType.APPLICATION_JSON_VALUE)
    UserPhonebookOperation removeUser(@RequestBody UserPhonebookEntity userEntity, @RequestHeader(value = "Host") String hostName);

    @GetMapping(value = "/status",
            produces = MediaType.APPLICATION_JSON_VALUE)
    List<UserPhonebookEntity> getStatus(@RequestHeader(value = "Host") String hostName);
}
