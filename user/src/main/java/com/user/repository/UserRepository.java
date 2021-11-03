package com.user.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.user.model.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long>{
	
	@Modifying
    @Query(value="select * from user_model where name= ?1 and email=?2", nativeQuery = true)
	@Transactional
	public List<UserModel> getByNameAndEmail(String name, String email);
	
}
