package ua.bionichill.socialnetwork.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.log4j.Logger;

import ua.bionichill.socialnetwork.dao.ProfileDao;
import ua.bionichill.socialnetwork.dto.Profile;
import ua.bionichill.socialnetwork.dto.ProfilePk;
import ua.bionichill.socialnetwork.exceptions.ProfileDaoException;

public class ProfileDaoImpl extends AbstractDAO implements ProfileDao {
    /**
     * The factory class for this DAO has two versions of the create() method -
     * one that takes no arguments and one that takes a Connection argument. If
     * the Connection version is chosen then the connection will be stored in
     * this attribute and will be used by all calls to this DAO, otherwise a new
     * Connection will be allocated for each operation.
     */
    private java.sql.Connection userConn;

    private static final Logger logger = Logger.getLogger(ProfileDaoImpl.class);

    /**
     * All finder methods in this class use this SELECT constant to build their
     * queries
     */
    private final String SQL_SELECT = "SELECT idprofile, fname, surname, sex, pict, introd, hobby FROM "
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
	    + " ( idprofile, fname, surname, sex, pict, introd, hobby ) VALUES ( ?, ?, ?, ?, ?, ?, ? )";

    /**
     * SQL UPDATE statement for this table
     */
    private final String SQL_UPDATE = "UPDATE "
	    + getTableName()
	    + " SET idprofile = ?, fname = ?, surname = ?, sex = ?, pict = ?, introd = ?, hobby = ? WHERE idprofile = ?";

    /**
     * SQL DELETE statement for this table
     */
    private final String SQL_DELETE = "DELETE FROM " + getTableName()
	    + " WHERE idprofile = ?";

    /**
     * Index of column idprofile
     */
    private static final int COLUMN_ID_PROFILE = 1;

    /**
     * Index of column fname
     */
    private static final int COLUMN_F_NAME = 2;

    /**
     * Index of column surname
     */
    private static final int COLUMN_SUR_NAME = 3;

    /**
     * Index of column sex
     */
    private static final int COLUMN_SEX = 4;

    /**
     * Index of column pict
     */
    private static final int COLUMN_PICT = 5;

    /**
     * Index of column introd
     */
    private static final int COLUMN_INTROD = 6;

    /**
     * Index of column hobby
     */
    private static final int COLUMN_HOBBY = 7;

    /**
     * Number of columns
     */
    private static final int NUMBER_OF_COLUMNS = 7;

    /**
     * Index of primary-key column idprofile
     */
    private static final int PK_COLUMN_ID_PROFILE = 1;

    /**
     * Inserts a new row in the profile table.
     */
    public ProfilePk insert(Profile dto) throws ProfileDaoException {
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

	    stmt = conn.prepareStatement(SQL_INSERT,
		    Statement.RETURN_GENERATED_KEYS);
	    int index = 1;
	    if (dto.getIdProfile() != null) {
		stmt.setInt(index++, dto.getIdProfile().intValue());
	    } else {
		stmt.setNull(index++, java.sql.Types.INTEGER);
	    }

	    stmt.setString(index++, dto.getFName());
	    stmt.setString(index++, dto.getSurName());
	    stmt.setString(index++, dto.getSex().name());
	    super.setBlobColumn(stmt, index++, dto.getPict());
	    stmt.setString(index++, dto.getIntrod());
	    stmt.setString(index++, dto.getHobby());
	    if (logger.isDebugEnabled()) {
		logger.debug("Executing " + SQL_INSERT + " with DTO: " + dto);
	    }

	    int rows = stmt.executeUpdate();
	    long t2 = System.currentTimeMillis();
	    if (logger.isDebugEnabled()) {
		logger.debug(rows + " rows affected (" + (t2 - t1) + " ms)");
	    }

	    // retrieve values from auto-increment columns
	    rs = stmt.getGeneratedKeys();
	    if (rs != null && rs.next()) {
		dto.setIdProfile(new Integer(rs.getInt(1)));
	    }

	    reset(dto);
	    return dto.createPk();
	} catch (Exception _e) {
	    logger.error("Exception: " + _e.getMessage(), _e);
	    throw new ProfileDaoException("Exception: " + _e.getMessage(), _e);
	} finally {
	    ResourceManager.close(stmt);
	    if (!isConnSupplied) {
		ResourceManager.close(conn);
	    }

	}

    }

    /**
     * Updates a single row in the profile table.
     */
    public void update(ProfilePk pk, Profile dto) throws ProfileDaoException {
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
	    if (dto.getIdProfile() != null) {
		stmt.setInt(index++, dto.getIdProfile().intValue());
	    } else {
		stmt.setNull(index++, java.sql.Types.INTEGER);
	    }

	    stmt.setString(index++, dto.getFName());
	    stmt.setString(index++, dto.getSurName());
	    stmt.setString(index++, dto.getSex().name());
	    super.setBlobColumn(stmt, index++, dto.getPict());
	    stmt.setString(index++, dto.getIntrod());
	    stmt.setString(index++, dto.getHobby());
	    if (pk.getIdProfile() != null) {
		stmt.setInt(8, pk.getIdProfile().intValue());
	    } else {
		stmt.setNull(8, java.sql.Types.INTEGER);
	    }

	    int rows = stmt.executeUpdate();
	    reset(dto);
	    long t2 = System.currentTimeMillis();
	    if (logger.isDebugEnabled()) {
		logger.debug(rows + " rows affected (" + (t2 - t1) + " ms)");
	    }

	} catch (Exception _e) {
	    logger.error("Exception: " + _e.getMessage(), _e);
	    throw new ProfileDaoException("Exception: " + _e.getMessage(), _e);
	} finally {
	    ResourceManager.close(stmt);
	    if (!isConnSupplied) {
		ResourceManager.close(conn);
	    }

	}

    }

    /**
     * Deletes a single row in the profile table.
     */
    public void delete(ProfilePk pk) throws ProfileDaoException {
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
	    if (pk.getIdProfile() != null) {
		stmt.setInt(1, pk.getIdProfile().intValue());
	    } else {
		stmt.setNull(1, java.sql.Types.INTEGER);
	    }

	    int rows = stmt.executeUpdate();
	    long t2 = System.currentTimeMillis();
	    if (logger.isDebugEnabled()) {
		logger.debug(rows + " rows affected (" + (t2 - t1) + " ms)");
	    }

	} catch (Exception _e) {
	    logger.error("Exception: " + _e.getMessage(), _e);
	    throw new ProfileDaoException("Exception: " + _e.getMessage(), _e);
	} finally {
	    ResourceManager.close(stmt);
	    if (!isConnSupplied) {
		ResourceManager.close(conn);
	    }

	}

    }

    /**
     * Returns the rows from the profile table that matches the specified
     * primary-key value.
     */
    public Profile findByPrimaryKey(ProfilePk pk) throws ProfileDaoException {
	return findByPrimaryKey(pk.getIdProfile());
    }

    /**
     * Returns all rows from the profile table that match the criteria
     * 'idprofile = :idProfile'.
     */
    public Profile findByPrimaryKey(Integer idProfile)
	    throws ProfileDaoException {
	Profile ret[] = findByDynamicSelect(
		SQL_SELECT + " WHERE idprofile = ?", new Object[] { idProfile });
	return ret.length == 0 ? null : ret[0];
    }

    /**
     * Returns all rows from the profile table that match the criteria ''.
     */
    public Profile[] findAll() throws ProfileDaoException {
	return findByDynamicSelect(SQL_SELECT + " ORDER BY idprofile", null);
    }

    /**
     * Returns all rows from the profile table that match the criteria
     * 'idProfile = :idProfile'.
     */
    public Profile[] findWhereIdProfileEquals(Integer idProfile)
	    throws ProfileDaoException {
	return findByDynamicSelect(SQL_SELECT
		+ " WHERE idProfile = ? ORDER BY idProfile",
		new Object[] { idProfile });
    }

    /**
     * Returns all rows from the profile table that match the criteria 'fName =
     * :fName'.
     */
    public Profile[] findWhereFNameEquals(String fName)
	    throws ProfileDaoException {
	return findByDynamicSelect(SQL_SELECT
		+ " WHERE fName = ? ORDER BY fName", new Object[] { fName });
    }

    /**
     * Returns all rows from the profile table that match the criteria 'surName
     * = :surName'.
     */
    public Profile[] findWhereSurNameEquals(String surName)
	    throws ProfileDaoException {
	return findByDynamicSelect(SQL_SELECT
		+ " WHERE surName = ? ORDER BY surName",
		new Object[] { surName });
    }

    /**
     * Returns all rows from the profile table that match the criteria 'sex =
     * :sex'.
     */
    public Profile[] findWhereSexEquals(String sex) throws ProfileDaoException {
	return findByDynamicSelect(SQL_SELECT + " WHERE sex = ? ORDER BY sex",
		new Object[] { sex });
    }

    /**
     * Returns all rows from the profile table that match the criteria 'pict =
     * :pict'.
     */
    public Profile[] findWherePictEquals(byte[] pict)
	    throws ProfileDaoException {
	return findByDynamicSelect(
		SQL_SELECT + " WHERE pict = ? ORDER BY pict",
		new Object[] { pict });
    }

    /**
     * Returns all rows from the profile table that match the criteria 'introd =
     * :introd'.
     */
    public Profile[] findWhereIntrodEquals(String introd)
	    throws ProfileDaoException {
	return findByDynamicSelect(SQL_SELECT
		+ " WHERE introd = ? ORDER BY introd", new Object[] { introd });
    }

    /**
     * Returns all rows from the profile table that match the criteria 'hobby =
     * :hobby'.
     */
    public Profile[] findWhereHobbyEquals(String hobby)
	    throws ProfileDaoException {
	return findByDynamicSelect(SQL_SELECT
		+ " WHERE hobby = ? ORDER BY hobby", new Object[] { hobby });
    }

    /**
     * Method 'ProfileDaoImpl'
     * 
     */
    public ProfileDaoImpl() {
    }

    /**
     * Method 'ProfileDaoImpl'
     * 
     * @param userConn
     */
    public ProfileDaoImpl(final java.sql.Connection userConn) {
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
	return "socialnetwork.profile";
    }

    /**
     * Fetches a single row from the result set
     */
    private Profile fetchSingleResult(ResultSet rs) throws SQLException {
	if (rs.next()) {
	    Profile dto = new Profile();
	    populateDto(dto, rs);
	    return dto;
	} else {
	    return null;
	}

    }

    /**
     * Fetches multiple rows from the result set
     */
    private Profile[] fetchMultiResults(ResultSet rs) throws SQLException {
	Collection resultList = new ArrayList();
	while (rs.next()) {
	    Profile dto = new Profile();
	    populateDto(dto, rs);
	    resultList.add(dto);
	}

	Profile ret[] = new Profile[resultList.size()];
	resultList.toArray(ret);
	return ret;
    }

    /**
     * Populates a DTO with data from a ResultSet
     */
    private void populateDto(Profile dto, ResultSet rs) throws SQLException {
	dto.setIdProfile(new Integer(rs.getInt(COLUMN_ID_PROFILE)));
	dto.setFName(rs.getString(COLUMN_F_NAME));
	dto.setSurName(rs.getString(COLUMN_SUR_NAME));
	dto.setSex(rs.getString(COLUMN_SEX));
	dto.setPict(super.getBlobColumn(rs, COLUMN_PICT));
	dto.setIntrod(rs.getString(COLUMN_INTROD));
	dto.setHobby(rs.getString(COLUMN_HOBBY));
    }

    /**
     * Resets the modified attributes in the DTO
     */
    private void reset(Profile dto) {
    }

    /**
     * Returns all rows from the profile table that match the specified
     * arbitrary SQL statement
     */
    public Profile[] findByDynamicSelect(String sql, Object[] sqlParams)
	    throws ProfileDaoException {
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
	    throw new ProfileDaoException("Exception: " + _e.getMessage(), _e);
	} finally {
	    ResourceManager.close(rs);
	    ResourceManager.close(stmt);
	    if (!isConnSupplied) {
		ResourceManager.close(conn);
	    }

	}

    }

    /**
     * Returns all rows from the profile table that match the specified
     * arbitrary SQL statement
     */
    public Profile[] findByDynamicWhere(String sql, Object[] sqlParams)
	    throws ProfileDaoException {
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
	    throw new ProfileDaoException("Exception: " + _e.getMessage(), _e);
	} finally {
	    ResourceManager.close(rs);
	    ResourceManager.close(stmt);
	    if (!isConnSupplied) {
		ResourceManager.close(conn);
	    }

	}

    }

}
