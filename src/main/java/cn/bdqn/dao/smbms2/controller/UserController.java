package cn.bdqn.dao.smbms2.controller;


import cn.bdqn.dao.smbms2.entity.User;
import cn.bdqn.dao.smbms2.service.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/user")
@Api("用户管理模板")
public class UserController {
    @Resource
    private UserService userService;


    @RequestMapping("/addh")
    public String  addh(){

        return  "add";
    }
    @RequestMapping("/updateh/{id}")
    public String  updateh(@PathVariable("id")  long id,Model model){
        System.out.println("你好"+id);
        User user = userService.findByid(id);

        model.addAttribute("user",user);
        return  "updateUser";
    }
    @ApiOperation("查询所有用户")
    @ApiImplicitParam(name = "pageNo",value = "起始页")
    @ApiImplicitParams({@ApiImplicitParam(name = "pageNo",value = "起始页"),@ApiImplicitParam(name = "pageSize",value ="容量")})
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public  String UserList(@RequestParam(defaultValue = "1",required = false) Integer pageNo, Model model){
      // int  pageNo_int = Integer.parseInt(pageNo);
      //  int  pageNo_size = Integer.parseInt(pagesize);
       PageHelper.startPage(pageNo,5);
        List<User> list = userService.findByAll();
        PageInfo<User>  pi = new PageInfo<>(list);
        model.addAttribute("list",pi.getList());
        model.addAttribute("totalcount",pi.getPages());
        System.out.println("總頁數"+pi.getPages()+"當前"+pi.getPageNum());
        model.addAttribute("curNo",pi.getPageNum());
        return  "UserList";

    }
    @ApiOperation("更具id删除用户")
    @ApiImplicitParam(name = "id",value = "更具id删除")
    @ResponseBody
    @RequestMapping(value = "/del/{id}",method = RequestMethod.POST)
    public  String delByid(@PathVariable Integer id){

       int   result= userService.delByid(id);
       System.out.println(result+"dddddddddddddddddd"+id);

         if (result>0){
             return  "成功";

         }
         return  "失败";
    }
    @RequestMapping(value = "/add",method = RequestMethod.POST)
   public  String add(User user){
     int result=  userService.addByall(user);
     System.out.println(user.getUsername());
     if (result>0){
      return  "redirect:/user/list";

     }
        return  "redirect:/user/addh";
   }


    @RequestMapping("/update")
    public  String update(User user){
        int result=  userService.alterByid(user);
       // System.out.println(user.getUsername());
        if (result>0){
            return  "redirect:/user/list";

        }
        return  "redirect:/user/updateh";
    }


}
