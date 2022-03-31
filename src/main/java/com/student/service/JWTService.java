package com.student.service;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class JWTService implements UserDetailsService {


		@Override
		public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
			if ("studentapi".equals(username)) {
				return new User("studentapi", "$2a$10$nuDKiX1te31OoY1G8A7itOKM89XebNR.ZRD40Fi6Fy6QSo0438LTy",
						new ArrayList<>());
			} else {
				log.error("error raised in loadUserByUsername ");
				throw new UsernameNotFoundException("User not found with username: " + username);
			}
		}
	
}
