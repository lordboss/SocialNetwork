package com.bionichill.socialnetwork.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.log4j.Logger;

import com.bionichill.socialnetwork.dao.IUStatusDao;
import com.bionichill.socialnetwork.dto.UStatus;
import com.bionichill.socialnetwork.dto.UStatusPk;
import com.bionichill.socialnetwork.exceptions.UStatusDaoException;


public class UStatusDaoImpl extends AbstractDAO implements IUStatusDao {
    /**
     * The factory class for this DAO has two versions of the create() method -
     * one that takes no arguments and one that takes a Connection argument. If
     * the Connection version is chosen then the connection will be stored in
     * this attribute and will be used by all calls to this DAO, otherwise a new
     * Connection will be allocated for each operation.
     */
    private java.sql.Connection userConn;

    private static final Logger logger = Logger.getLogger(UStatusDaoImpl.class);

    /**
     * All finder methods in this class use this SELECT constant to build their
     * queries
     */
    private final String SQL_SELECT = "SELECT ustatus FROM " + getTableName()
	    + "";

    /**
     * Finder methods will pass this value to the JDBC setMaxRows method
     */
    private int maxRows;

    /**
     * SQL INSERT statement for this table
     */
    private final String SQL_INSERT = "INSERT INTO " + getTableName()
	    + " ( ustatus ) VALUES ( ? )";

    /**
     * SQL UPDATE statement for this table
     */
    private final String SQL_UPDATE = "UPDATE " + getTableName()
	    + " SET ustatus = ? WHERE ustatus = ?";

    /**
     * SQL DELETE statement for this table
     */
    private final String SQL_DELETE = "DELETE FROM " + getTableName()
	    + " WHERE ustatus = ?";

    /**
     * Index of column ustatus
     */
    private static final int COLUMN_U_STATUS = 1;

    /**
     * Number of columns
     */
    private static final int NUMBER_OF_COLUMNS = 1;

    /**
     * Index of primary-key column ustatus
     */
    private static final int PK_COLUMN_U_STATUS = 1;

    /**
     * Inserts a new row in the ustatus table.
     */
    public UStatusPk insert(UStatus dto) throws UStatusDaoException {
	long t1 = System.currentTimeMillis();
	// declare variables
	final boolean isConnSupplied = (userConn != null);
	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;

	try {
	    // get the user-specified connection or get a connection from the
	    // ResourceManager
	    conn = isConnSupplied ? userConn : ResourceManager.getConnection();

	    stmt = conn.prepareStatement(SQL_INSERT);
	    int index = 1;
	    stmt.setString(index++, dto.getUStatus());
	    if (logger.isDebugEnabled()) {
		logger.debug("Executing " + SQL_INSERT + " with DTO: " + dto);
	    }

	    int rows = stmt.executeUpdate();
	    long t2 = System.currentTimeMillis();
	    if (logger.isDebugEnabled()) {
		logger.debug(rows + " rows affected (" + (t2 - t1) + " ms)");
	    }

	    reset(dto);
	    return dto.createPk();
	} catch (Exception _e) {
	    logger.error("Exception: " + _e.getMessage(), _e);
	    throw new UStatusDaoException("Exception: " + _e.getMessage(), _e);
	} finally {
	    ResourceManager.close(stmt);
	    if (!isConnSupplied) {
		ResourceManager.close(conn);
	    }

	}

    }

    /**
     * Updates a single row in the ustatus table.
     */
    public void update(UStatusPk pk, UStatus dto) throws UStatusDaoException {
	long t1 = System.currentTimeMillis();
	// declare variables
	final boolean isConnSupplied = (userConn != null);
	Connection conn = null;
	PreparedStatement stmt = null;

	try {
	    // get the user-specified connection or get a connection from the
	    // ResourceManager
	    conn = isConnSupplied ? userConn : ResourceManager.getConnection();

	    if (logger.isDebugEnabled()) {
		logger.debug("Executing " + SQL_UPDATE + " with DTO: " + dto);
	    }

	    stmt = conn.prepareStatement(SQL_UPDATE);
	    int index = 1;
	    stmt.setString(index++, dto.getUStatus());
	    stmt.setString(2, pk.getUStatus());
	    int rows = stmt.executeUpdate();
	    reset(dto);
	    long t2 = System.currentTimeMillis();
	    if (logger.isDebugEnabled()) {
		logger.debug(rows + " rows affected (" + (t2 - t1) + " ms)");
	    }

	} catch (Exception _e) {
	    logger.error("Exception: " + _e.getMessage(), _e);
	    throw new UStatusDaoException("Exception: " + _e.getMessage(), _e);
	} finally {
	    ResourceManager.close(stmt);
	    if (!isConnSupplied) {
		ResourceManager.close(conn);
	    }

	}

    }

    /**
     * Deletes a single row in the ustatus table.
     */
    public void delete(UStatusPk pk) throws UStatusDaoException {
	long t1 = System.currentTimeMillis();
	// declare variables
	final boolean isConnSupplied = (userConn != null);
	Connection conn = null;
	PreparedStatement stmt = null;

	try {
	    // get the user-specified connection or get a connection from the
	    // ResourceManager
	    conn = isConnSupplied ? userConn : ResourceManager.getConnection();

	    if (logger.isDebugEnabled()) {
		logger.debug("Executing " + SQL_DELETE + " with PK: " + pk);
	    }

	    stmt = conn.prepareStatement(SQL_DELETE);
	    stmt.setString(1, pk.getUStatus());
	    int rows = stmt.executeUpdate();
	    long t2 = System.currentTimeMillis();
	    if (logger.isDebugEnabled()) {
		logger.debug(rows + " rows affected (" + (t2 - t1) + " ms)");
	    }

	} catch (Exception _e) {
	    logger.error("Exception: " + _e.getMessage(), _e);
	    throw new UStatusDaoException("Exception: " + _e.getMessage(), _e);
	} finally {
	    ResourceManager.close(stmt);
	    if (!isConnSupplied) {
		ResourceManager.close(conn);
	    }

	}

    }

    /**
     * Returns the rows from the ustatus table that matches the specified
     * primary-key value.
     */
    public UStatus findByPrimaryKey(UStatusPk pk) throws UStatusDaoException {
	return findByPrimaryKey(pk.getUStatus());
    }

    /**
     * Returns all rows from the ustatus table that match the criteria 'ustatus
     * = :uStatus'.
     */
    public UStatus findByPrimaryKey(String uStatus) throws UStatusDaoException {
	UStatus ret[] = findByDynamicSelect(SQL_SELECT + " WHERE ustatus = ?",
		new Object[] { uStatus });
	return ret.length == 0 ? null : ret[0];
    }

    /**
     * Returns all rows from the ustatus table that match the criteria ''.
     */
    public UStatus[] findAll() throws UStatusDaoException {
	return findByDynamicSelect(SQL_SELECT + " ORDER BY ustatus", null);
    }

    /**
     * Returns all rows from the ustatus table that match the criteria 'uStatus
     * = :uStatus'.
     */
    public UStatus[] findWhereUStatusEquals(String uStatus)
	    throws UStatusDaoException {
	return findByDynamicSelect(SQL_SELECT
		+ " WHERE uStatus = ? ORDER BY uStatus",
		new Object[] { uStatus });
    }

    /**
     * Method 'UStatusDaoImpl'
     * 
     */
    public UStatusDaoImpl() {
    }

    /**
     * Method 'UStatusDaoImpl'
     * 
     * @param userConn
     */
    public UStatusDaoImpl(final java.sql.Connection userConn) {
	this.userConn = userConn;
    }

    /**
     * Sets the value of maxRows
     */
    public void setMaxRows(int maxRows) {
	this.maxRows = maxRows;
    }

    /**
     * Gets the value of maxRows
     */
    public int getMaxRows() {
	return maxRows;
    }

    /**
     * Method 'getTableName'
     * 
     * @return String
     */
    public String getTableName() {
	return "socialnetwork.ustatus";
    }

    /**
     * Fetches a single row from the result set
     */
    private UStatus fetchSingleResult(ResultSet rs) throws SQLException {
	if (rs.next()) {
	    UStatus dto = new UStatus();
	    populateDto(dto, rs);
	    return dto;
	} else {
	    return null;
	}

    }

    /**
     * Fetches multiple rows from the result set
     */
    private UStatus[] fetchMultiResults(ResultSet rs) throws SQLException {
	Collection resultList = new ArrayList();
	while (rs.next()) {
	    UStatus dto = new UStatus();
	    populateDto(dto, rs);
	    resultList.add(dto);
	}

	UStatus ret[] = new UStatus[resultList.size()];
	resultList.toArray(ret);
	return ret;
    }

    /**
     * Populates a DTO with data from a ResultSet
     */
    private void populateDto(UStatus dto, ResultSet rs) throws SQLException {
	dto.setUStatus(rs.getString(COLUMN_U_STATUS));
    }

    /**
     * Resets the modified attributes in the DTO
     */
    private void reset(UStatus dto) {
    }

    /**
     * Returns all rows from the ustatus table that match the specified
     * arbitrary SQL statement
     */
    public UStatus[] findByDynamicSelect(String sql, Object[] sqlParams)
	    throws UStatusDaoException {
	// declare variables
	final boolean isConnSupplied = (userConn != null);
	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;

	try {
	    // get the user-specified connection or get a connection from the
	    // ResourceManager
	    conn = isConnSupplied ? userConn : ResourceManager.getConnection();

	    // construct the SQL statement
	    final String SQL = sql;

	    if (logger.isDebugEnabled()) {
		logger.debug("Executing " + SQL);
	    }

	    // prepare statement
	    stmt = conn.prepareStatement(SQL);
	    stmt.setMaxRows(maxRows);

	    // bind parameters
	    for (int i = 0; sqlParams != null && i < sqlParams.length; i++) {
		stmt.setObject(i + 1, sqlParams[i]);
	    }

	    rs = stmt.executeQuery();

	    // fetch the results
	    return fetchMultiResults(rs);
	} catch (Exception _e) {
	    logger.error("Exception: " + _e.getMessage(), _e);
	    throw new UStatusDaoException("Exception: " + _e.getMessage(), _e);
	} finally {
	    ResourceManager.close(rs);
	    ResourceManager.close(stmt);
	    if (!isConnSupplied) {
		ResourceManager.close(conn);
	    }

	}

    }

    /**
     * Returns all rows from the ustatus table that match the specified
     * arbitrary SQL statement
     */
    public UStatus[] findByDynamicWhere(String sql, Object[] sqlParams)
	    throws UStatusDaoException {
	// declare variables
	final boolean isConnSupplied = (userConn != null);
	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;

	try {
	    // get the user-specified connection or get a connection from the
	    // ResourceManager
	    conn = isConnSupplied ? userConn : ResourceManager.getConnection();

	    // construct the SQL statement
	    final String SQL = SQL_SELECT + " WHERE " + sql;

	    if (logger.isDebugEnabled()) {
		logger.debug("Executing " + SQL);
	    }

	    // prepare statement
	    stmt = conn.prepareStatement(SQL);
	    stmt.setMaxRows(maxRows);

	    // bind parameters
	    for (int i = 0; sqlParams != null && i < sqlParams.length; i++) {
		stmt.setObject(i + 1, sqlParams[i]);
	    }

	    rs = stmt.executeQuery();

	    // fetch the results
	    return fetchMultiResults(rs);
	} catch (Exception _e) {
	    logger.error("Exception: " + _e.getMessage(), _e);
	    throw new UStatusDaoException("Exception: " + _e.getMessage(), _e);
	} finally {
	    ResourceManager.close(rs);
	    ResourceManager.close(stmt);
	    if (!isConnSupplied) {
		ResourceManager.close(conn);
	    }

	}

    }

}
