package ua.bionichill.socialnetwork.dto;

import java.io.Serializable;

/**
 * This class represents the primary key of the utype table.
 */
public class UTypePk implements Serializable {
    protected String uType;

    /**
     * Sets the value of uType
     */
    public void setUType(String uType) {
	this.uType = uType;
    }

    /**
     * Gets the value of uType
     */
    public String getUType() {
	return uType;
    }

    /**
     * Method 'UTypePk'
     * 
     */
    public UTypePk() {
    }

    /**
     * Method 'UTypePk'
     * 
     * @param uType
     */
    public UTypePk(final String uType) {
	this.uType = uType;
    }

    /**
     * Method 'equals'
     * 
     * @param _other
     * @return boolean
     */
    public boolean equals(Object _other) {
	if (_other == null) {
	    return false;
	}

	if (_other == this) {
	    return true;
	}

	if (!(_other instanceof UTypePk)) {
	    return false;
	}

	final UTypePk _cast = (UTypePk) _other;
	if (uType == null ? _cast.uType != uType : !uType.equals(_cast.uType)) {
	    return false;
	}

	return true;
    }

    /**
     * Method 'hashCode'
     * 
     * @return int
     */
    public int hashCode() {
	int _hashCode = 0;
	if (uType != null) {
	    _hashCode = 29 * _hashCode + uType.hashCode();
	}

	return _hashCode;
    }

    /**
     * Method 'toString'
     * 
     * @return String
     */
    public String toString() {
	StringBuffer ret = new StringBuffer();
	ret.append("ua.bionichill.socialnetwork.dto.UTypePk: ");
	ret.append("uType=" + uType);
	return ret.toString();
    }

}
