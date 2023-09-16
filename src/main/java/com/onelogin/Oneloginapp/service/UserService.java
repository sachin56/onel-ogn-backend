package com.onelogin.Oneloginapp.service;

import com.onelogin.Oneloginapp.dto.UserDTO;
import com.onelogin.Oneloginapp.entity.User;
import com.onelogin.Oneloginapp.repo.UserRepo;
import com.onelogin.Oneloginapp.utill.VarList;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;
    public  String saveUsers(UserDTO userDTO){
        if (userRepo.existsById(userDTO.getId())){
            return VarList.RSP_DUPLICATED;
        }else {
            userRepo.save(modelMapper.map(userDTO, User.class));
            return VarList.RSP_SUCCESS;
        }
    }

    public String updateUsers(UserDTO userDTO){
        if (userRepo.existsById(userDTO.getId())){
            userRepo.save(modelMapper.map(userDTO,User.class));
            return VarList.RSP_SUCCESS;
        }else {
            return VarList.RSP_NO_DATA_FOUND;
        }
    }

    public List<UserDTO> getAllUsers(){
        List<User> userList = userRepo.findAll();
        return modelMapper.map(userList,new TypeToken<ArrayList<UserDTO>>(){
        }.getType());
    }

    public UserDTO searchUser(int ID){
        if (userRepo.existsById( ID)){
            User employee = userRepo.findById(ID).orElse(null);
            return modelMapper.map(employee, UserDTO.class);
        }else {
            return null;
        }
    }
    public String deleteUser(int empID){
        if (userRepo.existsById(empID)){
            userRepo.deleteById(empID);
            return VarList.RSP_SUCCESS;
        }else {
            return VarList.RSP_NO_DATA_FOUND;
        }
    }
}
