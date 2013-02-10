package ua.bionichill.socialnetwork.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.log4j.Logger;

import ua.bionichill.socialnetwork.dao.UTypeDao;
import ua.bionichill.socialnetwork.dto.UType;
import ua.bionichill.socialnetwork.dto.UTypePk;
import ua.bionichill.socialnetwork.exceptions.UTypeDaoException;

public class UTypeDaoImpl extends AbstractDAO implements UTypeDao {
    /**
     * The factory class for this DAO has two versions of the create() method -
     * one that takes no arguments and one that takes a Connection argument. If
     * the Connection version is chosen then the connection will be stored in
     * this attribute and will be used by all calls to this DAO, otherwise a new
     * Connection will be allocated for each operation.
     */
    protected java.sql.Connection userConn;

    protected static final Logger logger = Logger.getLogger(UTypeDaoImpl.class);

    /**
     * All finder methods in this class use this SELECT constant to build their
     * queries
     */
    protected final String SQL_SELECT = "SELECT utype FROM " + getTableName()
	    + "";

    /**
     * Finder methods will pass this value to the JDBC setMaxRows method
     */
    protected int maxRows;

    /**
     * SQL INSERT statement for this table
     */
    protected final String SQL_INSERT = "INSERT INTO " + getTableName()
	    + " ( utype ) VALUES ( ? )";

    /**
     * SQL UPDATE statement for this table
     */
    protected final String SQL_UPDATE = "UPDATE " + getTableName()
	    + " SET utype = ? WHERE utype = ?";

    /**
     * SQL DELETE statement for this table
     */
    protected final String SQL_DELETE = "DELETE FROM " + getTableName()
	    + " WHERE utype = ?";

    /**
     * Index of column utype
     */
    protected static final int COLUMN_U_TYPE = 1;

    /**
     * Number of columns
     */
    protected static final int NUMBER_OF_COLUMNS = 1;

    /**
     * Index of primary-key column utype
     */
    protected static final int PK_COLUMN_U_TYPE = 1;

    /**
     * Inserts a new row in the utype table.
     */
    public UTypePk insert(UType dto) throws UTypeDaoException {
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
	    stmt.setString(index++, dto.getUType());
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
	    throw new UTypeDaoException("Exception: " + _e.getMessage(), _e);
	} finally {
	    ResourceManager.close(stmt);
	    if (!isConnSupplied) {
		ResourceManager.close(conn);
	    }

	}

    }

    /**
     * Updates a single row in the utype table.
     */
    public void update(UTypePk pk, UType dto) throws UTypeDaoException {
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
	    stmt.setString(index++, dto.getUType());
	    stmt.setString(2, pk.getUType());
	    int rows = stmt.executeUpdate();
	    reset(dto);
	    long t2 = System.currentTimeMillis();
	    if (logger.isDebugEnabled()) {
		logger.debug(rows + " rows affected (" + (t2 - t1) + " ms)");
	    }

	} catch (Exception _e) {
	    logger.error("Exception: " + _e.getMessage(), _e);
	    throw new UTypeDaoException("Exception: " + _e.getMessage(), _e);
	} finally {
	    ResourceManager.close(stmt);
	    if (!isConnSupplied) {
		ResourceManager.close(conn);
	    }

	}

    }

    /**
     * Deletes a single row in the utype table.
     */
    public void delete(UTypePk pk) throws UTypeDaoException {
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
	    stmt.setString(1, pk.getUType());
	    int rows = stmt.executeUpdate();
	    long t2 = System.currentTimeMillis();
	    if (logger.isDebugEnabled()) {
		logger.debug(rows + " rows affected (" + (t2 - t1) + " ms)");
	    }

	} catch (Exception _e) {
	    logger.error("Exception: " + _e.getMessage(), _e);
	    throw new UTypeDaoException("Exception: " + _e.getMessage(), _e);
	} finally {
	    ResourceManager.close(stmt);
	    if (!isConnSupplied) {
		ResourceManager.close(conn);
	    }

	}

    }

    /**
     * Returns the rows from the utype table that matches the specified
     * primary-key value.
     */
    public UType findByPrimaryKey(UTypePk pk) throws UTypeDaoException {
	return findByPrimaryKey(pk.getUType());
    }

    /**
     * Returns all rows from the utype table that match the criteria 'utype =
     * :uType'.
     */
    public UType findByPrimaryKey(String uType) throws UTypeDaoException {
	UType ret[] = findByDynamicSelect(SQL_SELECT + " WHERE utype = ?",
		new Object[] { uType });
	return ret.length == 0 ? null : ret[0];
    }

    /**
     * Returns all rows from the utype table that match the criteria ''.
     */
    public UType[] findAll() throws UTypeDaoException {
	return findByDynamicSelect(SQL_SELECT + " ORDER BY utype", null);
    }

    /**
     * Returns all rows from the utype table that match the criteria 'uType =
     * :uType'.
     */
    public UType[] findWhereUTypeEquals(String uType) throws UTypeDaoException {
	return findByDynamicSelect(SQL_SELECT
		+ " WHERE uType = ? ORDER BY uType", new Object[] { uType });
    }

    /**
     * Method 'UTypeDaoImpl'
     * 
     */
    public UTypeDaoImpl() {
    }

    /**
     * Method 'UTypeDaoImpl'
     * 
     * @param userConn
     */
    public UTypeDaoImpl(final java.sql.Connection userConn) {
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
	return "socialnetwork.utype";
    }

    /**
     * Fetches a single row from the result set
     */
    protected UType fetchSingleResult(ResultSet rs) throws SQLException {
	if (rs.next()) {
	    UType dto = new UType();
	    populateDto(dto, rs);
	    return dto;
	} else {
	    return null;
	}

    }

    /**
     * Fetches multiple rows from the result set
     */
    protected UType[] fetchMultiResults(ResultSet rs) throws SQLException {
	Collection resultList = new ArrayList();
	while (rs.next()) {
	    UType dto = new UType();
	    populateDto(dto, rs);
	    resultList.add(dto);
	}

	UType ret[] = new UType[resultList.size()];
	resultList.toArray(ret);
	return ret;
    }

    /**
     * Populates a DTO with data from a ResultSet
     */
    protected void populateDto(UType dto, ResultSet rs) throws SQLException {
	dto.setUType(rs.getString(COLUMN_U_TYPE));
    }

    /**
     * Resets the modified attributes in the DTO
     */
    protected void reset(UType dto) {
    }

    /**
     * Returns all rows from the utype table that match the specified arbitrary
     * SQL statement
     */
    public UType[] findByDynamicSelect(String sql, Object[] sqlParams)
	    throws UTypeDaoException {
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
	    throw new UTypeDaoException("Exception: " + _e.getMessage(), _e);
	} finally {
	    ResourceManager.close(rs);
	    ResourceManager.close(stmt);
	    if (!isConnSupplied) {
		ResourceManager.close(conn);
	    }

	}

    }

    /**
     * Returns all rows from the utype table that match the specified arbitrary
     * SQL statement
     */
    public UType[] findByDynamicWhere(String sql, Object[] sqlParams)
	    throws UTypeDaoException {
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
	    throw new UTypeDaoException("Exception: " + _e.getMessage(), _e);
	} finally {
	    ResourceManager.close(rs);
	    ResourceManager.close(stmt);
	    if (!isConnSupplied) {
		ResourceManager.close(conn);
	    }

	}

    }

}
