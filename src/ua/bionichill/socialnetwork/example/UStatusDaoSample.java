package ua.bionichill.socialnetwork.example;

import ua.bionichill.socialnetwork.dao.UStatusDao;
import ua.bionichill.socialnetwork.dto.UStatus;
import ua.bionichill.socialnetwork.factory.UStatusDaoFactory;

public class UStatusDaoSample {
    /**
     * Method 'main'
     * 
     * @param arg
     * @throws Exception
     */
    public static void main(String[] arg) throws Exception {
	// Uncomment one of the lines below to test the generated code

	// findAll();
	// findWhereUStatusEquals("");
    }

    /**
     * Method 'findAll'
     * 
     */
    public static void findAll() {
	try {
	    UStatusDao _dao = getUStatusDao();
	    UStatus _result[] = _dao.findAll();
	    for (int i = 0; i < _result.length; i++) {
		display(_result[i]);
	    }

	} catch (Exception _e) {
	    _e.printStackTrace();
	}

    }

    /**
     * Method 'findWhereUStatusEquals'
     * 
     * @param uStatus
     */
    public static void findWhereUStatusEquals(String uStatus) {
	try {
	    UStatusDao _dao = getUStatusDao();
	    UStatus _result[] = _dao.findWhereUStatusEquals(uStatus);
	    for (int i = 0; i < _result.length; i++) {
		display(_result[i]);
	    }

	} catch (Exception _e) {
	    _e.printStackTrace();
	}

    }

    /**
     * Method 'getUStatusDao'
     * 
     * @return UStatusDao
     */
    public static UStatusDao getUStatusDao() {
	return UStatusDaoFactory.create();
    }

    /**
     * Method 'display'
     * 
     * @param dto
     */
    public static void display(UStatus dto) {
	StringBuffer buf = new StringBuffer();
	buf.append(dto.getUStatus());
	System.out.println(buf.toString());
    }

}
