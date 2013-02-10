package ua.bionichill.socialnetwork.dao;

import ua.bionichill.socialnetwork.dto.Profile;
import ua.bionichill.socialnetwork.dto.ProfilePk;
import ua.bionichill.socialnetwork.exceptions.ProfileDaoException;

public interface ProfileDao {
    /**
     * Inserts a new row in the profile table.
     */
    public ProfilePk insert(Profile dto) throws ProfileDaoException;

    /**
     * Updates a single row in the profile table.
     */
    public void update(ProfilePk pk, Profile dto) throws ProfileDaoException;

    /**
     * Deletes a single row in the profile table.
     */
    public void delete(ProfilePk pk) throws ProfileDaoException;

    /**
     * Returns the rows from the profile table that matches the specified
     * primary-key value.
     */
    public Profile findByPrimaryKey(ProfilePk pk) throws ProfileDaoException;

    /**
     * Returns all rows from the profile table that match the criteria
     * 'idprofile = :idProfile'.
     */
    public Profile findByPrimaryKey(Integer idProfile)
	    throws ProfileDaoException;

    /**
     * Returns all rows from the profile table that match the criteria ''.
     */
    public Profile[] findAll() throws ProfileDaoException;

    /**
     * Returns all rows from the profile table that match the criteria
     * 'idProfile = :idProfile'.
     */
    public Profile[] findWhereIdProfileEquals(Integer idProfile)
	    throws ProfileDaoException;

    /**
     * Returns all rows from the profile table that match the criteria 'fName =
     * :fName'.
     */
    public Profile[] findWhereFNameEquals(String fName)
	    throws ProfileDaoException;

    /**
     * Returns all rows from the profile table that match the criteria 'surName
     * = :surName'.
     */
    public Profile[] findWhereSurNameEquals(String surName)
	    throws ProfileDaoException;

    /**
     * Returns all rows from the profile table that match the criteria 'sex =
     * :sex'.
     */
    public Profile[] findWhereSexEquals(String sex) throws ProfileDaoException;

    /**
     * Returns all rows from the profile table that match the criteria 'pict =
     * :pict'.
     */
    public Profile[] findWherePictEquals(byte[] pict)
	    throws ProfileDaoException;

    /**
     * Returns all rows from the profile table that match the criteria 'introd =
     * :introd'.
     */
    public Profile[] findWhereIntrodEquals(String introd)
	    throws ProfileDaoException;

    /**
     * Returns all rows from the profile table that match the criteria 'hobby =
     * :hobby'.
     */
    public Profile[] findWhereHobbyEquals(String hobby)
	    throws ProfileDaoException;

    /**
     * Sets the value of maxRows
     */
    public void setMaxRows(int maxRows);

    /**
     * Gets the value of maxRows
     */
    public int getMaxRows();

    /**
     * Returns all rows from the profile table that match the specified
     * arbitrary SQL statement
     */
    public Profile[] findByDynamicSelect(String sql, Object[] sqlParams)
	    throws ProfileDaoException;

    /**
     * Returns all rows from the profile table that match the specified
     * arbitrary SQL statement
     */
    public Profile[] findByDynamicWhere(String sql, Object[] sqlParams)
	    throws ProfileDaoException;

}
