package ua.bionichill.socialnetwork.example;

import ua.bionichill.socialnetwork.dao.UTypeDao;
import ua.bionichill.socialnetwork.dto.UType;
import ua.bionichill.socialnetwork.factory.UTypeDaoFactory;

public class UTypeDaoSample {
    /**
     * Method 'main'
     * 
     * @param arg
     * @throws Exception
     */
    public static void main(String[] arg) throws Exception {
	// Uncomment one of the lines below to test the generated code

	findAll();
	// findWhereUTypeEquals("");
    }

    /**
     * Method 'findAll'
     * 
     */
    public static void findAll() {
	try {
	    UTypeDao _dao = getUTypeDao();
	    UType _result[] = _dao.findAll();
	    for (int i = 0; i < _result.length; i++) {
		display(_result[i]);
	    }

	} catch (Exception _e) {
	    _e.printStackTrace();
	}

    }

    /**
     * Method 'findWhereUTypeEquals'
     * 
     * @param uType
     */
    public static void findWhereUTypeEquals(String uType) {
	try {
	    UTypeDao _dao = getUTypeDao();
	    UType _result[] = _dao.findWhereUTypeEquals(uType);
	    for (int i = 0; i < _result.length; i++) {
		display(_result[i]);
	    }

	} catch (Exception _e) {
	    _e.printStackTrace();
	}

    }

    /**
     * Method 'getUTypeDao'
     * 
     * @return UTypeDao
     */
    public static UTypeDao getUTypeDao() {
	return UTypeDaoFactory.create();
    }

    /**
     * Method 'display'
     * 
     * @param dto
     */
    public static void display(UType dto) {
	StringBuffer buf = new StringBuffer();
	buf.append(dto.getUType());
	System.out.println(buf.toString());
    }

}
