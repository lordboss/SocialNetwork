package ua.bionichill.socialnetwork.actionimpl;

import java.util.List;

import org.apache.log4j.Logger;

import ua.bionichill.socialnetwork.action.ProfileAction;
import ua.bionichill.socialnetwork.dao.ProfileDao;
import ua.bionichill.socialnetwork.daoimpl.ProfileDaoImpl;
import ua.bionichill.socialnetwork.dto.Profile;
import ua.bionichill.socialnetwork.dto.Profile.Sex;
import ua.bionichill.socialnetwork.exceptions.ProfileDaoException;
import ua.bionichill.socialnetwork.factory.ProfileDaoFactory;

public class ProfileActionImpl implements ProfileAction {

    private static final Logger logger = Logger
	    .getLogger(ProfileActionImpl.class);

    @Override
    public Profile createProfile() {
	try {
	    Profile dto = new Profile();
	    dto.setIdProfile(null);
	    dto.setFName(null);
	    dto.setSurName(null);
	    dto.setSex(Sex.NONE);
	    dto.setPict(null);
	    dto.setIntrod(null);
	    dto.setHobby(null);
	    logger.info("Create a new profile");
	    return findWhereIdProfileEquals((new ProfileDaoImpl().insert(dto))
		    .getIdProfile());
	} catch (ProfileDaoException e) {
	    logger.error("Error occurred during creation of a new profile: ", e);
	    // e.printStackTrace();
	}
	return null;
    }

    @Override
    public Profile updateProfile(Integer idProfile, Profile profile) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public void delete(Integer idProfile) {
	// TODO Auto-generated method stub

    }

    @Override
    public Profile getProfileByPK(Integer idProfile) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public List<Profile> getProfileList() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public List<Profile> getProfileListByHobby(List<String> hobby) {
	// TODO Auto-generated method stub
	return null;
    }

    /**
     * Method 'findWhereIdProfileEquals'
     * 
     * @param idProfile
     */
    public static Profile findWhereIdProfileEquals(Integer idProfile) {
	try {
	    ProfileDao _dao = getProfileDao();
	    Profile _result[] = _dao.findWhereIdProfileEquals(idProfile);
	    for (int i = 0; i < _result.length; i++) {
		return _result[i];
	    }

	} catch (Exception _e) {
	    _e.printStackTrace();
	}
	return null;

    }

    /**
     * Method 'getProfileDao'
     * 
     * @return ProfileDao
     */
    public static ProfileDao getProfileDao() {
	return ProfileDaoFactory.create();
    }

    /**
     * Method 'display'
     * 
     * @param dto
     */
    public static void display(Profile dto) {
	StringBuffer buf = new StringBuffer();
	buf.append(dto.getIdProfile());
	buf.append(", ");
	buf.append(dto.getFName());
	buf.append(", ");
	buf.append(dto.getSurName());
	buf.append(", ");
	buf.append(dto.getSex());
	buf.append(", ");
	buf.append(dto.getPict());
	buf.append(", ");
	buf.append(dto.getIntrod());
	buf.append(", ");
	buf.append(dto.getHobby());
	System.out.println(buf.toString());
    }

}
