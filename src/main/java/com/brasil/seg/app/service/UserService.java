package com.brasil.seg.app.service;

import java.util.Date;
import java.util.List;

import com.brasil.seg.app.model.UserEntity;
import com.brasil.seg.app.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	private static final Logger LOG = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserRepository userRepository;

	public String addUser(UserEntity user) {
		String status = "";
		List<UserEntity> list = userRepository.fetchUserByEmailId(user.getEmailId());

		if (list.isEmpty()) {
			user.setPassword(user.getPassword());
			user.setAdmin("N");
			user.setActive("Y");
			user.setCreatedTimestamp(new Date());
			userRepository.save(user);
			status = "Success";
		} else
			LOG.info(status);

		return status;
	}

	//Caso a aplicacao necessite de criptografia para as senhas
	//bcrypt é um método de criptografia do tipo hash para senhas baseado no Blowfish
//	private String hashPassword(String password) {
//		return BCrypt.withDefaults().hashToString(12, password.toCharArray());
//	}

}
