package ua.bionichill.socialnetwork.dao;

import java.util.Date;

import ua.bionichill.socialnetwork.dto.User;
import ua.bionichill.socialnetwork.dto.UserPk;
import ua.bionichill.socialnetwork.exceptions.UserDaoException;

public interface UserDao {
    /**
     * Inserts a new row in the user table.
     */
    public UserPk insert(User dto) throws UserDaoException;

    /**
     * Updates a single row in the user table.
     */
    public void update(UserPk pk, User dto) throws UserDaoException;

    /**
     * Deletes a single row in the user table.
     */
    public void delete(UserPk pk) throws UserDaoException;

    /**
     * Returns the rows from the user table that matches the specified
     * primary-key value.
     */
    public User findByPrimaryKey(UserPk pk) throws UserDaoException;

    /**
     * Returns all rows from the user table that match the criteria 'email =
     * :email'.
     */
    public User findByPrimaryKey(String email) throws UserDaoException;

    /**
     * Returns all rows from the user table that match the criteria ''.
     */
    public User[] findAll() throws UserDaoException;

    /**
     * Returns all rows from the user table that match the criteria 'profileId =
     * :profileId'.
     */
    public User[] findByProfile(Integer profileId) throws UserDaoException;

    /**
     * Returns all rows from the user table that match the criteria 'statusU =
     * :statusU'.
     */
    public User[] findByUStatus(String statusU) throws UserDaoException;

    /**
     * Returns all rows from the user table that match the criteria 'typeU =
     * :typeU'.
     */
    public User[] findByUType(String typeU) throws UserDaoException;

    /**
     * Returns all rows from the user table that match the criteria 'email =
     * :email'.
     */
    public User[] findWhereEmailEquals(String email) throws UserDaoException;

    /**
     * Returns all rows from the user table that match the criteria 'passw =
     * :passw'.
     */
    public User[] findWherePasswEquals(String passw) throws UserDaoException;

    /**
     * Returns all rows from the user table that match the criteria 'typeU =
     * :typeU'.
     */
    public User[] findWhereTypeUEquals(String typeU) throws UserDaoException;

    /**
     * Returns all rows from the user table that match the criteria 'statusU =
     * :statusU'.
     */
    public User[] findWhereStatusUEquals(String statusU)
	    throws UserDaoException;

    /**
     * Returns all rows from the user table that match the criteria 'profileId =
     * :profileId'.
     */
    public User[] findWhereProfileIdEquals(Integer profileId)
	    throws UserDaoException;

    /**
     * Returns all rows from the user table that match the criteria 'registrDate
     * = :registrDate'.
     */
    public User[] findWhereRegistrDateEquals(Date registrDate)
	    throws UserDaoException;

    /**
     * Sets the value of maxRows
     */
    public void setMaxRows(int maxRows);

    /**
     * Gets the value of maxRows
     */
    public int getMaxRows();

    /**
     * Returns all rows from the user table that match the specified arbitrary
     * SQL statement
     */
    public User[] findByDynamicSelect(String sql, Object[] sqlParams)
	    throws UserDaoException;

    /**
     * Returns all rows from the user table that match the specified arbitrary
     * SQL statement
     */
    public User[] findByDynamicWhere(String sql, Object[] sqlParams)
	    throws UserDaoException;

}
