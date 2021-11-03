package com.user.service;

import java.util.List;

import com.user.model.UserModel;

public interface UserService {
 public String registration(UserModel user);
 public String update(UserModel user);
 public UserModel getById(Long id);
 public String deleteById(Long id);
 public List<UserModel> searchByNameAndEmail(UserModel user);
}
