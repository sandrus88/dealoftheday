package org.dealoftheday.admin.backingbean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.dealoftheday.bl.domain.Role;
import org.dealoftheday.bl.domain.User;
import org.dealoftheday.bl.service.RoleService;
import org.dealoftheday.bl.service.UserService;

@ManagedBean
@ViewScoped
public class UserController {
	
	@ManagedProperty(value = "#{userService}")
	private UserService userService;
	
	@ManagedProperty(value = "#{roleService}")
	private RoleService roleService;
	
	private String newUserName;
	private String newName;
	private String newSurname;
	private String newEmail;
	private String newPwd;
	private Boolean newEnabled;
	private Boolean newLocked;
	
	private String searchName;
	private String searchSurname;
	private String searchEmail;
	
	private List<Role> allRoles;
	private List<User> userList = new ArrayList<>();
	private User selectedUser;
//	private boolean checked;
	
	@PostConstruct
	public void init() {
		allRoles = roleService.getAll();
		selectedUser = new User();
		searchUser();
		cleanDialogForm();
		cleanSearchForm();
	}
	
	public void searchUser() {
		User searchDto = new User(null, searchName, searchSurname, searchEmail, null, null, null, -1, null);
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
	}

	public void cleanSearchForm() {
		searchName = null;
		searchSurname = null;
		searchEmail = null;
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
		for (int i = 0; i < allRoles.size(); i++) {
			final Role role = allRoles.get(i);
//			if (isChecked()) {
				user.addRole(role);
//			}	
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
	
	public void viewRoles(User user) {
		selectedUser = user;
		List<Role> selectedUserRoles = user.getRoles();

		for (int i = 0; i < allRoles.size(); i++) {
			Role role = allRoles.get(i);
//			if (selectedUserRoles.contains(role)) {
//				role.setChecked(true);
//				role.isDisabled(selectedUser);
//			}
		}
		searchUser();
	}

	public void updateUserRoles(User user) {
		selectedUser = user;
		for (int i = 0; i < allRoles.size(); i++) {
			final Role role = allRoles.get(i);
//			if (role.isChecked()) {
//				selectedUser.addRole(role);
//			} else {
//				selectedUser.removeRole(role);
//			}
		}
		selectedUser = userService.update(selectedUser);
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

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

//	public boolean isChecked() {
//		return checked;
//	}
//
//	public void setChecked(boolean checked) {
//		this.checked = checked;
//	}
}