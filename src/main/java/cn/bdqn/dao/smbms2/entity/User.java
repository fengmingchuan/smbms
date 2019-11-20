package cn.bdqn.dao.smbms2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Long id;

    private String usercode;

    private String username;

    private String userpassword;

    private Integer gender;

    private Date birthday;

    private String phone;

    private String address;

    private Integer userrole;

    private Long createdby;

    private Date creationdate;

    private Long modifyby;

    private Date modifydate;

    private String idpicpath;

    private String wordpicpath;

}
