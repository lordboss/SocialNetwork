package ua.bionichill.socialnetwork.dto;

import java.io.Serializable;

public class Profile implements Serializable {

    public enum Sex {
	MALE, FEMALE, NONE
    }

    /**
     * This attribute maps to the column idprofile in the profile table.
     */
    private Integer idProfile;

    /**
     * This attribute maps to the column fname in the profile table.
     */
    private String fName;

    /**
     * This attribute maps to the column surname in the profile table.
     */
    private String surName;

    /**
     * This attribute maps to the column sex in the profile table.
     */
    private Sex sex;

    /**
     * This attribute maps to the column pict in the profile table.
     */
    private byte[] pict;

    /**
     * This attribute maps to the column introd in the profile table.
     */
    private String introd;

    /**
     * This attribute maps to the column hobby in the profile table.
     */
    private String hobby;

    /**
     * default constructor for 'Profile'
     * 
     */
    public Profile() {
    }

    /**
     * Method 'getIdProfile'
     * 
     * @return Integer
     */
    public Integer getIdProfile() {
	return idProfile;
    }

    /**
     * Method 'setIdProfile'
     * 
     * @param idProfile
     */
    public void setIdProfile(Integer idProfile) {
	this.idProfile = idProfile;
    }

    /**
     * Method 'getFName'
     * 
     * @return String
     */
    public String getFName() {
	return fName;
    }

    /**
     * Method 'setFName'
     * 
     * @param fName
     */
    public void setFName(String fName) {
	this.fName = fName;
    }

    /**
     * Method 'getSurName'
     * 
     * @return String
     */
    public String getSurName() {
	return surName;
    }

    /**
     * Method 'setSurName'
     * 
     * @param surName
     */
    public void setSurName(String surName) {
	this.surName = surName;
    }

    /**
     * Method 'getSex'
     * 
     * @return Sex
     */
    public Sex getSex() {
	return sex;
    }

    /**
     * Method 'setSex'
     * 
     * @param sex
     */
    public void setSex(Sex sex) {
	this.sex = sex;
    }

    /**
     * Method 'setSex'
     * 
     * @param sex
     */
    public void setSex(String sex) {
	this.sex = Sex.valueOf(sex);
    }

    /**
     * Method 'getPict'
     * 
     * @return byte[]
     */
    public byte[] getPict() {
	return pict;
    }

    /**
     * Method 'setPict'
     * 
     * @param pict
     */
    public void setPict(byte[] pict) {
	this.pict = pict;
    }

    /**
     * Method 'getIntrod'
     * 
     * @return String
     */
    public String getIntrod() {
	return introd;
    }

    /**
     * Method 'setIntrod'
     * 
     * @param introd
     */
    public void setIntrod(String introd) {
	this.introd = introd;
    }

    /**
     * Method 'getHobby'
     * 
     * @return String
     */
    public String getHobby() {
	return hobby;
    }

    /**
     * Method 'setHobby'
     * 
     * @param hobby
     */
    public void setHobby(String hobby) {
	this.hobby = hobby;
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

	if (!(_other instanceof Profile)) {
	    return false;
	}

	final Profile _cast = (Profile) _other;
	if (idProfile == null ? _cast.idProfile != idProfile : !idProfile
		.equals(_cast.idProfile)) {
	    return false;
	}

	if (fName == null ? _cast.fName != fName : !fName.equals(_cast.fName)) {
	    return false;
	}

	if (surName == null ? _cast.surName != surName : !surName
		.equals(_cast.surName)) {
	    return false;
	}

	if (sex == null ? _cast.sex != sex : !sex.equals(_cast.sex)) {
	    return false;
	}

	if (pict == null ? _cast.pict != pict : !pict.equals(_cast.pict)) {
	    return false;
	}

	if (introd == null ? _cast.introd != introd : !introd
		.equals(_cast.introd)) {
	    return false;
	}

	if (hobby == null ? _cast.hobby != hobby : !hobby.equals(_cast.hobby)) {
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
	if (idProfile != null) {
	    _hashCode = 29 * _hashCode + idProfile.hashCode();
	}

	if (fName != null) {
	    _hashCode = 29 * _hashCode + fName.hashCode();
	}

	if (surName != null) {
	    _hashCode = 29 * _hashCode + surName.hashCode();
	}

	if (sex != null) {
	    _hashCode = 29 * _hashCode + sex.hashCode();
	}

	if (pict != null) {
	    _hashCode = 29 * _hashCode + pict.hashCode();
	}

	if (introd != null) {
	    _hashCode = 29 * _hashCode + introd.hashCode();
	}

	if (hobby != null) {
	    _hashCode = 29 * _hashCode + hobby.hashCode();
	}

	return _hashCode;
    }

    /**
     * Method 'createPk'
     * 
     * @return ProfilePk
     */
    public ProfilePk createPk() {
	return new ProfilePk(idProfile);
    }

    /**
     * Method 'toString'
     * 
     * @return String
     */
    public String toString() {
	StringBuffer ret = new StringBuffer();
	ret.append("ua.bionichill.socialnetwork.dto.Profile: ");
	ret.append("idProfile=" + idProfile);
	ret.append(", fName=" + fName);
	ret.append(", surName=" + surName);
	ret.append(", sex=" + sex);
	ret.append(", pict=" + pict);
	ret.append(", introd=" + introd);
	ret.append(", hobby=" + hobby);
	return ret.toString();
    }

}
