package ua.bionichill.socialnetwork.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.log4j.Logger;

import ua.bionichill.socialnetwork.dao.MsgStatusDao;
import ua.bionichill.socialnetwork.dto.MsgStatus;
import ua.bionichill.socialnetwork.dto.MsgStatusPk;
import ua.bionichill.socialnetwork.exceptions.MsgStatusDaoException;

public class MsgStatusDaoImpl extends AbstractDAO implements MsgStatusDao {
    /**
     * The factory class for this DAO has two versions of the create() method -
     * one that takes no arguments and one that takes a Connection argument. If
     * the Connection version is chosen then the connection will be stored in
     * this attribute and will be used by all calls to this DAO, otherwise a new
     * Connection will be allocated for each operation.
     */
    private java.sql.Connection userConn;

    private static final Logger logger = Logger
	    .getLogger(MsgStatusDaoImpl.class);

    /**
     * All finder methods in this class use this SELECT constant to build their
     * queries
     */
    private final String SQL_SELECT = "SELECT msgstatus FROM " + getTableName()
	    + "";

    /**
     * Finder methods will pass this value to the JDBC setMaxRows method
     */
    private int maxRows;

    /**
     * SQL INSERT statement for this table
     */
    private final String SQL_INSERT = "INSERT INTO " + getTableName()
	    + " ( msgstatus ) VALUES ( ? )";

    /**
     * SQL UPDATE statement for this table
     */
    private final String SQL_UPDATE = "UPDATE " + getTableName()
	    + " SET msgstatus = ? WHERE msgstatus = ?";

    /**
     * SQL DELETE statement for this table
     */
    private final String SQL_DELETE = "DELETE FROM " + getTableName()
	    + " WHERE msgstatus = ?";

    /**
     * Index of column msgstatus
     */
    private static final int COLUMN_MSG_STATUS = 1;

    /**
     * Number of columns
     */
    private static final int NUMBER_OF_COLUMNS = 1;

    /**
     * Index of primary-key column msgstatus
     */
    private static final int PK_COLUMN_MSG_STATUS = 1;

    /**
     * Inserts a new row in the msgstatus table.
     */
    public MsgStatusPk insert(MsgStatus dto) throws MsgStatusDaoException {
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
	    stmt.setString(index++, dto.getMsgStatus());
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
	    throw new MsgStatusDaoException("Exception: " + _e.getMessage(), _e);
	} finally {
	    ResourceManager.close(stmt);
	    if (!isConnSupplied) {
		ResourceManager.close(conn);
	    }

	}

    }

    /**
     * Updates a single row in the msgstatus table.
     */
    public void update(MsgStatusPk pk, MsgStatus dto)
	    throws MsgStatusDaoException {
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
	    stmt.setString(index++, dto.getMsgStatus());
	    stmt.setString(2, pk.getMsgStatus());
	    int rows = stmt.executeUpdate();
	    reset(dto);
	    long t2 = System.currentTimeMillis();
	    if (logger.isDebugEnabled()) {
		logger.debug(rows + " rows affected (" + (t2 - t1) + " ms)");
	    }

	} catch (Exception _e) {
	    logger.error("Exception: " + _e.getMessage(), _e);
	    throw new MsgStatusDaoException("Exception: " + _e.getMessage(), _e);
	} finally {
	    ResourceManager.close(stmt);
	    if (!isConnSupplied) {
		ResourceManager.close(conn);
	    }

	}

    }

    /**
     * Deletes a single row in the msgstatus table.
     */
    public void delete(MsgStatusPk pk) throws MsgStatusDaoException {
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
	    stmt.setString(1, pk.getMsgStatus());
	    int rows = stmt.executeUpdate();
	    long t2 = System.currentTimeMillis();
	    if (logger.isDebugEnabled()) {
		logger.debug(rows + " rows affected (" + (t2 - t1) + " ms)");
	    }

	} catch (Exception _e) {
	    logger.error("Exception: " + _e.getMessage(), _e);
	    throw new MsgStatusDaoException("Exception: " + _e.getMessage(), _e);
	} finally {
	    ResourceManager.close(stmt);
	    if (!isConnSupplied) {
		ResourceManager.close(conn);
	    }

	}

    }

    /**
     * Returns the rows from the msgstatus table that matches the specified
     * primary-key value.
     */
    public MsgStatus findByPrimaryKey(MsgStatusPk pk)
	    throws MsgStatusDaoException {
	return findByPrimaryKey(pk.getMsgStatus());
    }

    /**
     * Returns all rows from the msgstatus table that match the criteria
     * 'msgstatus = :msgStatus'.
     */
    public MsgStatus findByPrimaryKey(String msgStatus)
	    throws MsgStatusDaoException {
	MsgStatus ret[] = findByDynamicSelect(SQL_SELECT
		+ " WHERE msgstatus = ?", new Object[] { msgStatus });
	return ret.length == 0 ? null : ret[0];
    }

    /**
     * Returns all rows from the msgstatus table that match the criteria ''.
     */
    public MsgStatus[] findAll() throws MsgStatusDaoException {
	return findByDynamicSelect(SQL_SELECT + " ORDER BY msgstatus", null);
    }

    /**
     * Returns all rows from the msgstatus table that match the criteria
     * 'msgStatus = :msgStatus'.
     */
    public MsgStatus[] findWhereMsgStatusEquals(String msgStatus)
	    throws MsgStatusDaoException {
	return findByDynamicSelect(SQL_SELECT
		+ " WHERE msgStatus = ? ORDER BY msgStatus",
		new Object[] { msgStatus });
    }

    /**
     * Method 'MsgStatusDaoImpl'
     * 
     */
    public MsgStatusDaoImpl() {
    }

    /**
     * Method 'MsgStatusDaoImpl'
     * 
     * @param userConn
     */
    public MsgStatusDaoImpl(final java.sql.Connection userConn) {
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
	return "socialnetwork.msgstatus";
    }

    /**
     * Fetches a single row from the result set
     */
    private MsgStatus fetchSingleResult(ResultSet rs) throws SQLException {
	if (rs.next()) {
	    MsgStatus dto = new MsgStatus();
	    populateDto(dto, rs);
	    return dto;
	} else {
	    return null;
	}

    }

    /**
     * Fetches multiple rows from the result set
     */
    private MsgStatus[] fetchMultiResults(ResultSet rs) throws SQLException {
	Collection resultList = new ArrayList();
	while (rs.next()) {
	    MsgStatus dto = new MsgStatus();
	    populateDto(dto, rs);
	    resultList.add(dto);
	}

	MsgStatus ret[] = new MsgStatus[resultList.size()];
	resultList.toArray(ret);
	return ret;
    }

    /**
     * Populates a DTO with data from a ResultSet
     */
    private void populateDto(MsgStatus dto, ResultSet rs) throws SQLException {
	dto.setMsgStatus(rs.getString(COLUMN_MSG_STATUS));
    }

    /**
     * Resets the modified attributes in the DTO
     */
    private void reset(MsgStatus dto) {
    }

    /**
     * Returns all rows from the msgstatus table that match the specified
     * arbitrary SQL statement
     */
    public MsgStatus[] findByDynamicSelect(String sql, Object[] sqlParams)
	    throws MsgStatusDaoException {
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
	    throw new MsgStatusDaoException("Exception: " + _e.getMessage(), _e);
	} finally {
	    ResourceManager.close(rs);
	    ResourceManager.close(stmt);
	    if (!isConnSupplied) {
		ResourceManager.close(conn);
	    }

	}

    }

    /**
     * Returns all rows from the msgstatus table that match the specified
     * arbitrary SQL statement
     */
    public MsgStatus[] findByDynamicWhere(String sql, Object[] sqlParams)
	    throws MsgStatusDaoException {
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
	    throw new MsgStatusDaoException("Exception: " + _e.getMessage(), _e);
	} finally {
	    ResourceManager.close(rs);
	    ResourceManager.close(stmt);
	    if (!isConnSupplied) {
		ResourceManager.close(conn);
	    }

	}

    }

}
