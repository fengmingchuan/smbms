package cn.bdqn.dao.smbms2.dao;



import cn.bdqn.dao.smbms2.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    List<User>  selectByAll();
    int  deleteById(@Param("id") Integer id);
    int insertByall(User user);
    int updateById(User user);
    User selectById(long id);

  //jsdkfklasjflksjdlfjlskjfklsf
    //jsdkfklasjflksjdlfjlskjfklsf
    //jsdkfklasjflksjdlfjlskjfklsf

}
