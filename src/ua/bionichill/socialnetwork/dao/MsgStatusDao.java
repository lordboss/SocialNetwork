package ua.bionichill.socialnetwork.dao;

import ua.bionichill.socialnetwork.dto.MsgStatus;
import ua.bionichill.socialnetwork.dto.MsgStatusPk;
import ua.bionichill.socialnetwork.exceptions.MsgStatusDaoException;

public interface MsgStatusDao {
    /**
     * Inserts a new row in the msgstatus table.
     */
    public MsgStatusPk insert(MsgStatus dto) throws MsgStatusDaoException;

    /**
     * Updates a single row in the msgstatus table.
     */
    public void update(MsgStatusPk pk, MsgStatus dto)
	    throws MsgStatusDaoException;

    /**
     * Deletes a single row in the msgstatus table.
     */
    public void delete(MsgStatusPk pk) throws MsgStatusDaoException;

    /**
     * Returns the rows from the msgstatus table that matches the specified
     * primary-key value.
     */
    public MsgStatus findByPrimaryKey(MsgStatusPk pk)
	    throws MsgStatusDaoException;

    /**
     * Returns all rows from the msgstatus table that match the criteria
     * 'msgstatus = :msgStatus'.
     */
    public MsgStatus findByPrimaryKey(String msgStatus)
	    throws MsgStatusDaoException;

    /**
     * Returns all rows from the msgstatus table that match the criteria ''.
     */
    public MsgStatus[] findAll() throws MsgStatusDaoException;

    /**
     * Returns all rows from the msgstatus table that match the criteria
     * 'msgStatus = :msgStatus'.
     */
    public MsgStatus[] findWhereMsgStatusEquals(String msgStatus)
	    throws MsgStatusDaoException;

    /**
     * Sets the value of maxRows
     */
    public void setMaxRows(int maxRows);

    /**
     * Gets the value of maxRows
     */
    public int getMaxRows();

    /**
     * Returns all rows from the msgstatus table that match the specified
     * arbitrary SQL statement
     */
    public MsgStatus[] findByDynamicSelect(String sql, Object[] sqlParams)
	    throws MsgStatusDaoException;

    /**
     * Returns all rows from the msgstatus table that match the specified
     * arbitrary SQL statement
     */
    public MsgStatus[] findByDynamicWhere(String sql, Object[] sqlParams)
	    throws MsgStatusDaoException;

}
