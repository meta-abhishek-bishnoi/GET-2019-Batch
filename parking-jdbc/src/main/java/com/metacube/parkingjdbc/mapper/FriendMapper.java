package com.metacube.parkingjdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.parkingjdbc.model.dto.Friend;



public class FriendMapper implements RowMapper<Friend> {

	@Override
	public Friend mapRow(ResultSet resultSet, int i) throws SQLException {
		Friend friend = new Friend();
		friend.setImageUrl(resultSet.getString("profileImageUrl"));
		friend.setFullName(resultSet.getString("fullName"));
		friend.setContactNo(resultSet.getString("contactNo"));
		friend.setEmailId(resultSet.getString("emailId"));
		return friend;
	}

}
