package cn.bdqn.dao.smbms2.service;


import cn.bdqn.dao.smbms2.dao.UserMapper;
import cn.bdqn.dao.smbms2.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements  UserService {

     @Resource
    private UserMapper userMapper;

    @Override
    public List<User> findByAll() {
        List<User> list = userMapper.selectByAll();
        return  list;

    }

    @Override
    public int delByid(Integer id) {
      return   userMapper.deleteById(id);
    }

    @Override
    public int addByall(User user) {
        return userMapper.insertByall(user);
    }

    @Override
    public int alterByid(User user) {
        return userMapper.updateById(user);
    }

    @Override
    public User findByid(long id) {
        return userMapper.selectById(id);
    }
}


