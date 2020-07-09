package com.brasil.seg.app.repository;

import java.util.List;

import com.brasil.seg.app.model.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {

	@Query("Select user from UserEntity user where user.emailId = :emailId")
	List<UserEntity> fetchUserByEmailId(@Param("emailId") String emailId);
}
