package com.bionichill.socialnetwork.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.apache.log4j.Logger;

import com.bionichill.socialnetwork.dao.IUserDao;
import com.bionichill.socialnetwork.dto.User;
import com.bionichill.socialnetwork.dto.UserPk;
import com.bionichill.socialnetwork.exceptions.ProfileDaoException;
import com.bionichill.socialnetwork.exceptions.UStatusDaoException;
import com.bionichill.socialnetwork.exceptions.UTypeDaoException;
import com.bionichill.socialnetwork.exceptions.UserDaoException;


public class UserDaoImpl extends AbstractDAO implements IUserDao {
    /**
     * The factory class for this DAO has two versions of the create() method -
     * one that takes no arguments and one that takes a Connection argument. If
     * the Connection version is chosen then the connection will be stored in
     * this attribute and will be used by all calls to this DAO, otherwise a new
     * Connection will be allocated for each operation.
     */
    private java.sql.Connection userConn;

    private static final Logger logger = Logger.getLogger(UserDaoImpl.class);

    /**
     * All finder methods in this class use this SELECT constant to build their
     * queries
     */
    private final String SQL_SELECT = "SELECT email, passw, typeu, statusu, profileid, registrdate FROM "
	    + getTableName() + "";

    /**
     * Finder methods will pass this value to the JDBC setMaxRows method
     */
    private int maxRows;

    /**
     * SQL INSERT statement for this table
     */
    private final String SQL_INSERT = "INSERT INTO "
	    + getTableName()
	    + " ( email, passw, typeu, statusu, profileid, registrdate ) VALUES ( ?, ?, ?, ?, ?, ? )";

    /**
     * SQL UPDATE statement for this table
     */
    private final String SQL_UPDATE = "UPDATE "
	    + getTableName()
	    + " SET email = ?, passw = ?, typeu = ?, statusu = ?, profileid = ?, registrdate = ? WHERE email = ?";

    /**
     * SQL DELETE statement for this table
     */
    private final String SQL_DELETE = "DELETE FROM " + getTableName()
	    + " WHERE email = ?";

    /**
     * Index of column email
     */
    private static final int COLUMN_EMAIL = 1;

    /**
     * Index of column passw
     */
    private static final int COLUMN_PASSW = 2;

    /**
     * Index of column typeu
     */
    private static final int COLUMN_TYPE_U = 3;

    /**
     * Index of column statusu
     */
    private static final int COLUMN_STATUS_U = 4;

    /**
     * Index of column profileid
     */
    private static final int COLUMN_PROFILE_ID = 5;

    /**
     * Index of column registrdate
     */
    private static final int COLUMN_REGISTR_DATE = 6;

    /**
     * Number of columns
     */
    private static final int NUMBER_OF_COLUMNS = 6;

    /**
     * Index of primary-key column email
     */
    private static final int PK_COLUMN_EMAIL = 1;

    /**
     * Inserts a new row in the user table.
     */
    public UserPk insert(User dto) throws UserDaoException {
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
	    stmt.setString(index++, dto.getEmail());
	    stmt.setString(index++, dto.getPassw());
	    stmt.setString(index++, dto.getTypeU().getUType());
	    stmt.setString(index++, dto.getStatusU().getUStatus());
	    if (dto.getProfile().getIdProfile() != null) {
		stmt.setInt(index++,
			(dto.getProfile().getIdProfile()).intValue());
	    } else {
		stmt.setNull(index++, java.sql.Types.INTEGER);
	    }

	    stmt.setTimestamp(index++, dto.getRegistrDate() == null ? null
		    : new java.sql.Timestamp(dto.getRegistrDate().getTime()));
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
	    throw new UserDaoException("Exception: " + _e.getMessage(), _e);
	} finally {
	    ResourceManager.close(stmt);
	    if (!isConnSupplied) {
		ResourceManager.close(conn);
	    }

	}

    }

    /**
     * Updates a single row in the user table.
     */
    public void update(UserPk pk, User dto) throws UserDaoException {
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
	    stmt.setString(index++, dto.getEmail());
	    stmt.setString(index++, dto.getPassw());
	    stmt.setString(index++, dto.getTypeU().getUType());
	    stmt.setString(index++, dto.getStatusU().getUStatus());
	    if (dto.getProfile().getIdProfile() != null) {
		stmt.setInt(index++,
			(dto.getProfile().getIdProfile()).intValue());
	    } else {
		stmt.setNull(index++, java.sql.Types.INTEGER);
	    }

	    stmt.setTimestamp(index++, dto.getRegistrDate() == null ? null
		    : new java.sql.Timestamp(dto.getRegistrDate().getTime()));
	    stmt.setString(7, pk.getEmail());
	    int rows = stmt.executeUpdate();
	    reset(dto);
	    long t2 = System.currentTimeMillis();
	    if (logger.isDebugEnabled()) {
		logger.debug(rows + " rows affected (" + (t2 - t1) + " ms)");
	    }

	} catch (Exception _e) {
	    logger.error("Exception: " + _e.getMessage(), _e);
	    throw new UserDaoException("Exception: " + _e.getMessage(), _e);
	} finally {
	    ResourceManager.close(stmt);
	    if (!isConnSupplied) {
		ResourceManager.close(conn);
	    }

	}

    }

    /**
     * Deletes a single row in the user table.
     */
    public void delete(UserPk pk) throws UserDaoException {
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
	    stmt.setString(1, pk.getEmail());
	    int rows = stmt.executeUpdate();
	    long t2 = System.currentTimeMillis();
	    if (logger.isDebugEnabled()) {
		logger.debug(rows + " rows affected (" + (t2 - t1) + " ms)");
	    }

	} catch (Exception _e) {
	    logger.error("Exception: " + _e.getMessage(), _e);
	    throw new UserDaoException("Exception: " + _e.getMessage(), _e);
	} finally {
	    ResourceManager.close(stmt);
	    if (!isConnSupplied) {
		ResourceManager.close(conn);
	    }

	}

    }

    /**
     * Returns the rows from the user table that matches the specified
     * primary-key value.
     */
    public User findByPrimaryKey(UserPk pk) throws UserDaoException {
	return findByPrimaryKey(pk.getEmail());
    }

    /**
     * Returns all rows from the user table that match the criteria 'email =
     * :email'.
     */
    public User findByPrimaryKey(String email) throws UserDaoException {
	User ret[] = findByDynamicSelect(SQL_SELECT + " WHERE email = ?",
		new Object[] { email });
	return ret.length == 0 ? null : ret[0];
    }

    /**
     * Returns all rows from the user table that match the criteria ''.
     */
    public User[] findAll() throws UserDaoException {
	return findByDynamicSelect(SQL_SELECT + " ORDER BY email", null);
    }

    /**
     * Returns all rows from the user table that match the criteria 'profileId =
     * :profileId'.
     */
    public User[] findByProfile(Integer profileId) throws UserDaoException {
	return findByDynamicSelect(SQL_SELECT + " WHERE profileId = ?",
		new Object[] { profileId });
    }

    /**
     * Returns all rows from the user table that match the criteria 'statusU =
     * :statusU'.
     */
    public User[] findByUStatus(String statusU) throws UserDaoException {
	return findByDynamicSelect(SQL_SELECT + " WHERE statusU = ?",
		new Object[] { statusU });
    }

    /**
     * Returns all rows from the user table that match the criteria 'typeU =
     * :typeU'.
     */
    public User[] findByUType(String typeU) throws UserDaoException {
	return findByDynamicSelect(SQL_SELECT + " WHERE typeU = ?",
		new Object[] { typeU });
    }

    /**
     * Returns all rows from the user table that match the criteria 'email =
     * :email'.
     */
    public User[] findWhereEmailEquals(String email) throws UserDaoException {
	return findByDynamicSelect(SQL_SELECT
		+ " WHERE email = ? ORDER BY email", new Object[] { email });
    }

    /**
     * Returns all rows from the user table that match the criteria 'passw =
     * :passw'.
     */
    public User[] findWherePasswEquals(String passw) throws UserDaoException {
	return findByDynamicSelect(SQL_SELECT
		+ " WHERE passw = ? ORDER BY passw", new Object[] { passw });
    }

    /**
     * Returns all rows from the user table that match the criteria 'typeU =
     * :typeU'.
     */
    public User[] findWhereTypeUEquals(String typeU) throws UserDaoException {
	return findByDynamicSelect(SQL_SELECT
		+ " WHERE typeU = ? ORDER BY typeU", new Object[] { typeU });
    }

    /**
     * Returns all rows from the user table that match the criteria 'statusU =
     * :statusU'.
     */
    public User[] findWhereStatusUEquals(String statusU)
	    throws UserDaoException {
	return findByDynamicSelect(SQL_SELECT
		+ " WHERE statusU = ? ORDER BY statusU",
		new Object[] { statusU });
    }

    /**
     * Returns all rows from the user table that match the criteria 'profileId =
     * :profileId'.
     */
    public User[] findWhereProfileIdEquals(Integer profileId)
	    throws UserDaoException {
	return findByDynamicSelect(SQL_SELECT
		+ " WHERE profileId = ? ORDER BY profileId",
		new Object[] { profileId });
    }

    /**
     * Returns all rows from the user table that match the criteria 'registrDate
     * = :registrDate'.
     */
    public User[] findWhereRegistrDateEquals(Date registrDate)
	    throws UserDaoException {
	return findByDynamicSelect(SQL_SELECT
		+ " WHERE registrDate = ? ORDER BY registrDate",
		new Object[] { registrDate == null ? null
			: new java.sql.Timestamp(registrDate.getTime()) });
    }

    /**
     * Method 'UserDaoImpl'
     * 
     */
    public UserDaoImpl() {
    }

    /**
     * Method 'UserDaoImpl'
     * 
     * @param userConn
     */
    public UserDaoImpl(final java.sql.Connection userConn) {
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
	return "socialnetwork.user";
    }

    /**
     * Fetches a single row from the result set
     */
    private User fetchSingleResult(ResultSet rs) throws SQLException {
	if (rs.next()) {
	    User dto = new User();
	    populateDto(dto, rs);
	    return dto;
	} else {
	    return null;
	}

    }

    /**
     * Fetches multiple rows from the result set
     */
    private User[] fetchMultiResults(ResultSet rs) throws SQLException {
	Collection resultList = new ArrayList();
	while (rs.next()) {
	    User dto = new User();
	    populateDto(dto, rs);
	    resultList.add(dto);
	}

	User ret[] = new User[resultList.size()];
	resultList.toArray(ret);
	return ret;
    }

    /**
     * Populates a DTO with data from a ResultSet
     */
    private void populateDto(User dto, ResultSet rs) throws SQLException {
	dto.setEmail(rs.getString(COLUMN_EMAIL));
	dto.setPassw(rs.getString(COLUMN_PASSW));
	try {
	    dto.setTypeU(new UTypeDaoImpl().findByPrimaryKey(rs
		    .getString(COLUMN_TYPE_U)));
	} catch (UTypeDaoException e2) {
	    // TODO Auto-generated catch block
	    e2.printStackTrace();
	}
	try {
	    dto.setStatusU(new UStatusDaoImpl().findByPrimaryKey(rs
		    .getString(COLUMN_STATUS_U)));
	} catch (UStatusDaoException e1) {
	    // TODO Auto-generated catch block
	    e1.printStackTrace();
	}
	try {
	    dto.setProfile(new ProfileDaoImpl().findByPrimaryKey(new Integer(rs
		    .getInt(COLUMN_PROFILE_ID))));
	} catch (ProfileDaoException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	dto.setRegistrDate(rs.getTimestamp(COLUMN_REGISTR_DATE));
    }

    /**
     * Resets the modified attributes in the DTO
     */
    private void reset(User dto) {
    }

    /**
     * Returns all rows from the user table that match the specified arbitrary
     * SQL statement
     */
    public User[] findByDynamicSelect(String sql, Object[] sqlParams)
	    throws UserDaoException {
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
	    throw new UserDaoException("Exception: " + _e.getMessage(), _e);
	} finally {
	    ResourceManager.close(rs);
	    ResourceManager.close(stmt);
	    if (!isConnSupplied) {
		ResourceManager.close(conn);
	    }

	}

    }

    /**
     * Returns all rows from the user table that match the specified arbitrary
     * SQL statement
     */
    public User[] findByDynamicWhere(String sql, Object[] sqlParams)
	    throws UserDaoException {
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
	    throw new UserDaoException("Exception: " + _e.getMessage(), _e);
	} finally {
	    ResourceManager.close(rs);
	    ResourceManager.close(stmt);
	    if (!isConnSupplied) {
		ResourceManager.close(conn);
	    }

	}

    }

}
