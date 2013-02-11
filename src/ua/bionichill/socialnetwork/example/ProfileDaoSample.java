package ua.bionichill.socialnetwork.example;

import ua.bionichill.socialnetwork.dao.ProfileDao;
import ua.bionichill.socialnetwork.dto.Profile;
import ua.bionichill.socialnetwork.factory.ProfileDaoFactory;

public class ProfileDaoSample {
    /**
     * Method 'main'
     * 
     * @param arg
     * @throws Exception
     */
    public static void main(String[] arg) throws Exception {
	// Uncomment one of the lines below to test the generated code

	findAll();
	// findWhereIdProfileEquals(null);
	// findWhereFNameEquals("");
	// findWhereSurNameEquals("");
	findWhereSexEquals("MALE");
	// findWherePictEquals(null);
	// findWhereIntrodEquals("");
	// findWhereHobbyEquals("");
    }

    /**
     * Method 'findAll'
     * 
     */
    public static void findAll() {
	try {
	    ProfileDao _dao = getProfileDao();
	    Profile _result[] = _dao.findAll();
	    for (int i = 0; i < _result.length; i++) {
		display(_result[i]);
	    }

	} catch (Exception _e) {
	    _e.printStackTrace();
	}

    }

    /**
     * Method 'findWhereIdProfileEquals'
     * 
     * @param idProfile
     */
    public static void findWhereIdProfileEquals(Integer idProfile) {
	try {
	    ProfileDao _dao = getProfileDao();
	    Profile _result[] = _dao.findWhereIdProfileEquals(idProfile);
	    for (int i = 0; i < _result.length; i++) {
		display(_result[i]);
	    }

	} catch (Exception _e) {
	    _e.printStackTrace();
	}

    }

    /**
     * Method 'findWhereFNameEquals'
     * 
     * @param fName
     */
    public static void findWhereFNameEquals(String fName) {
	try {
	    ProfileDao _dao = getProfileDao();
	    Profile _result[] = _dao.findWhereFNameEquals(fName);
	    for (int i = 0; i < _result.length; i++) {
		display(_result[i]);
	    }

	} catch (Exception _e) {
	    _e.printStackTrace();
	}

    }

    /**
     * Method 'findWhereSurNameEquals'
     * 
     * @param surName
     */
    public static void findWhereSurNameEquals(String surName) {
	try {
	    ProfileDao _dao = getProfileDao();
	    Profile _result[] = _dao.findWhereSurNameEquals(surName);
	    for (int i = 0; i < _result.length; i++) {
		display(_result[i]);
	    }

	} catch (Exception _e) {
	    _e.printStackTrace();
	}

    }

    /**
     * Method 'findWhereSexEquals'
     * 
     * @param sex
     */
    public static void findWhereSexEquals(String sex) {
	try {
	    ProfileDao _dao = getProfileDao();
	    Profile _result[] = _dao.findWhereSexEquals(sex);
	    for (int i = 0; i < _result.length; i++) {
		display(_result[i]);
	    }

	} catch (Exception _e) {
	    _e.printStackTrace();
	}

    }

    /**
     * Method 'findWherePictEquals'
     * 
     * @param pict
     */
    public static void findWherePictEquals(byte[] pict) {
	try {
	    ProfileDao _dao = getProfileDao();
	    Profile _result[] = _dao.findWherePictEquals(pict);
	    for (int i = 0; i < _result.length; i++) {
		display(_result[i]);
	    }

	} catch (Exception _e) {
	    _e.printStackTrace();
	}

    }

    /**
     * Method 'findWhereIntrodEquals'
     * 
     * @param introd
     */
    public static void findWhereIntrodEquals(String introd) {
	try {
	    ProfileDao _dao = getProfileDao();
	    Profile _result[] = _dao.findWhereIntrodEquals(introd);
	    for (int i = 0; i < _result.length; i++) {
		display(_result[i]);
	    }

	} catch (Exception _e) {
	    _e.printStackTrace();
	}

    }

    /**
     * Method 'findWhereHobbyEquals'
     * 
     * @param hobby
     */
    public static void findWhereHobbyEquals(String hobby) {
	try {
	    ProfileDao _dao = getProfileDao();
	    Profile _result[] = _dao.findWhereHobbyEquals(hobby);
	    for (int i = 0; i < _result.length; i++) {
		display(_result[i]);
	    }

	} catch (Exception _e) {
	    _e.printStackTrace();
	}

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
