package ua.bionichill.socialnetwork.dao;

import ua.bionichill.socialnetwork.dto.UStatus;
import ua.bionichill.socialnetwork.dto.UStatusPk;
import ua.bionichill.socialnetwork.exceptions.UStatusDaoException;

public interface UStatusDao {
    /**
     * Inserts a new row in the ustatus table.
     */
    public UStatusPk insert(UStatus dto) throws UStatusDaoException;

    /**
     * Updates a single row in the ustatus table.
     */
    public void update(UStatusPk pk, UStatus dto) throws UStatusDaoException;

    /**
     * Deletes a single row in the ustatus table.
     */
    public void delete(UStatusPk pk) throws UStatusDaoException;

    /**
     * Returns the rows from the ustatus table that matches the specified
     * primary-key value.
     */
    public UStatus findByPrimaryKey(UStatusPk pk) throws UStatusDaoException;

    /**
     * Returns all rows from the ustatus table that match the criteria 'ustatus
     * = :uStatus'.
     */
    public UStatus findByPrimaryKey(String uStatus) throws UStatusDaoException;

    /**
     * Returns all rows from the ustatus table that match the criteria ''.
     */
    public UStatus[] findAll() throws UStatusDaoException;

    /**
     * Returns all rows from the ustatus table that match the criteria 'uStatus
     * = :uStatus'.
     */
    public UStatus[] findWhereUStatusEquals(String uStatus)
	    throws UStatusDaoException;

    /**
     * Sets the value of maxRows
     */
    public void setMaxRows(int maxRows);

    /**
     * Gets the value of maxRows
     */
    public int getMaxRows();

    /**
     * Returns all rows from the ustatus table that match the specified
     * arbitrary SQL statement
     */
    public UStatus[] findByDynamicSelect(String sql, Object[] sqlParams)
	    throws UStatusDaoException;

    /**
     * Returns all rows from the ustatus table that match the specified
     * arbitrary SQL statement
     */
    public UStatus[] findByDynamicWhere(String sql, Object[] sqlParams)
	    throws UStatusDaoException;

}
