package com.xu.xuaicodemother.model.dto.user;

import lombok.Data;

import java.io.Serializable;

/**
 * @author xu
 * @version 2.0
 * @CreateTime: 2025-09-01
 * 用户登陆
 */
@Data
public class UserLoginRequest implements Serializable {

    private static final long serialVersionUID = 3191241716373120793L;

    /**
     * 账号
     */
    private String userAccount;

    /**
     * 密码
     */
    private String userPassword;
}
