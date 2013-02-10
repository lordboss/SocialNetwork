package ua.bionichill.socialnetwork.dao;

import ua.bionichill.socialnetwork.dto.MsgType;
import ua.bionichill.socialnetwork.dto.MsgTypePk;
import ua.bionichill.socialnetwork.exceptions.MsgTypeDaoException;

public interface MsgTypeDao {
    /**
     * Inserts a new row in the msgtype table.
     */
    public MsgTypePk insert(MsgType dto) throws MsgTypeDaoException;

    /**
     * Updates a single row in the msgtype table.
     */
    public void update(MsgTypePk pk, MsgType dto) throws MsgTypeDaoException;

    /**
     * Deletes a single row in the msgtype table.
     */
    public void delete(MsgTypePk pk) throws MsgTypeDaoException;

    /**
     * Returns the rows from the msgtype table that matches the specified
     * primary-key value.
     */
    public MsgType findByPrimaryKey(MsgTypePk pk) throws MsgTypeDaoException;

    /**
     * Returns all rows from the msgtype table that match the criteria 'msgtype
     * = :msgType'.
     */
    public MsgType findByPrimaryKey(String msgType) throws MsgTypeDaoException;

    /**
     * Returns all rows from the msgtype table that match the criteria ''.
     */
    public MsgType[] findAll() throws MsgTypeDaoException;

    /**
     * Returns all rows from the msgtype table that match the criteria 'msgType
     * = :msgType'.
     */
    public MsgType[] findWhereMsgTypeEquals(String msgType)
	    throws MsgTypeDaoException;

    /**
     * Sets the value of maxRows
     */
    public void setMaxRows(int maxRows);

    /**
     * Gets the value of maxRows
     */
    public int getMaxRows();

    /**
     * Returns all rows from the msgtype table that match the specified
     * arbitrary SQL statement
     */
    public MsgType[] findByDynamicSelect(String sql, Object[] sqlParams)
	    throws MsgTypeDaoException;

    /**
     * Returns all rows from the msgtype table that match the specified
     * arbitrary SQL statement
     */
    public MsgType[] findByDynamicWhere(String sql, Object[] sqlParams)
	    throws MsgTypeDaoException;

}
