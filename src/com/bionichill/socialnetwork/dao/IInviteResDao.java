package com.bionichill.socialnetwork.dao;

import com.bionichill.socialnetwork.dto.InviteRes;
import com.bionichill.socialnetwork.dto.InviteResPk;
import com.bionichill.socialnetwork.exceptions.InviteResDaoException;


public interface IInviteResDao {
    /**
     * Inserts a new row in the inviteres table.
     */
    public InviteResPk insert(InviteRes dto) throws InviteResDaoException;

    /**
     * Updates a single row in the inviteres table.
     */
    public void update(InviteResPk pk, InviteRes dto)
	    throws InviteResDaoException;

    /**
     * Deletes a single row in the inviteres table.
     */
    public void delete(InviteResPk pk) throws InviteResDaoException;

    /**
     * Returns the rows from the inviteres table that matches the specified
     * primary-key value.
     */
    public InviteRes findByPrimaryKey(InviteResPk pk)
	    throws InviteResDaoException;

    /**
     * Returns all rows from the inviteres table that match the criteria
     * 'inviteres = :inviteRes'.
     */
    public InviteRes findByPrimaryKey(String inviteRes)
	    throws InviteResDaoException;

    /**
     * Returns all rows from the inviteres table that match the criteria ''.
     */
    public InviteRes[] findAll() throws InviteResDaoException;

    /**
     * Returns all rows from the inviteres table that match the criteria
     * 'inviteRes = :inviteRes'.
     */
    public InviteRes[] findWhereInviteResEquals(String inviteRes)
	    throws InviteResDaoException;

    /**
     * Sets the value of maxRows
     */
    public void setMaxRows(int maxRows);

    /**
     * Gets the value of maxRows
     */
    public int getMaxRows();

    /**
     * Returns all rows from the inviteres table that match the specified
     * arbitrary SQL statement
     */
    public InviteRes[] findByDynamicSelect(String sql, Object[] sqlParams)
	    throws InviteResDaoException;

    /**
     * Returns all rows from the inviteres table that match the specified
     * arbitrary SQL statement
     */
    public InviteRes[] findByDynamicWhere(String sql, Object[] sqlParams)
	    throws InviteResDaoException;

}
