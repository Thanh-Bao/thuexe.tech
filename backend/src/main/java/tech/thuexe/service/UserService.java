package tech.thuexe.service;

import tech.thuexe.DTO.user.UserDTO;
import tech.thuexe.entity.RoleEntity;
import tech.thuexe.entity.UserEntity;
import tech.thuexe.utility.CustomException;

import java.util.List;

public interface UserService {
    boolean exists(String username);
    UserDTO saveUser(UserEntity user);
    RoleEntity saveRole(RoleEntity role);
    void addRoleToUser(String username, String roleName);
    UserEntity getUser(String username);
    List<UserDTO> getUsers();
    String getUsername();
    List<UserDTO> findAll();

    void lock(String username) throws CustomException;

    void unlock(String username) throws CustomException;
}
