package org.dealoftheday.bl.test;

import static org.dealoftheday.bl.domain.Role.ROLE_ADMIN;
import static org.dealoftheday.bl.domain.Role.ROLE_DATA_ENTRY;
import static org.dealoftheday.bl.domain.Role.ROLE_EDITOR;
import static org.dealoftheday.bl.domain.Role.ROLE_PUBLISHER;
import static org.dealoftheday.bl.domain.Role.ROLE_READ_ONLY;
import static org.dealoftheday.bl.test.util.TestUtils.createUser;
import static org.dealoftheday.bl.test.util.TestUtils.updateUser;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.dealoftheday.bl.domain.Role;
import org.dealoftheday.bl.domain.User;
import org.dealoftheday.bl.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceTest extends AbstractSpringTest {

	@Autowired
	private UserService userService;

	private static Logger logger = LogManager.getLogger(UserServiceTest.class);

	@Test
	public void test_getUser_withoutRole() {
		// Given
		final String username = "user3";

		// When
		User user = userService.get(username);

		// Then
		assertNotNull(user);
		assertEquals("user3", user.getUserName());
		assertEquals("User3Name", user.getName());
		assertEquals("User3Surname", user.getSurname());
		assertEquals("user3@gmail.com", user.getEmail());
		assertEquals("user3", user.getPwd());
		assertEquals(true, user.getEnabled());
		assertEquals(true, user.getLocked());
		assertEquals(0, user.getFailedLoginCount());
		assertEquals(0, user.getRoles().size());
	}

	@Test
	public void test_getUser_withRoles() {
		// Given
		final String username = "admin";
		final Role adminRole = new Role(ROLE_ADMIN, "Administrator", "Full access and control");
		final Role publisherRole = new Role(ROLE_PUBLISHER, "Publisher", "Role for handling the ");

		// When
		User user = userService.get(username);

		// Then
		assertNotNull(user);
		assertEquals("admin", user.getUserName());
		assertEquals("AdminName", user.getName());
		assertEquals("AdminSurname", user.getSurname());
		assertEquals("sandrus88@hotmail.it", user.getEmail());
		assertEquals("admin", user.getPwd());
		assertEquals(true, user.getEnabled());
		assertEquals(true, user.getLocked());
		assertEquals(0, user.getFailedLoginCount());
		assertEquals(2, user.getRoles().size());
		assertEquals(adminRole, user.getRoles().get(0));
		assertEquals(publisherRole, user.getRoles().get(1));
	}

	@Test
	public void test_getAllUsers() {
		// Given
		final Role adminRole = new Role(ROLE_ADMIN, "Administrator", "Full access and control");
		final Role publisherRole = new Role(ROLE_PUBLISHER, "Publisher", "Role for handling the ");
		final User adminUser = new User("admin", "AdminName", "AdminSurname", "sandrus88@hotmail.it", "admin", true,
				true, 0, Arrays.asList(adminRole, publisherRole));

		// When
		List<User> users = userService.getAll();
		User dbAdminUser = users.get(0);

		// Then
		assertNotNull(users);
		assertEquals(users.size(), 5);

		assertEquals(adminUser, dbAdminUser);
		assertEquals(2, dbAdminUser.getRoles().size());
		assertEquals(adminRole, dbAdminUser.getRoles().get(0));
		assertEquals(publisherRole, dbAdminUser.getRoles().get(1));
	}

	@Test
	public void test_getUser_notPresent() {
		// Given
		final String userName = "fakeUserNotPresent";

		// When
		User user = userService.get(userName);

		// Then
		assertNull(user);
	}

	@Test
	public void test_searchAllUsers() {
		// Given
		User searchBean = new User();

		// When
		List<User> users = userService.searchUser(searchBean);

		// Then
		assertEquals(5, users.size());
	}

	@Test
	public void test_searchUsers_fullMatch() {
		// Given
		User searchBean = new User();
		searchBean.setUserName("userSandro");
		searchBean.setName("Sandro");
		searchBean.setSurname("Gargano");
		searchBean.setEmail("sandro_gargano@hotmail.it");
		searchBean.setPwd("sandro88");
		searchBean.setEnabled(true);
		searchBean.setLocked(true);
		searchBean.addRole(new Role(ROLE_READ_ONLY));

		// When
		List<User> users = userService.searchUser(searchBean);

		// Then
		assertEquals(1, users.size());
		assertEquals("userSandro", users.get(0).getUserName());
		assertEquals("Sandro", users.get(0).getName());
		assertEquals("Gargano", users.get(0).getSurname());
		assertEquals("sandro_gargano@hotmail.it", users.get(0).getEmail());
		assertEquals("sandro88", users.get(0).getPwd());
		assertEquals(true, users.get(0).getEnabled());
		assertEquals(true, users.get(0).getLocked());
	}

	@Test
	public void test_searchUsers_partialMatch() {
		// Given
		User searchBean = new User();
		searchBean.setUserName("UserSAndro");
		searchBean.setName("SAndrO");
		searchBean.setSurname("garGano");
		searchBean.setEmail("sandrO_Gargano@hotmail.it");
		searchBean.setPwd("sandrO88");
		searchBean.setEnabled(true);
		searchBean.setLocked(true);
		searchBean.addRole(new Role(ROLE_READ_ONLY));

		// When
		List<User> users = userService.searchUser(searchBean);

		// Then
		assertEquals(1, users.size());
	}

	@Test
	public void test_searchUsers_byUsername() {
		// Given
		User searchBean = new User();
		searchBean.setUserName("userSandro");

		// When
		List<User> users = userService.searchUser(searchBean);

		// Then
		assertEquals(1, users.size());
	}

	@Test
	public void test_searchUsers_byName() {
		// Given
		User searchBean = new User();
		searchBean.setName("Sandro");

		// When
		List<User> users = userService.searchUser(searchBean);

		// Then
		assertEquals(1, users.size());
	}

	@Test
	public void test_searchUsers_bySurname() {
		// Given
		User searchBean = new User();
		searchBean.setSurname("Gargano");

		// When
		List<User> users = userService.searchUser(searchBean);

		// Then
		assertEquals(1, users.size());
	}

	@Test
	public void test_searchUsers_byEmail() {
		// Given
		User searchBean = new User();
		searchBean.setEmail("sandro_gargano@hotmail.it");
		// When
		List<User> users = userService.searchUser(searchBean);
		// Then
		assertEquals(1, users.size());
	}

	@Test
	public void test_searchUsers_byEnabled() {
		// Given
		User searchBean = new User();
		searchBean.setEnabled(true);
		// When
		List<User> users = userService.searchUser(searchBean);
		// Then
		assertEquals(5, users.size());

		// Given
		searchBean.setEnabled(false);
		// When
		users = userService.searchUser(searchBean);
		// Then
		assertEquals(0, users.size());
	}

	@Test
	public void test_searchUsers_byLocked() {
		// Given
		User searchBean = new User();
		searchBean.setLocked(true);
		// When
		List<User> users = userService.searchUser(searchBean);
		// Then
		assertEquals(4, users.size());

		// Given
		searchBean.setLocked(false);
		// When
		users = userService.searchUser(searchBean);
		// Then
		assertEquals(1, users.size());
	}

	@Test
	public void test_searchUsers_byRole() {
		// Given
		User searchBean = new User();
		final Role adminRole = new Role(ROLE_ADMIN);
		searchBean.setRoles(Arrays.asList(adminRole));
		// When
		List<User> users = userService.searchUser(searchBean);
		// Then
		assertEquals(1, users.size());
	}

	@Test
	public void test_searchUsers_byRole_whenMultipleRolesForSameUser() {
		// Given
		User searchBean = new User();
		List<Role> roles = Arrays.asList(new Role(ROLE_ADMIN), new Role(ROLE_PUBLISHER));
		searchBean.setRoles(roles);
		// When
		List<User> users = userService.searchUser(searchBean);
		// Then
		assertEquals(1, users.size());
	}

	@Test
	public void test_searchUsers_byRoles_all() {
		// Given
		User searchBean = new User();
		final Role adminRole = new Role(ROLE_ADMIN);
		final Role publisherRole = new Role(ROLE_PUBLISHER);
		final Role editorRole = new Role(ROLE_EDITOR);
		final Role dataEntryRole = new Role(ROLE_DATA_ENTRY);
		final Role viewerRole = new Role(ROLE_READ_ONLY);
		List<Role> roleList = new ArrayList<>();
		roleList.add(adminRole);
		roleList.add(publisherRole);
		roleList.add(editorRole);
		roleList.add(dataEntryRole);
		roleList.add(viewerRole);
		searchBean.setRoles(roleList);
		// When
		List<User> users = userService.searchUser(searchBean);
		// Then
		assertEquals(2, users.size());
	}

	@Test
	public void test_insertUser() {
		// Given
		User user = createUser("JunitUserNoRole");

		// When
		user = userService.insert(user);
		User userDb = userService.get(user.getUserName());

		// Then
		assertEquals(userDb, user);
	}

	@Test
	public void test_insertUserWithRoles() {
		// Given
		User user = createUser("JunitUserWithRole");
		final Role roleAdmin = new Role(ROLE_ADMIN);

		// When
		user.addRole(roleAdmin);
		user = userService.insert(user);
		User userDb = userService.get(user.getUserName());

		// Then
		assertEquals(userDb, user);
		assertEquals(1, user.getRoles().size());
		assertEquals(new Integer(ROLE_ADMIN), user.getRoles().get(0).getId());
	}

	@Test
	public void test_updateUser() {
		// Given
		final String username = "user3";

		// When
		User userDb = userService.get(username);
		User userUpdated = updateUser(userDb);
		userUpdated = userService.update(userUpdated);
		User userUpdatedDb = userService.get(username);

		// Then
		assertEquals(userUpdated, userUpdatedDb);
	}

	@Test
	public void test_updateRoles_forUsers() {
		// Given
		final String username = "admin";
		Role roleEditor = new Role(ROLE_EDITOR);

		// When
		User user = userService.get(username);
		user.addRole(roleEditor);
		user = userService.update(user);
		User userDb = userService.get(user.getUserName());

		// Then
		assertEquals(userDb, user);
		assertEquals(3, user.getRoles().size());
		assertEquals(new Integer(ROLE_EDITOR), user.getRoles().get(2).getId());
	}

	@Test
	public void test_updateUser_removeRoles() {
		// Given
		final String username = "admin";
		final Role roleAdmin = new Role(ROLE_ADMIN);

		// When
		User user = userService.get(username);
		user.removeRole(roleAdmin);
		user = userService.update(user);
		User userDb = userService.get(username);

		// Then
		assertEquals(userDb, user);
		assertEquals(1, userDb.getRoles().size());
	}

	@Test
	public void test_deleteUser_withoutRoles() {
		// Given
		final String userName = "user3";

		// When
		boolean deleting = userService.delete(userName);
		User user = userService.get(userName);

		// Then
		assertTrue(deleting);
		assertNull(user);
	}

	@Test
	public void test_deleteUser_withRoles_shouldRemoveUserButNotRoles() {
		// Given
		final String username = "admin";
		final Role adminRole = new Role(ROLE_ADMIN, "Administrator", "Full access and control");

		// When
		boolean deleting = userService.delete(username);
		User user = userService.get(username);
		List<Role> roles = userService.getAllRoles();

		// Then
		assertTrue(deleting);
		assertNull(user);
		assertTrue(roles.contains(adminRole));
	}

	@Test
	public void test_deleteUser_notPresent() {
		// Given
		final String userName = "fakeUserNotPresent";

		// When
		boolean deleting = userService.delete(userName);

		// Then
		assertFalse(deleting);
	}

	@Test
	public void test_user_integrationTest_CRUD() {
		// 1. insert a new user
		User user = createUser("ITUser");
		user = userService.insert(user);
		assertNotNull(user.getUserName());

		// 2. get the user from DB
		User userDb = userService.get(user.getUserName());
		assertNotNull(userDb);
		assertEquals(userDb, user);

		// 3. Update the user in DB, and Get to check if updated correctly
		updateUser(user);
		user = userService.update(user);
		userDb = userService.get(user.getUserName());
		assertEquals(userDb, user);

		// 4. Delete the user from DB, and Get to check if deleted correctly
		boolean isRemoved = userService.delete(user.getUserName());
		assertTrue(isRemoved);
		userDb = userService.get(user.getUserName());
		assertNull(userDb);
	}

}
