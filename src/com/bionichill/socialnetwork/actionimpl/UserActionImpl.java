package com.bionichill.socialnetwork.actionimpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.bionichill.socialnetwork.action.IUserAction;
import com.bionichill.socialnetwork.dao.IUserDao;
import com.bionichill.socialnetwork.daoimpl.UserDaoImpl;
import com.bionichill.socialnetwork.dto.User;
import com.bionichill.socialnetwork.dto.UserPk;
import com.bionichill.socialnetwork.exceptions.UserDaoException;
import com.bionichill.socialnetwork.factory.UserDaoFactory;

public class UserActionImpl implements IUserAction {

    private static final Logger logger = Logger.getLogger(UserActionImpl.class);

    /**
     * Method 'main'
     * 
     * @param arg
     * @throws Exception
     */
    public static void main(String[] arg) throws Exception {

	// Uncomment one of the lines below to test the generated code
	// User u = new User();
	// u.setEmail("sem@sem.com");
	// u.setPassw("sem");
	// u.setProfile(null);
	// UType ut = new UType();
	// ut.setUType("REGISTERED");
	// u.setTypeU(ut);
	// UStatus us = new UStatus();
	// us.setUStatus("BLOCKED");
	// u.setStatusU(us);
	// u.setRegistrDate(null);
	// u = new UserActionImpl().getUserByPK("sem@sem.com");
	// u.setStatusU(us);
	// new UserActionImpl().createUser(u);
	// new UserActionImpl().updateUser(u);
	// UserActionImpl uai = new UserActionImpl();
	for (User dto : new UserActionImpl().getUserList()) {
	    display(dto);
	}

	// findAll();
	// findByProfile(null);
	// findByUStatus("ACTIVE");
	// findByUType("REGISTERED");
	// findWhereEmailEquals("");
	// findWherePasswEquals("");
	// findWhereTypeUEquals("");
	// findWhereStatusUEquals("");
	// findWhereProfileIdEquals(null);
	// findWhereRegistrDateEquals(null);
    }

    @Override
    public void createUser(User user) {
	ProfileActionImpl profile = new ProfileActionImpl();
	User dto = user;
	if (!user.equals(new UserActionImpl().getUserByPK(user.getEmail()))) {
	    dto.setProfile(profile.createProfile());
	    try {
		new UserDaoImpl().insert(dto);
		logger.info("User " + dto.getEmail() + " created.");
	    } catch (UserDaoException e) {
		logger.error("Error occurred during creation of a new user: ",
			e);
		e.printStackTrace();
	    }
	}
	// TODO return error message if user already prsent in db
    }

    @Override
    public void updateUser(User user) {
	try {
	    new UserDaoImpl().update(new UserPk(user.getEmail()), user);
	    logger.info("Update info about " + user.getEmail());
	} catch (UserDaoException e) {
	    logger.error("Error occurred during update a user: ", e);
	}
    }

    @Override
    public void delete(String email) {
	// TODO Auto-generated method stub

    }

    @Override
    public User getUserByPK(String email) {
	try {
	    IUserDao _dao = getIUserDao();
	    User _result = _dao.findByPrimaryKey(email);
	    return _result;
	} catch (Exception _e) {
	    _e.printStackTrace();
	}
	return null;
    }

    @Override
    public List<User> getUserList() {
	List<User> uList = new ArrayList<>();
	try {
	    IUserDao _dao = getIUserDao();
	    User _result[] = _dao.findAll();
	    for (int i = 0; i < _result.length; i++) {
		uList.add(_result[i]);
	    }
	    return uList;
	} catch (UserDaoException e) {
	    logger.error("Error occurred during get all users: ", e);
	}
	return null;
    }

    @Override
    public void blockUser(String email) {
	// TODO Auto-generated method stub

    }

    /**
     * Method 'getUserDao'
     * 
     * @return UserDao
     */
    public static IUserDao getIUserDao() {
	return UserDaoFactory.create();
    }

    /**
     * Method 'display'
     * 
     * @param dto
     */
    public static void display(User dto) {
	StringBuffer buf = new StringBuffer();
	buf.append(dto.getEmail());
	buf.append(", ");
	buf.append(dto.getPassw());
	buf.append(", ");
	buf.append(dto.getTypeU());
	buf.append(", ");
	buf.append(dto.getStatusU());
	buf.append(", ");
	buf.append(dto.getProfile());
	buf.append(", ");
	buf.append(dto.getRegistrDate());
	System.out.println(buf.toString());
    }

    @Override
    public void askFriendsh(User inviter, User invitee) {
	// TODO Auto-generated method stub

    }
}
