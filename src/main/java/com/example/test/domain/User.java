package com.example.test.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Date:Created by luzy on 2018/4/23.
 * @Description:
 */
@Entity
@Table(name ="user",
        uniqueConstraints={@UniqueConstraint(columnNames={"loginName"})},    //唯一约束
        indexes = {@Index(columnList = "roleId")})  //为字段roleId加上索引
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //主键由数据库自动生成（主要是自动增长型）
    private long id;
    @Column(nullable=false,length=255)
    String loginName;
    @Column(nullable=false)
    String password;
    @Column(nullable=true,length=255)
    String name;
    @Column
    int status;
    @Column(nullable=true)
    String phone;
    @Column(nullable=true)
    Date lastTime;
    @Column(nullable=true)
    Date ctime;
    @Column(nullable=true)
    String descripe;
    @Column(nullable=true)
    int isDelete;
    @Column()
    int roleId;

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public String getDescripe() {
        return descripe;
    }

    public void setDescripe(String descripe) {
        this.descripe = descripe;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", loginName='" + loginName + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", phone='" + phone + '\'' +
                ", lastTime=" + lastTime +
                ", ctime=" + ctime +
                ", descripe='" + descripe + '\'' +
                ", isDelete=" + isDelete +
                '}';
    }
}
