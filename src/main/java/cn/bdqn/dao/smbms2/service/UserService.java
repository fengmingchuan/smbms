package cn.bdqn.dao.smbms2.service;



import cn.bdqn.dao.smbms2.entity.User;

import java.util.List;

public interface UserService {
    List<User> findByAll();
    int delByid(Integer id);
    int addByall(User user);
    int  alterByid(User id);
    User findByid(long id);

}
