package com.bionichill.socialnetwork.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.log4j.Logger;

import com.bionichill.socialnetwork.dao.IInviteResDao;
import com.bionichill.socialnetwork.dto.InviteRes;
import com.bionichill.socialnetwork.dto.InviteResPk;
import com.bionichill.socialnetwork.exceptions.InviteResDaoException;


public class InviteResDaoImpl extends AbstractDAO implements IInviteResDao {
    /**
     * The factory class for this DAO has two versions of the create() method -
     * one that takes no arguments and one that takes a Connection argument. If
     * the Connection version is chosen then the connection will be stored in
     * this attribute and will be used by all calls to this DAO, otherwise a new
     * Connection will be allocated for each operation.
     */
    private java.sql.Connection userConn;

    private static final Logger logger = Logger
	    .getLogger(InviteResDaoImpl.class);

    /**
     * All finder methods in this class use this SELECT constant to build their
     * queries
     */
    private final String SQL_SELECT = "SELECT inviteres FROM " + getTableName()
	    + "";

    /**
     * Finder methods will pass this value to the JDBC setMaxRows method
     */
    private int maxRows;

    /**
     * SQL INSERT statement for this table
     */
    private final String SQL_INSERT = "INSERT INTO " + getTableName()
	    + " ( inviteres ) VALUES ( ? )";

    /**
     * SQL UPDATE statement for this table
     */
    private final String SQL_UPDATE = "UPDATE " + getTableName()
	    + " SET inviteres = ? WHERE inviteres = ?";

    /**
     * SQL DELETE statement for this table
     */
    private final String SQL_DELETE = "DELETE FROM " + getTableName()
	    + " WHERE inviteres = ?";

    /**
     * Index of column inviteres
     */
    private static final int COLUMN_INVITE_RES = 1;

    /**
     * Number of columns
     */
    private static final int NUMBER_OF_COLUMNS = 1;

    /**
     * Index of primary-key column inviteres
     */
    private static final int PK_COLUMN_INVITE_RES = 1;

    /**
     * Inserts a new row in the inviteres table.
     */
    public InviteResPk insert(InviteRes dto) throws InviteResDaoException {
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
	    stmt.setString(index++, dto.getInviteRes());
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
	    throw new InviteResDaoException("Exception: " + _e.getMessage(), _e);
	} finally {
	    ResourceManager.close(stmt);
	    if (!isConnSupplied) {
		ResourceManager.close(conn);
	    }

	}

    }

    /**
     * Updates a single row in the inviteres table.
     */
    public void update(InviteResPk pk, InviteRes dto)
	    throws InviteResDaoException {
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
	    stmt.setString(index++, dto.getInviteRes());
	    stmt.setString(2, pk.getInviteRes());
	    int rows = stmt.executeUpdate();
	    reset(dto);
	    long t2 = System.currentTimeMillis();
	    if (logger.isDebugEnabled()) {
		logger.debug(rows + " rows affected (" + (t2 - t1) + " ms)");
	    }

	} catch (Exception _e) {
	    logger.error("Exception: " + _e.getMessage(), _e);
	    throw new InviteResDaoException("Exception: " + _e.getMessage(), _e);
	} finally {
	    ResourceManager.close(stmt);
	    if (!isConnSupplied) {
		ResourceManager.close(conn);
	    }

	}

    }

    /**
     * Deletes a single row in the inviteres table.
     */
    public void delete(InviteResPk pk) throws InviteResDaoException {
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
	    stmt.setString(1, pk.getInviteRes());
	    int rows = stmt.executeUpdate();
	    long t2 = System.currentTimeMillis();
	    if (logger.isDebugEnabled()) {
		logger.debug(rows + " rows affected (" + (t2 - t1) + " ms)");
	    }

	} catch (Exception _e) {
	    logger.error("Exception: " + _e.getMessage(), _e);
	    throw new InviteResDaoException("Exception: " + _e.getMessage(), _e);
	} finally {
	    ResourceManager.close(stmt);
	    if (!isConnSupplied) {
		ResourceManager.close(conn);
	    }

	}

    }

    /**
     * Returns the rows from the inviteres table that matches the specified
     * primary-key value.
     */
    public InviteRes findByPrimaryKey(InviteResPk pk)
	    throws InviteResDaoException {
	return findByPrimaryKey(pk.getInviteRes());
    }

    /**
     * Returns all rows from the inviteres table that match the criteria
     * 'inviteres = :inviteRes'.
     */
    public InviteRes findByPrimaryKey(String inviteRes)
	    throws InviteResDaoException {
	InviteRes ret[] = findByDynamicSelect(SQL_SELECT
		+ " WHERE inviteres = ?", new Object[] { inviteRes });
	return ret.length == 0 ? null : ret[0];
    }

    /**
     * Returns all rows from the inviteres table that match the criteria ''.
     */
    public InviteRes[] findAll() throws InviteResDaoException {
	return findByDynamicSelect(SQL_SELECT + " ORDER BY inviteres", null);
    }

    /**
     * Returns all rows from the inviteres table that match the criteria
     * 'inviteRes = :inviteRes'.
     */
    public InviteRes[] findWhereInviteResEquals(String inviteRes)
	    throws InviteResDaoException {
	return findByDynamicSelect(SQL_SELECT
		+ " WHERE inviteRes = ? ORDER BY inviteRes",
		new Object[] { inviteRes });
    }

    /**
     * Method 'InviteResDaoImpl'
     * 
     */
    public InviteResDaoImpl() {
    }

    /**
     * Method 'InviteResDaoImpl'
     * 
     * @param userConn
     */
    public InviteResDaoImpl(final java.sql.Connection userConn) {
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
	return "socialnetwork.inviteres";
    }

    /**
     * Fetches a single row from the result set
     */
    private InviteRes fetchSingleResult(ResultSet rs) throws SQLException {
	if (rs.next()) {
	    InviteRes dto = new InviteRes();
	    populateDto(dto, rs);
	    return dto;
	} else {
	    return null;
	}

    }

    /**
     * Fetches multiple rows from the result set
     */
    private InviteRes[] fetchMultiResults(ResultSet rs) throws SQLException {
	Collection resultList = new ArrayList();
	while (rs.next()) {
	    InviteRes dto = new InviteRes();
	    populateDto(dto, rs);
	    resultList.add(dto);
	}

	InviteRes ret[] = new InviteRes[resultList.size()];
	resultList.toArray(ret);
	return ret;
    }

    /**
     * Populates a DTO with data from a ResultSet
     */
    private void populateDto(InviteRes dto, ResultSet rs) throws SQLException {
	dto.setInviteRes(rs.getString(COLUMN_INVITE_RES));
    }

    /**
     * Resets the modified attributes in the DTO
     */
    private void reset(InviteRes dto) {
    }

    /**
     * Returns all rows from the inviteres table that match the specified
     * arbitrary SQL statement
     */
    public InviteRes[] findByDynamicSelect(String sql, Object[] sqlParams)
	    throws InviteResDaoException {
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
	    throw new InviteResDaoException("Exception: " + _e.getMessage(), _e);
	} finally {
	    ResourceManager.close(rs);
	    ResourceManager.close(stmt);
	    if (!isConnSupplied) {
		ResourceManager.close(conn);
	    }

	}

    }

    /**
     * Returns all rows from the inviteres table that match the specified
     * arbitrary SQL statement
     */
    public InviteRes[] findByDynamicWhere(String sql, Object[] sqlParams)
	    throws InviteResDaoException {
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
	    throw new InviteResDaoException("Exception: " + _e.getMessage(), _e);
	} finally {
	    ResourceManager.close(rs);
	    ResourceManager.close(stmt);
	    if (!isConnSupplied) {
		ResourceManager.close(conn);
	    }

	}

    }

}
