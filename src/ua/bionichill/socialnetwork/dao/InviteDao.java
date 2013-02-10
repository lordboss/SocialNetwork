package ua.bionichill.socialnetwork.dao;

import java.util.Date;

import ua.bionichill.socialnetwork.dto.Invite;
import ua.bionichill.socialnetwork.dto.InvitePk;
import ua.bionichill.socialnetwork.exceptions.InviteDaoException;

public interface InviteDao {
    /**
     * Inserts a new row in the invite table.
     */
    public InvitePk insert(Invite dto) throws InviteDaoException;

    /**
     * Updates a single row in the invite table.
     */
    public void update(InvitePk pk, Invite dto) throws InviteDaoException;

    /**
     * Deletes a single row in the invite table.
     */
    public void delete(InvitePk pk) throws InviteDaoException;

    /**
     * Returns the rows from the invite table that matches the specified
     * primary-key value.
     */
    public Invite findByPrimaryKey(InvitePk pk) throws InviteDaoException;

    /**
     * Returns all rows from the invite table that match the criteria 'idinvite
     * = :idInvite'.
     */
    public Invite findByPrimaryKey(Integer idInvite) throws InviteDaoException;

    /**
     * Returns all rows from the invite table that match the criteria ''.
     */
    public Invite[] findAll() throws InviteDaoException;

    /**
     * Returns all rows from the invite table that match the criteria 'inviter =
     * :inviter'.
     */
    public Invite[] findByInviter(String inviter) throws InviteDaoException;

    /**
     * Returns all rows from the invite table that match the criteria 'invitee =
     * :invitee'.
     */
    public Invite[] findByInvitee(String invitee) throws InviteDaoException;

    /**
     * Returns all rows from the invite table that match the criteria 'res =
     * :res'.
     */
    public Invite[] findByInviteRes(String res) throws InviteDaoException;

    /**
     * Returns all rows from the invite table that match the criteria 'idInvite
     * = :idInvite'.
     */
    public Invite[] findWhereIdInviteEquals(Integer idInvite)
	    throws InviteDaoException;

    /**
     * Returns all rows from the invite table that match the criteria 'inviter =
     * :inviter'.
     */
    public Invite[] findWhereInviterEquals(String inviter)
	    throws InviteDaoException;

    /**
     * Returns all rows from the invite table that match the criteria 'invitee =
     * :invitee'.
     */
    public Invite[] findWhereInviteeEquals(String invitee)
	    throws InviteDaoException;

    /**
     * Returns all rows from the invite table that match the criteria 'res =
     * :res'.
     */
    public Invite[] findWhereResEquals(String res) throws InviteDaoException;

    /**
     * Returns all rows from the invite table that match the criteria
     * 'inviteDate = :inviteDate'.
     */
    public Invite[] findWhereInviteDateEquals(Date inviteDate)
	    throws InviteDaoException;

    /**
     * Sets the value of maxRows
     */
    public void setMaxRows(int maxRows);

    /**
     * Gets the value of maxRows
     */
    public int getMaxRows();

    /**
     * Returns all rows from the invite table that match the specified arbitrary
     * SQL statement
     */
    public Invite[] findByDynamicSelect(String sql, Object[] sqlParams)
	    throws InviteDaoException;

    /**
     * Returns all rows from the invite table that match the specified arbitrary
     * SQL statement
     */
    public Invite[] findByDynamicWhere(String sql, Object[] sqlParams)
	    throws InviteDaoException;

}
