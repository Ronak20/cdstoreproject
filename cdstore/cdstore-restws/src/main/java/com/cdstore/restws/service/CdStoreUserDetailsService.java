package com.cdstore.restws.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import com.cdstore.dbagent.dao.def.IUserDao;
import com.cdstore.model.User;

public class CdStoreUserDetailsService implements UserDetailsService {

	@Autowired
	private IUserDao userDao;

	public IUserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(final String username)
			throws UsernameNotFoundException {
		User user = userDao.getUserByUsername(username);
		List<GrantedAuthority> authorities = buildUserAuthority(user);
		return buildUserForAuthentication(user, authorities);

	}

	private org.springframework.security.core.userdetails.User buildUserForAuthentication(
			User user, List<GrantedAuthority> authorities) {
		return new org.springframework.security.core.userdetails.User(
				user.getUsername(), user.getPassword(), true, true, true, true,
				authorities);
	}

	private List<GrantedAuthority> buildUserAuthority(User user) {

		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

		// Build user's authorities
		setAuths.add(new SimpleGrantedAuthority(user.getRole()));

		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(
				setAuths);

		return Result;
	}

}