package com.linjun.yunjunrui.model;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

import java.io.Serializable;
/**
 * 作者：林俊 on 2017/8/5
 * 作用：用户的POJO类
 */
@Entity
public class Usermodel  implements Serializable {
@Id(autoincrement = true)
    private Long id;
    private  int userId;
    private String userName;
    private  String userEmail;
    private String userTel;
    private  String userPassWorld;
 @Generated(hash = 156285)
    public Usermodel(Long id, int userId, String userName, String userEmail, String userTel, String userPassWorld) {
        this.id = id;
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userTel = userTel;
        this.userPassWorld = userPassWorld;
    }
@Generated(hash = 5454554)
    public Usermodel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public String getUserPassWorld() {
        return userPassWorld;
    }

    public void setUserPassWorld(String userPassWorld) {
        this.userPassWorld = userPassWorld;
    }

    @Override
    public String toString() {
        return "Usermodel{" +
                "id=" + id +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userTel='" + userTel + '\'' +
                ", userPassWorld='" + userPassWorld + '\'' +
                '}';
    }
}
