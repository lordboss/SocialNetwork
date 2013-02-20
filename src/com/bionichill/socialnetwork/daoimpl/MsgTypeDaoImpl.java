package com.bionichill.socialnetwork.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.log4j.Logger;

import com.bionichill.socialnetwork.dao.IMsgTypeDao;
import com.bionichill.socialnetwork.dto.MsgType;
import com.bionichill.socialnetwork.dto.MsgTypePk;
import com.bionichill.socialnetwork.exceptions.MsgTypeDaoException;


public class MsgTypeDaoImpl extends AbstractDAO implements IMsgTypeDao {
    /**
     * The factory class for this DAO has two versions of the create() method -
     * one that takes no arguments and one that takes a Connection argument. If
     * the Connection version is chosen then the connection will be stored in
     * this attribute and will be used by all calls to this DAO, otherwise a new
     * Connection will be allocated for each operation.
     */
    private java.sql.Connection userConn;

    private static final Logger logger = Logger.getLogger(MsgTypeDaoImpl.class);

    /**
     * All finder methods in this class use this SELECT constant to build their
     * queries
     */
    private final String SQL_SELECT = "SELECT msgtype FROM " + getTableName()
	    + "";

    /**
     * Finder methods will pass this value to the JDBC setMaxRows method
     */
    private int maxRows;

    /**
     * SQL INSERT statement for this table
     */
    private final String SQL_INSERT = "INSERT INTO " + getTableName()
	    + " ( msgtype ) VALUES ( ? )";

    /**
     * SQL UPDATE statement for this table
     */
    private final String SQL_UPDATE = "UPDATE " + getTableName()
	    + " SET msgtype = ? WHERE msgtype = ?";

    /**
     * SQL DELETE statement for this table
     */
    private final String SQL_DELETE = "DELETE FROM " + getTableName()
	    + " WHERE msgtype = ?";

    /**
     * Index of column msgtype
     */
    private static final int COLUMN_MSG_TYPE = 1;

    /**
     * Number of columns
     */
    private static final int NUMBER_OF_COLUMNS = 1;

    /**
     * Index of primary-key column msgtype
     */
    private static final int PK_COLUMN_MSG_TYPE = 1;

    /**
     * Inserts a new row in the msgtype table.
     */
    public MsgTypePk insert(MsgType dto) throws MsgTypeDaoException {
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
	    stmt.setString(index++, dto.getMsgType());
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
	    throw new MsgTypeDaoException("Exception: " + _e.getMessage(), _e);
	} finally {
	    ResourceManager.close(stmt);
	    if (!isConnSupplied) {
		ResourceManager.close(conn);
	    }

	}

    }

    /**
     * Updates a single row in the msgtype table.
     */
    public void update(MsgTypePk pk, MsgType dto) throws MsgTypeDaoException {
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
	    stmt.setString(index++, dto.getMsgType());
	    stmt.setString(2, pk.getMsgType());
	    int rows = stmt.executeUpdate();
	    reset(dto);
	    long t2 = System.currentTimeMillis();
	    if (logger.isDebugEnabled()) {
		logger.debug(rows + " rows affected (" + (t2 - t1) + " ms)");
	    }

	} catch (Exception _e) {
	    logger.error("Exception: " + _e.getMessage(), _e);
	    throw new MsgTypeDaoException("Exception: " + _e.getMessage(), _e);
	} finally {
	    ResourceManager.close(stmt);
	    if (!isConnSupplied) {
		ResourceManager.close(conn);
	    }

	}

    }

    /**
     * Deletes a single row in the msgtype table.
     */
    public void delete(MsgTypePk pk) throws MsgTypeDaoException {
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
	    stmt.setString(1, pk.getMsgType());
	    int rows = stmt.executeUpdate();
	    long t2 = System.currentTimeMillis();
	    if (logger.isDebugEnabled()) {
		logger.debug(rows + " rows affected (" + (t2 - t1) + " ms)");
	    }

	} catch (Exception _e) {
	    logger.error("Exception: " + _e.getMessage(), _e);
	    throw new MsgTypeDaoException("Exception: " + _e.getMessage(), _e);
	} finally {
	    ResourceManager.close(stmt);
	    if (!isConnSupplied) {
		ResourceManager.close(conn);
	    }

	}

    }

    /**
     * Returns the rows from the msgtype table that matches the specified
     * primary-key value.
     */
    public MsgType findByPrimaryKey(MsgTypePk pk) throws MsgTypeDaoException {
	return findByPrimaryKey(pk.getMsgType());
    }

    /**
     * Returns all rows from the msgtype table that match the criteria 'msgtype
     * = :msgType'.
     */
    public MsgType findByPrimaryKey(String msgType) throws MsgTypeDaoException {
	MsgType ret[] = findByDynamicSelect(SQL_SELECT + " WHERE msgtype = ?",
		new Object[] { msgType });
	return ret.length == 0 ? null : ret[0];
    }

    /**
     * Returns all rows from the msgtype table that match the criteria ''.
     */
    public MsgType[] findAll() throws MsgTypeDaoException {
	return findByDynamicSelect(SQL_SELECT + " ORDER BY msgtype", null);
    }

    /**
     * Returns all rows from the msgtype table that match the criteria 'msgType
     * = :msgType'.
     */
    public MsgType[] findWhereMsgTypeEquals(String msgType)
	    throws MsgTypeDaoException {
	return findByDynamicSelect(SQL_SELECT
		+ " WHERE msgType = ? ORDER BY msgType",
		new Object[] { msgType });
    }

    /**
     * Method 'MsgTypeDaoImpl'
     * 
     */
    public MsgTypeDaoImpl() {
    }

    /**
     * Method 'MsgTypeDaoImpl'
     * 
     * @param userConn
     */
    public MsgTypeDaoImpl(final java.sql.Connection userConn) {
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
	return "socialnetwork.msgtype";
    }

    /**
     * Fetches a single row from the result set
     */
    private MsgType fetchSingleResult(ResultSet rs) throws SQLException {
	if (rs.next()) {
	    MsgType dto = new MsgType();
	    populateDto(dto, rs);
	    return dto;
	} else {
	    return null;
	}

    }

    /**
     * Fetches multiple rows from the result set
     */
    private MsgType[] fetchMultiResults(ResultSet rs) throws SQLException {
	Collection resultList = new ArrayList();
	while (rs.next()) {
	    MsgType dto = new MsgType();
	    populateDto(dto, rs);
	    resultList.add(dto);
	}

	MsgType ret[] = new MsgType[resultList.size()];
	resultList.toArray(ret);
	return ret;
    }

    /**
     * Populates a DTO with data from a ResultSet
     */
    private void populateDto(MsgType dto, ResultSet rs) throws SQLException {
	dto.setMsgType(rs.getString(COLUMN_MSG_TYPE));
    }

    /**
     * Resets the modified attributes in the DTO
     */
    private void reset(MsgType dto) {
    }

    /**
     * Returns all rows from the msgtype table that match the specified
     * arbitrary SQL statement
     */
    public MsgType[] findByDynamicSelect(String sql, Object[] sqlParams)
	    throws MsgTypeDaoException {
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
	    throw new MsgTypeDaoException("Exception: " + _e.getMessage(), _e);
	} finally {
	    ResourceManager.close(rs);
	    ResourceManager.close(stmt);
	    if (!isConnSupplied) {
		ResourceManager.close(conn);
	    }

	}

    }

    /**
     * Returns all rows from the msgtype table that match the specified
     * arbitrary SQL statement
     */
    public MsgType[] findByDynamicWhere(String sql, Object[] sqlParams)
	    throws MsgTypeDaoException {
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
	    throw new MsgTypeDaoException("Exception: " + _e.getMessage(), _e);
	} finally {
	    ResourceManager.close(rs);
	    ResourceManager.close(stmt);
	    if (!isConnSupplied) {
		ResourceManager.close(conn);
	    }

	}

    }

}
