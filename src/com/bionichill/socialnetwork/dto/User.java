package com.bionichill.socialnetwork.dto;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    /**
     * This attribute maps to the column email in the user table.
     */
    private String email;

    /**
     * This attribute maps to the column passw in the user table.
     */
    private String passw;

    /**
     * This attribute maps to the column typeu in the user table.
     */
    private UType typeU;

    /**
     * This attribute maps to the column statusu in the user table.
     */
    private UStatus statusU;

    /**
     * This attribute maps to the column profileid in the user table.
     */
    private Profile profile;

    /**
     * This attribute maps to the column registrdate in the user table.
     */
    private Date registrDate;

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
     * @return UType
     */
    public UType getTypeU() {
	return typeU;
    }

    /**
     * Method 'setTypeU'
     * 
     * @param typeU
     */
    public void setTypeU(UType typeU) {
	this.typeU = typeU;
    }

    /**
     * Method 'getStatusU'
     * 
     * @return UStatus
     */
    public UStatus getStatusU() {
	return statusU;
    }

    /**
     * Method 'setStatusU'
     * 
     * @param statusU
     */
    public void setStatusU(UStatus statusU) {
	this.statusU = statusU;
    }

    /**
     * Method 'getProfile'
     * 
     * @return Profile
     */
    public Profile getProfile() {
	return profile;
    }

    /**
     * Method 'setProfile'
     * 
     * @param profile
     */
    public void setProfile(Profile profile) {
	this.profile = profile;
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

	if (profile == null ? _cast.profile != profile : !profile
		.equals(_cast.profile)) {
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

	if (profile != null) {
	    _hashCode = 29 * _hashCode + profile.hashCode();
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
	ret.append(", typeU=" + typeU.toString());
	ret.append(", statusU=" + statusU.toString());
	ret.append(", profile=" + profile.toString());
	ret.append(", registrDate=" + registrDate);
	return ret.toString();
    }

}
