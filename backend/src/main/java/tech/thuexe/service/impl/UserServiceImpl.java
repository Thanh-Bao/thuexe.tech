package tech.thuexe.service.impl;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import tech.thuexe.DTO.user.UserDTO;
import tech.thuexe.DTO.user.UserLoginDTO;
import tech.thuexe.entity.RoleEntity;
import tech.thuexe.entity.UserEntity;
import tech.thuexe.repository.RoleRepo;
import tech.thuexe.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tech.thuexe.service.UserService;
import tech.thuexe.utility.DataMapperUtils;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Service @RequiredArgsConstructor @Transactional @Slf4j
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepo userRepo;
    private final RoleRepo roleRepo;
    private final PasswordEncoder passwordEncoder;
    private final DataMapperUtils dataMapperUtils;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user  = userRepo.findByUsername(username);
        if (user==null){
            throw new UsernameNotFoundException("UserEntity not found in the database");
        }
        Collection<SimpleGrantedAuthority> authrities = new ArrayList<>();
        user.getRoles().forEach(role -> {
            authrities.add(new SimpleGrantedAuthority(role.getName()));
        });
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),authrities);
    }


    @Override
    public UserDTO saveUser(UserEntity user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        UserEntity userResult = userRepo.save(dataMapperUtils.map(user,UserEntity.class));
        return dataMapperUtils.map(userResult,UserDTO.class);
    }

    @Override
    public RoleEntity saveRole(RoleEntity role) {
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        UserEntity userEntity =  userRepo.findByUsername(username);
        RoleEntity roleEntity = roleRepo.findByName(roleName);
        userEntity.getRoles().add(roleEntity);
    }

    @Override
    public UserEntity getUser(String username) {
        return userRepo.findByUsername(username);
    }

    @Override
    public List<UserDTO> getUsers() {
        List<UserEntity> users = userRepo.findAll();
        return dataMapperUtils.mapAll(users,UserDTO.class);
    }

    @Override
    public String getUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated()) {
            return null;
        }
        return  authentication.getName();
    }

}
