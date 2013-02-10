package ua.bionichill.socialnetwork.dao;

import java.util.Date;

import ua.bionichill.socialnetwork.dto.Friendsh;
import ua.bionichill.socialnetwork.dto.FriendshPk;
import ua.bionichill.socialnetwork.exceptions.FriendshDaoException;

public interface FriendshDao {
    /**
     * Inserts a new row in the friendsh table.
     */
    public FriendshPk insert(Friendsh dto) throws FriendshDaoException;

    /**
     * Updates a single row in the friendsh table.
     */
    public void update(FriendshPk pk, Friendsh dto) throws FriendshDaoException;

    /**
     * Deletes a single row in the friendsh table.
     */
    public void delete(FriendshPk pk) throws FriendshDaoException;

    /**
     * Returns the rows from the friendsh table that matches the specified
     * primary-key value.
     */
    public Friendsh findByPrimaryKey(FriendshPk pk) throws FriendshDaoException;

    /**
     * Returns all rows from the friendsh table that match the criteria
     * 'idfriendsh = :idFriendsh'.
     */
    public Friendsh findByPrimaryKey(Integer idFriendsh)
	    throws FriendshDaoException;

    /**
     * Returns all rows from the friendsh table that match the criteria ''.
     */
    public Friendsh[] findAll() throws FriendshDaoException;

    /**
     * Returns all rows from the friendsh table that match the criteria
     * 'inviteId = :inviteId'.
     */
    public Friendsh[] findByInvite(Integer inviteId)
	    throws FriendshDaoException;

    /**
     * Returns all rows from the friendsh table that match the criteria
     * 'statusFriendsh = :statusFriendsh'.
     */
    public Friendsh[] findByFriendshStatus(String statusFriendsh)
	    throws FriendshDaoException;

    /**
     * Returns all rows from the friendsh table that match the criteria
     * 'friendFrom = :friendFrom'.
     */
    public Friendsh[] findByFriendFrom(String friendFrom)
	    throws FriendshDaoException;

    /**
     * Returns all rows from the friendsh table that match the criteria
     * 'friendTo = :friendTo'.
     */
    public Friendsh[] findByFriendTo(String friendTo)
	    throws FriendshDaoException;

    /**
     * Returns all rows from the friendsh table that match the criteria
     * 'idFriendsh = :idFriendsh'.
     */
    public Friendsh[] findWhereIdFriendshEquals(Integer idFriendsh)
	    throws FriendshDaoException;

    /**
     * Returns all rows from the friendsh table that match the criteria
     * 'friendFrom = :friendFrom'.
     */
    public Friendsh[] findWhereFriendFromEquals(String friendFrom)
	    throws FriendshDaoException;

    /**
     * Returns all rows from the friendsh table that match the criteria
     * 'friendTo = :friendTo'.
     */
    public Friendsh[] findWhereFriendToEquals(String friendTo)
	    throws FriendshDaoException;

    /**
     * Returns all rows from the friendsh table that match the criteria
     * 'statusFriendsh = :statusFriendsh'.
     */
    public Friendsh[] findWhereStatusFriendshEquals(String statusFriendsh)
	    throws FriendshDaoException;

    /**
     * Returns all rows from the friendsh table that match the criteria
     * 'inviteId = :inviteId'.
     */
    public Friendsh[] findWhereInviteIdEquals(Integer inviteId)
	    throws FriendshDaoException;

    /**
     * Returns all rows from the friendsh table that match the criteria
     * 'friendshDate = :friendshDate'.
     */
    public Friendsh[] findWhereFriendshDateEquals(Date friendshDate)
	    throws FriendshDaoException;

    /**
     * Sets the value of maxRows
     */
    public void setMaxRows(int maxRows);

    /**
     * Gets the value of maxRows
     */
    public int getMaxRows();

    /**
     * Returns all rows from the friendsh table that match the specified
     * arbitrary SQL statement
     */
    public Friendsh[] findByDynamicSelect(String sql, Object[] sqlParams)
	    throws FriendshDaoException;

    /**
     * Returns all rows from the friendsh table that match the specified
     * arbitrary SQL statement
     */
    public Friendsh[] findByDynamicWhere(String sql, Object[] sqlParams)
	    throws FriendshDaoException;

}
