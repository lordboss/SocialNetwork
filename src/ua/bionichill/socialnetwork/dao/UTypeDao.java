package ua.bionichill.socialnetwork.dao;

import ua.bionichill.socialnetwork.dto.UType;
import ua.bionichill.socialnetwork.dto.UTypePk;
import ua.bionichill.socialnetwork.exceptions.UTypeDaoException;

public interface UTypeDao {
    /**
     * Inserts a new row in the utype table.
     */
    public UTypePk insert(UType dto) throws UTypeDaoException;

    /**
     * Updates a single row in the utype table.
     */
    public void update(UTypePk pk, UType dto) throws UTypeDaoException;

    /**
     * Deletes a single row in the utype table.
     */
    public void delete(UTypePk pk) throws UTypeDaoException;

    /**
     * Returns the rows from the utype table that matches the specified
     * primary-key value.
     */
    public UType findByPrimaryKey(UTypePk pk) throws UTypeDaoException;

    /**
     * Returns all rows from the utype table that match the criteria 'utype =
     * :uType'.
     */
    public UType findByPrimaryKey(String uType) throws UTypeDaoException;

    /**
     * Returns all rows from the utype table that match the criteria ''.
     */
    public UType[] findAll() throws UTypeDaoException;

    /**
     * Returns all rows from the utype table that match the criteria 'uType =
     * :uType'.
     */
    public UType[] findWhereUTypeEquals(String uType) throws UTypeDaoException;

    /**
     * Sets the value of maxRows
     */
    public void setMaxRows(int maxRows);

    /**
     * Gets the value of maxRows
     */
    public int getMaxRows();

    /**
     * Returns all rows from the utype table that match the specified arbitrary
     * SQL statement
     */
    public UType[] findByDynamicSelect(String sql, Object[] sqlParams)
	    throws UTypeDaoException;

    /**
     * Returns all rows from the utype table that match the specified arbitrary
     * SQL statement
     */
    public UType[] findByDynamicWhere(String sql, Object[] sqlParams)
	    throws UTypeDaoException;

}
