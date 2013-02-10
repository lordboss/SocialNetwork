package ua.bionichill.socialnetwork.dto;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    /**
     * This attribute maps to the column email in the user table.
     */
    protected String email;

    /**
     * This attribute maps to the column passw in the user table.
     */
    protected String passw;

    /**
     * This attribute maps to the column typeu in the user table.
     */
    protected String typeU;

    /**
     * This attribute maps to the column statusu in the user table.
     */
    protected String statusU;

    /**
     * This attribute maps to the column profileid in the user table.
     */
    protected Integer profileId;

    /**
     * This attribute maps to the column registrdate in the user table.
     */
    protected Date registrDate;

    /**
     * Method 'User'
     * 
     */
    public User() {
    }

    /**
     * Method 'getEmail'
     * 
     * @return String
     */
    public String getEmail() {
	return email;
    }

    /**
     * Method 'setEmail'
     * 
     * @param email
     */
    public void setEmail(String email) {
	this.email = email;
    }

    /**
     * Method 'getPassw'
     * 
     * @return String
     */
    public String getPassw() {
	return passw;
    }

    /**
     * Method 'setPassw'
     * 
     * @param passw
     */
    public void setPassw(String passw) {
	this.passw = passw;
    }

    /**
     * Method 'getTypeU'
     * 
     * @return String
     */
    public String getTypeU() {
	return typeU;
    }

    /**
     * Method 'setTypeU'
     * 
     * @param typeU
     */
    public void setTypeU(String typeU) {
	this.typeU = typeU;
    }

    /**
     * Method 'getStatusU'
     * 
     * @return String
     */
    public String getStatusU() {
	return statusU;
    }

    /**
     * Method 'setStatusU'
     * 
     * @param statusU
     */
    public void setStatusU(String statusU) {
	this.statusU = statusU;
    }

    /**
     * Method 'getProfileId'
     * 
     * @return Integer
     */
    public Integer getProfileId() {
	return profileId;
    }

    /**
     * Method 'setProfileId'
     * 
     * @param profileId
     */
    public void setProfileId(Integer profileId) {
	this.profileId = profileId;
    }

    /**
     * Method 'getRegistrDate'
     * 
     * @return Date
     */
    public Date getRegistrDate() {
	return registrDate;
    }

    /**
     * Method 'setRegistrDate'
     * 
     * @param registrDate
     */
    public void setRegistrDate(Date registrDate) {
	this.registrDate = registrDate;
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

	if (!(_other instanceof User)) {
	    return false;
	}

	final User _cast = (User) _other;
	if (email == null ? _cast.email != email : !email.equals(_cast.email)) {
	    return false;
	}

	if (passw == null ? _cast.passw != passw : !passw.equals(_cast.passw)) {
	    return false;
	}

	if (typeU == null ? _cast.typeU != typeU : !typeU.equals(_cast.typeU)) {
	    return false;
	}

	if (statusU == null ? _cast.statusU != statusU : !statusU
		.equals(_cast.statusU)) {
	    return false;
	}

	if (profileId == null ? _cast.profileId != profileId : !profileId
		.equals(_cast.profileId)) {
	    return false;
	}

	if (registrDate == null ? _cast.registrDate != registrDate
		: !registrDate.equals(_cast.registrDate)) {
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
	if (email != null) {
	    _hashCode = 29 * _hashCode + email.hashCode();
	}

	if (passw != null) {
	    _hashCode = 29 * _hashCode + passw.hashCode();
	}

	if (typeU != null) {
	    _hashCode = 29 * _hashCode + typeU.hashCode();
	}

	if (statusU != null) {
	    _hashCode = 29 * _hashCode + statusU.hashCode();
	}

	if (profileId != null) {
	    _hashCode = 29 * _hashCode + profileId.hashCode();
	}

	if (registrDate != null) {
	    _hashCode = 29 * _hashCode + registrDate.hashCode();
	}

	return _hashCode;
    }

    /**
     * Method 'createPk'
     * 
     * @return UserPk
     */
    public UserPk createPk() {
	return new UserPk(email);
    }

    /**
     * Method 'toString'
     * 
     * @return String
     */
    public String toString() {
	StringBuffer ret = new StringBuffer();
	ret.append("ua.bionichill.socialnetwork.dto.User: ");
	ret.append("email=" + email);
	ret.append(", passw=" + passw);
	ret.append(", typeU=" + typeU);
	ret.append(", statusU=" + statusU);
	ret.append(", profileId=" + profileId);
	ret.append(", registrDate=" + registrDate);
	return ret.toString();
    }

}
