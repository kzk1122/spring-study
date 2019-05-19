package com.example.demo.login.domain.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.demo.login.domain.model.User;


public interface UserDao {
	
	int count() throws DataAccessException;
	
	int insertOne(User user) throws DataAccessException;
	
	User selectOne(String userId) throws DataAccessException;
	
	List<User> selectMany() throws DataAccessException;
	
	int updateOne(User user) throws DataAccessException;
	
	int deleteOne(User user) throws DataAccessException;
	
	void userCsvOut() throws DataAccessException;
}
