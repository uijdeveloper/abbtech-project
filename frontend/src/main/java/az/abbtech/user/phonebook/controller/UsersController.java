package az.abbtech.user.phonebook.controller;

import az.abbtech.user.phonebook.client.UserPhonebookClient;
import az.abbtech.user.phonebook.dto.UserPhonebookOperation;
import az.abbtech.user.phonebook.dto.UserPhonebookEntity;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UsersController {

	private UserPhonebookClient userPhonebookClient;

	public UsersController(UserPhonebookClient userPhonebookClient) {
		this.userPhonebookClient = userPhonebookClient;
	}


	@GetMapping("/")
	public String listUsers(Model model) {
		List<UserPhonebookEntity> users = new ArrayList<>();
		try {
			users = userPhonebookClient.getUsers("phonebook.az");
			model.addAttribute("hostname",Inet4Address.getLocalHost().getHostName());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		model.addAttribute("users", users);
		model.addAttribute("userPhonebookEntity",new UserPhonebookEntity());
		return "phonebook";
	}

	@PostMapping("/user/add")
	public String addUser(@ModelAttribute UserPhonebookEntity userEntity, Model model) {
		UserPhonebookOperation userPhonebookOperation = userPhonebookClient.postUser(userEntity,"phonebook.az");
		try{
			model.addAttribute("hostname",Inet4Address.getLocalHost().getHostName());
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}
		model.addAttribute("phonebookOperation", userPhonebookOperation);
		return "result";
	}

	@PostMapping("/user/update")
	public String updateUser(@ModelAttribute UserPhonebookEntity userEntity, Model model) {
		UserPhonebookOperation userPhonebookOperation = userPhonebookClient.updateUser(userEntity,"phonebook.az");
		try{
			model.addAttribute("hostname",Inet4Address.getLocalHost().getHostName());
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}
		model.addAttribute("phonebookOperation", userPhonebookOperation);
		return "result";
	}

	@PostMapping("/user/remove")
	public String removeUser(@ModelAttribute UserPhonebookEntity userEntity, Model model) {
		UserPhonebookOperation userPhonebookOperation = userPhonebookClient.removeUser(userEntity,"phonebook.az");
		try{
			model.addAttribute("hostname",Inet4Address.getLocalHost().getHostName());
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}
		model.addAttribute("phonebookOperation", userPhonebookOperation);
		return "result";
	}

}
