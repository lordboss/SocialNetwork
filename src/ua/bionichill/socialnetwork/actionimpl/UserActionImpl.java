package ua.bionichill.socialnetwork.actionimpl;

import java.util.List;

import org.apache.log4j.Logger;

import ua.bionichill.socialnetwork.action.UserAction;
import ua.bionichill.socialnetwork.dao.UserDao;
import ua.bionichill.socialnetwork.daoimpl.UserDaoImpl;
import ua.bionichill.socialnetwork.dto.UStatus;
import ua.bionichill.socialnetwork.dto.UType;
import ua.bionichill.socialnetwork.dto.User;
import ua.bionichill.socialnetwork.exceptions.UserDaoException;
import ua.bionichill.socialnetwork.factory.UserDaoFactory;

public class UserActionImpl implements UserAction {

    private static final Logger logger = Logger.getLogger(UserActionImpl.class);

    /**
     * Method 'main'
     * 
     * @param arg
     * @throws Exception
     */
    public static void main(String[] arg) throws Exception {

	// Uncomment one of the lines below to test the generated code
	User u = new User();
	u.setEmail("semen@semen.com");
	u.setPassw("semen");
	u.setProfile(null);
	UType ut = new UType();
	ut.setUType("REGISTERED");
	u.setTypeU(ut);
	UStatus us = new UStatus();
	us.setUStatus("ACTIVE");
	u.setStatusU(us);
	u.setRegistrDate(null);
	new UserActionImpl().createUser(u);
	// UserActionImpl uai = new UserActionImpl();

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
	// TODO Implement of verifying that that user with the same name is
	// absent in db
	ProfileActionImpl profile = new ProfileActionImpl();
	User dto = user;
	dto.setProfile(profile.createProfile());
	try {
	    new UserDaoImpl().insert(dto);
	    logger.info("User " + dto.getEmail() + " created.");
	} catch (UserDaoException e) {
	    logger.error("Error occurred during creation of a new user: ", e);
	    e.printStackTrace();
	}
	// TODO Auto-generated method stub
    }

    @Override
    public User updateUser(String email, User user) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public void delete(String email) {
	// TODO Auto-generated method stub

    }

    @Override
    public User getUserByPK(String email) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public List<User> getUserList() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public void blockUser(String email) {
	// TODO Auto-generated method stub

    }

    /**
     * Method 'findByProfile'
     * 
     * @param profileId
     */
    public static void findByProfile(Integer profileId) {
	try {
	    UserDao _dao = getUserDao();
	    User _result[] = _dao.findByProfile(profileId);
	    for (int i = 0; i < _result.length; i++) {
		display(_result[i]);
	    }

	} catch (Exception _e) {
	    _e.printStackTrace();
	}

    }

    /**
     * Method 'getUserDao'
     * 
     * @return UserDao
     */
    public static UserDao getUserDao() {
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
}
