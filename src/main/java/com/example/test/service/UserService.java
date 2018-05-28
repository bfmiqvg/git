package com.example.test.service;

import com.example.test.domain.User;
import com.example.test.mapper.UserMapper;
import com.example.test.util.Encrypt;
import com.example.test.util.PBKDF2WithHmacSHA1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

/**
 * @Date:Created by luzy on 2018/4/23.
 * @Description:
 */
@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    public User findUser(String userName,String password){
        User user=userMapper.findUser(userName,password);
        return user;
    }

    public User findUserByName(String userName) {
        User user=userMapper.findUserByName(userName);
        return user;
    }

    public int save(User user) {
        return userMapper.save(user);
    }

    public List<User> findAll(){
        return userMapper.findAll();
    }

    public void updatePassword(User user){
        String password=encryptPassword(user.getLoginName(),user.getPassword());
        userMapper.updatePassword(password,user.getId());
    }

    //加密密码
    public String encryptPassword(String name,String password){
        String newPassword="";
        try {
            System.out.println("组合:"+password+name);
            newPassword=PBKDF2WithHmacSHA1.generateStorngPasswordHash(password+name,password+name);
            System.out.println("PK密码:"+newPassword);
            Encrypt encrypt=new Encrypt();
            newPassword=encrypt.MD5(newPassword);
            System.out.println("MD5:"+newPassword);
            return newPassword;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return password;
    }
}
