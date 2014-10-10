package com.cdstore.dbagent.dao.def;

import com.cdstore.model.User;

/**
 * Data access layer for user
 * 
 * @author Ronak
 */
public interface IUserDao {
	void save(User user);
}
