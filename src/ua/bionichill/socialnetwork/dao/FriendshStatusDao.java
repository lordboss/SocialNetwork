package ua.bionichill.socialnetwork.dao;

import ua.bionichill.socialnetwork.dto.FriendshStatus;
import ua.bionichill.socialnetwork.dto.FriendshStatusPk;
import ua.bionichill.socialnetwork.exceptions.FriendshStatusDaoException;

public interface FriendshStatusDao {
    /**
     * Inserts a new row in the friendshstatus table.
     */
    public FriendshStatusPk insert(FriendshStatus dto)
	    throws FriendshStatusDaoException;

    /**
     * Updates a single row in the friendshstatus table.
     */
    public void update(FriendshStatusPk pk, FriendshStatus dto)
	    throws FriendshStatusDaoException;

    /**
     * Deletes a single row in the friendshstatus table.
     */
    public void delete(FriendshStatusPk pk) throws FriendshStatusDaoException;

    /**
     * Returns the rows from the friendshstatus table that matches the specified
     * primary-key value.
     */
    public FriendshStatus findByPrimaryKey(FriendshStatusPk pk)
	    throws FriendshStatusDaoException;

    /**
     * Returns all rows from the friendshstatus table that match the criteria
     * 'friendshstatus = :friendshStatus'.
     */
    public FriendshStatus findByPrimaryKey(String friendshStatus)
	    throws FriendshStatusDaoException;

    /**
     * Returns all rows from the friendshstatus table that match the criteria
     * ''.
     */
    public FriendshStatus[] findAll() throws FriendshStatusDaoException;

    /**
     * Returns all rows from the friendshstatus table that match the criteria
     * 'friendshStatus = :friendshStatus'.
     */
    public FriendshStatus[] findWhereFriendshStatusEquals(String friendshStatus)
	    throws FriendshStatusDaoException;

    /**
     * Sets the value of maxRows
     */
    public void setMaxRows(int maxRows);

    /**
     * Gets the value of maxRows
     */
    public int getMaxRows();

    /**
     * Returns all rows from the friendshstatus table that match the specified
     * arbitrary SQL statement
     */
    public FriendshStatus[] findByDynamicSelect(String sql, Object[] sqlParams)
	    throws FriendshStatusDaoException;

    /**
     * Returns all rows from the friendshstatus table that match the specified
     * arbitrary SQL statement
     */
    public FriendshStatus[] findByDynamicWhere(String sql, Object[] sqlParams)
	    throws FriendshStatusDaoException;

}
