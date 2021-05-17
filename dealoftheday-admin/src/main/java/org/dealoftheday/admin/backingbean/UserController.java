package org.dealoftheday.admin.backingbean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.dealoftheday.bl.domain.Role;
import org.dealoftheday.bl.domain.User;
import org.dealoftheday.bl.service.UserService;

@ManagedBean
@ViewScoped
public class UserController {

	@ManagedProperty(value = "#{userService}")
	private UserService userService;

	private static Logger logger = LogManager.getLogger(UserController.class);

	private String newUserName;
	private String newName;
	private String newSurname;
	private String newEmail;
	private String newPwd;
	private Boolean newEnabled;
	private Boolean newLocked;

	private String searchUsername;
	private String searchName;
	private String searchSurname;
	private String searchEmail;
	private List<Role> searchRole;

	private List<Role> allRoles;
	private List<User> userList = new ArrayList<>();
	private User selectedUser;

	@PostConstruct
	public void init() {
		allRoles = userService.getAllRoles();
		selectedUser = new User();
		searchUser();
		cleanDialogForm();
		cleanSearchForm();
	}

	public void searchUser() {
		User searchDto = new User(searchUsername, searchName, searchSurname, searchEmail, null, null, null, -1,
				searchRole);
		userList = userService.searchUser(searchDto);
	}

	public void cleanDialogForm() {
		newUserName = null;
		newName = null;
		newSurname = null;
		newEmail = null;
		newPwd = null;
		newEnabled = null;
		newLocked = null;
		selectedUser.setRoles(null);
	}

	public void cleanSearchForm() {
		searchUsername = null;
		searchName = null;
		searchSurname = null;
		searchEmail = null;
		searchRole = null;
	}

	public void addUser() {
		User user = new User();
		user.setUserName(newUserName);
		user.setName(newName);
		user.setSurname(newSurname);
		user.setEmail(newEmail);
		user.setPwd(newPwd);
		user.setEnabled(newEnabled);
		user.setLocked(newLocked);
		for (int i = 0; i < selectedUser.getRoles().size(); i++) {
			Role role = selectedUser.getRoles().get(i);
			user.addRole(role);
		}
		userService.insert(user);
		cleanDialogForm();
		searchUser();
	}

	public void updateSelectedUser(User user) {
		userService.update(user);
		searchUser();
	}

	public void deleteUser(User user) {
		userService.delete(user.getUserName());
		searchUser();
	}

	public String getNewUserName() {
		return newUserName;
	}

	public void setNewUserName(String newUserName) {
		this.newUserName = newUserName;
	}

	public String getNewName() {
		return newName;
	}

	public void setNewName(String newName) {
		this.newName = newName;
	}

	public String getNewSurname() {
		return newSurname;
	}

	public void setNewSurname(String newSurname) {
		this.newSurname = newSurname;
	}

	public String getNewEmail() {
		return newEmail;
	}

	public void setNewEmail(String newEmail) {
		this.newEmail = newEmail;
	}

	public String getNewPwd() {
		return newPwd;
	}

	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}

	public Boolean getNewEnabled() {
		return newEnabled;
	}

	public void setNewEnabled(Boolean newEnabled) {
		this.newEnabled = newEnabled;
	}

	public Boolean getNewLocked() {
		return newLocked;
	}

	public void setNewLocked(Boolean newLocked) {
		this.newLocked = newLocked;
	}

	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}

	public String getSearchSurname() {
		return searchSurname;
	}

	public void setSearchSurname(String searchSurname) {
		this.searchSurname = searchSurname;
	}

	public String getSearchEmail() {
		return searchEmail;
	}

	public void setSearchEmail(String searchEmail) {
		this.searchEmail = searchEmail;
	}

	public String getSearchUsername() {
		return searchUsername;
	}

	public void setSearchUsername(String searchUsername) {
		this.searchUsername = searchUsername;
	}

	public List<Role> getSearchRole() {
		return searchRole;
	}

	public void setSearchRole(List<Role> searchRole) {
		this.searchRole = searchRole;
	}

	public List<Role> getAllRoles() {
		return allRoles;
	}

	public void setAllRoles(List<Role> allRoles) {
		this.allRoles = allRoles;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public User getSelectedUser() {
		return selectedUser;
	}

	public void setSelectedUser(User selectedUser) {
		this.selectedUser = selectedUser;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}