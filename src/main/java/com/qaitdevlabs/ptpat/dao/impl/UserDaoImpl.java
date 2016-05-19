package com.qaitdevlabs.ptpat.dao.impl;

import java.util.List;

import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.SpringSecurityMessageSource;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.qaitdevlabs.ptpat.dao.UserDao;
import com.qaitdevlabs.ptpat.model.User;

public class UserDaoImpl extends GenericDaoImpl<User, Long> implements UserDao,
		UserDetailsService {

	protected MessageSourceAccessor messages;

	public UserDaoImpl() {
		super(User.class);
		messages = SpringSecurityMessageSource.getAccessor();

	}

	@Override
	@SuppressWarnings("deprecation")
	public User loadUserByUsername(String userName)
			throws UsernameNotFoundException, DataAccessException {
		System.out.println(userName);
		@SuppressWarnings("unchecked")
		List<User> list = getHibernateTemplate().find(
				"from User c where c.username=?", userName);
		System.out.println(list);
		if (list.size() != 0) {
			return (User) list.get(0);
		} else {
			throw new UsernameNotFoundException(messages.getMessage(
					"JdbcDaoImpl.notFound", new Object[] { userName },
					"Username {0} not found"), userName);
		}

	}

}
