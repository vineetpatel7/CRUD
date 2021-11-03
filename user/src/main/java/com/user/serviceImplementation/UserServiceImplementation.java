package com.user.serviceImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.user.model.UserModel;
import com.user.repository.UserRepository;
import com.user.service.UserService;

@Service
public class UserServiceImplementation implements UserService{

    @Autowired
    private UserRepository userRepo;

	
	@Override
	public String registration(UserModel user) {
		String message="";
		String regexPhone="[6-9]{1}[0-9]{9}";  
		String regexEmail = "^(.+)@(.+)$";
		if(user.getPhone().matches(regexPhone))
		{
			if(user.getEmail().matches(regexEmail)) {
				userRepo.save(user);
				message="User added successfully";
			}
			else {
				message="Invalid email id";
			}
			
		}
		else {
			message="Invalid mobile number";
		}
		return message;
	}

	@Override
	public String update(UserModel user) {
		String message=null;
		String regexPhone="[6-9]{1}[0-9]{9}";  
		String regexEmail = "^(.+)@(.+)$";
		Optional<UserModel> userDetail = userRepo.findById(user.getId());
		if(userDetail.isPresent()) {
			userDetail.get().setName(user.getName());
			userDetail.get().setEmail(user.getEmail());
			userDetail.get().setPhone(user.getPhone());
			userDetail.get().setAddress(user.getAddress());
			if(user.getPhone().matches(regexPhone))
			{
				if(user.getEmail().matches(regexEmail)) {
					userRepo.save(user);
					message="User updated successfully";
				}
				else {
					message="Invalid email id";
				}
				
			}
			else {
				message="Invalid mobile number";
			}
		}
		else {
			message="User does not exist";
		}
		return message;
	}

	@Override
	public UserModel getById(Long id) {
		UserModel user=null;
		Optional<UserModel> userDetail = userRepo.findById(id);
		if(userDetail.isPresent())
		{
			user=userRepo.getById(id);
		}
		else {
			user=null;
		}
		return user;
	}

	@Override
	public String deleteById(Long id) {
		String message=null;
		Optional<UserModel> available = userRepo.findById(id);
		if(available.isPresent())
		{
			userRepo.deleteById(id);
			message="User deleted successfully";
		}
		else {
			message="User does not exist";
		}
		return message;
	}

	@Override
	public List<UserModel> searchByNameAndEmail(UserModel user) {
		List<UserModel> model=userRepo.getByNameAndEmail(user.getName(),user.getEmail());
		return model;
	}

}
