package ua.bionichill.socialnetwork.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.log4j.Logger;

import ua.bionichill.socialnetwork.dao.FriendshStatusDao;
import ua.bionichill.socialnetwork.dto.FriendshStatus;
import ua.bionichill.socialnetwork.dto.FriendshStatusPk;
import ua.bionichill.socialnetwork.exceptions.FriendshStatusDaoException;

public class FriendshStatusDaoImpl extends AbstractDAO implements
	FriendshStatusDao {
    /**
     * The factory class for this DAO has two versions of the create() method -
     * one that takes no arguments and one that takes a Connection argument. If
     * the Connection version is chosen then the connection will be stored in
     * this attribute and will be used by all calls to this DAO, otherwise a new
     * Connection will be allocated for each operation.
     */
    private java.sql.Connection userConn;

    private static final Logger logger = Logger
	    .getLogger(FriendshStatusDaoImpl.class);

    /**
     * All finder methods in this class use this SELECT constant to build their
     * queries
     */
    private final String SQL_SELECT = "SELECT friendshstatus FROM "
	    + getTableName() + "";

    /**
     * Finder methods will pass this value to the JDBC setMaxRows method
     */
    private int maxRows;

    /**
     * SQL INSERT statement for this table
     */
    private final String SQL_INSERT = "INSERT INTO " + getTableName()
	    + " ( friendshstatus ) VALUES ( ? )";

    /**
     * SQL UPDATE statement for this table
     */
    private final String SQL_UPDATE = "UPDATE " + getTableName()
	    + " SET friendshstatus = ? WHERE friendshstatus = ?";

    /**
     * SQL DELETE statement for this table
     */
    private final String SQL_DELETE = "DELETE FROM " + getTableName()
	    + " WHERE friendshstatus = ?";

    /**
     * Index of column friendshstatus
     */
    private static final int COLUMN_FRIENDSH_STATUS = 1;

    /**
     * Number of columns
     */
    private static final int NUMBER_OF_COLUMNS = 1;

    /**
     * Index of primary-key column friendshstatus
     */
    private static final int PK_COLUMN_FRIENDSH_STATUS = 1;

    /**
     * Inserts a new row in the friendshstatus table.
     */
    public FriendshStatusPk insert(FriendshStatus dto)
	    throws FriendshStatusDaoException {
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
	    stmt.setString(index++, dto.getFriendshStatus());
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
	    throw new FriendshStatusDaoException("Exception: "
		    + _e.getMessage(), _e);
	} finally {
	    ResourceManager.close(stmt);
	    if (!isConnSupplied) {
		ResourceManager.close(conn);
	    }

	}

    }

    /**
     * Updates a single row in the friendshstatus table.
     */
    public void update(FriendshStatusPk pk, FriendshStatus dto)
	    throws FriendshStatusDaoException {
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
	    stmt.setString(index++, dto.getFriendshStatus());
	    stmt.setString(2, pk.getFriendshStatus());
	    int rows = stmt.executeUpdate();
	    reset(dto);
	    long t2 = System.currentTimeMillis();
	    if (logger.isDebugEnabled()) {
		logger.debug(rows + " rows affected (" + (t2 - t1) + " ms)");
	    }

	} catch (Exception _e) {
	    logger.error("Exception: " + _e.getMessage(), _e);
	    throw new FriendshStatusDaoException("Exception: "
		    + _e.getMessage(), _e);
	} finally {
	    ResourceManager.close(stmt);
	    if (!isConnSupplied) {
		ResourceManager.close(conn);
	    }

	}

    }

    /**
     * Deletes a single row in the friendshstatus table.
     */
    public void delete(FriendshStatusPk pk) throws FriendshStatusDaoException {
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
	    stmt.setString(1, pk.getFriendshStatus());
	    int rows = stmt.executeUpdate();
	    long t2 = System.currentTimeMillis();
	    if (logger.isDebugEnabled()) {
		logger.debug(rows + " rows affected (" + (t2 - t1) + " ms)");
	    }

	} catch (Exception _e) {
	    logger.error("Exception: " + _e.getMessage(), _e);
	    throw new FriendshStatusDaoException("Exception: "
		    + _e.getMessage(), _e);
	} finally {
	    ResourceManager.close(stmt);
	    if (!isConnSupplied) {
		ResourceManager.close(conn);
	    }

	}

    }

    /**
     * Returns the rows from the friendshstatus table that matches the specified
     * primary-key value.
     */
    public FriendshStatus findByPrimaryKey(FriendshStatusPk pk)
	    throws FriendshStatusDaoException {
	return findByPrimaryKey(pk.getFriendshStatus());
    }

    /**
     * Returns all rows from the friendshstatus table that match the criteria
     * 'friendshstatus = :friendshStatus'.
     */
    public FriendshStatus findByPrimaryKey(String friendshStatus)
	    throws FriendshStatusDaoException {
	FriendshStatus ret[] = findByDynamicSelect(SQL_SELECT
		+ " WHERE friendshstatus = ?", new Object[] { friendshStatus });
	return ret.length == 0 ? null : ret[0];
    }

    /**
     * Returns all rows from the friendshstatus table that match the criteria
     * ''.
     */
    public FriendshStatus[] findAll() throws FriendshStatusDaoException {
	return findByDynamicSelect(SQL_SELECT + " ORDER BY friendshstatus",
		null);
    }

    /**
     * Returns all rows from the friendshstatus table that match the criteria
     * 'friendshStatus = :friendshStatus'.
     */
    public FriendshStatus[] findWhereFriendshStatusEquals(String friendshStatus)
	    throws FriendshStatusDaoException {
	return findByDynamicSelect(SQL_SELECT
		+ " WHERE friendshStatus = ? ORDER BY friendshStatus",
		new Object[] { friendshStatus });
    }

    /**
     * Method 'FriendshStatusDaoImpl'
     * 
     */
    public FriendshStatusDaoImpl() {
    }

    /**
     * Method 'FriendshStatusDaoImpl'
     * 
     * @param userConn
     */
    public FriendshStatusDaoImpl(final java.sql.Connection userConn) {
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
	return "socialnetwork.friendshstatus";
    }

    /**
     * Fetches a single row from the result set
     */
    private FriendshStatus fetchSingleResult(ResultSet rs) throws SQLException {
	if (rs.next()) {
	    FriendshStatus dto = new FriendshStatus();
	    populateDto(dto, rs);
	    return dto;
	} else {
	    return null;
	}

    }

    /**
     * Fetches multiple rows from the result set
     */
    private FriendshStatus[] fetchMultiResults(ResultSet rs)
	    throws SQLException {
	Collection resultList = new ArrayList();
	while (rs.next()) {
	    FriendshStatus dto = new FriendshStatus();
	    populateDto(dto, rs);
	    resultList.add(dto);
	}

	FriendshStatus ret[] = new FriendshStatus[resultList.size()];
	resultList.toArray(ret);
	return ret;
    }

    /**
     * Populates a DTO with data from a ResultSet
     */
    private void populateDto(FriendshStatus dto, ResultSet rs)
	    throws SQLException {
	dto.setFriendshStatus(rs.getString(COLUMN_FRIENDSH_STATUS));
    }

    /**
     * Resets the modified attributes in the DTO
     */
    private void reset(FriendshStatus dto) {
    }

    /**
     * Returns all rows from the friendshstatus table that match the specified
     * arbitrary SQL statement
     */
    public FriendshStatus[] findByDynamicSelect(String sql, Object[] sqlParams)
	    throws FriendshStatusDaoException {
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
	    throw new FriendshStatusDaoException("Exception: "
		    + _e.getMessage(), _e);
	} finally {
	    ResourceManager.close(rs);
	    ResourceManager.close(stmt);
	    if (!isConnSupplied) {
		ResourceManager.close(conn);
	    }

	}

    }

    /**
     * Returns all rows from the friendshstatus table that match the specified
     * arbitrary SQL statement
     */
    public FriendshStatus[] findByDynamicWhere(String sql, Object[] sqlParams)
	    throws FriendshStatusDaoException {
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
	    throw new FriendshStatusDaoException("Exception: "
		    + _e.getMessage(), _e);
	} finally {
	    ResourceManager.close(rs);
	    ResourceManager.close(stmt);
	    if (!isConnSupplied) {
		ResourceManager.close(conn);
	    }

	}

    }

}
