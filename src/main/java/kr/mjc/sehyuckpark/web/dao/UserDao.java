package kr.mjc.sehyuckpark.web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserDao {

    public static final String COUNT_USERS = "select count(userId) from user";
    public static final String UPDATE_USER =
            "update user set email=:email, name=:name where userId=:userId";
    private static final String LIST_USERS
            = "select userId, email, name from user order by userId desc limit ?,?";
    private static final String ADD_USER = """
      insert user(email, password, name)
      values(:email, sha2(:password,256), :name)""";
    private static final String LOGIN = """
      select userId, email, name from user
      where (email, password) = (?, sha2(?,256))""";
    private static final String GET_USER =
            "select userId, email, name from user where userId=?";
    private static final String UPDATE_PASSWORD = """
      update user set password=sha2(:newPassword,256)
      where userId=:userId and password=sha2(:password,256)""";


    private JdbcTemplate jdbcTemplate;

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);

    @Autowired
    public UserDao(JdbcTemplate jdbcTemplate,
                   NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public List<User> listUsers(int offset, int count) {
        return jdbcTemplate.query(LIST_USERS, rowMapper, offset, count);
    }

    public Integer countUsers() {
        return jdbcTemplate.queryForObject(COUNT_USERS, Integer.class);
    }

    public User login(String email, String password)
            throws EmptyResultDataAccessException {
        return jdbcTemplate.queryForObject(LOGIN, rowMapper, email, password);
    }

    public User getUser(int userId) {
        return jdbcTemplate.queryForObject(GET_USER, rowMapper, userId);
    }

    public void addUser(User user) throws DuplicateKeyException {
        namedParameterJdbcTemplate
                .update(ADD_USER, new BeanPropertySqlParameterSource(user));
    }

    public void updateUser(User user) throws DuplicateKeyException {
        namedParameterJdbcTemplate
                .update(UPDATE_USER, new BeanPropertySqlParameterSource(user));
    }

    public int updatePassword(int userId, String password, String newPassword) {
        Map<String, Object> params = new HashMap<>();
        params.put("userId", userId);
        params.put("password", password);
        params.put("newPassword", newPassword);
        return namedParameterJdbcTemplate.update(UPDATE_PASSWORD, params);
    }
}