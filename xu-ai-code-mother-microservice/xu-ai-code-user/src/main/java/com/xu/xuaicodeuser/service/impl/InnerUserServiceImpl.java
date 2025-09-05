package com.xu.xuaicodeuser.service.impl;

import com.ai.xuaicodemother.innerservice.InnerUserService;
import com.xu.xuaicodemother.model.entity.User;
import com.xu.xuaicodemother.model.vo.UserVO;
import com.xu.xuaicodeuser.service.UserService;
import jakarta.annotation.Resource;
import org.apache.dubbo.config.annotation.DubboService;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * @author xu
 * @version 1.0
 * @CreateTime: 2025-09-05
 */
@DubboService
public class InnerUserServiceImpl implements InnerUserService {

    @Resource
    private UserService userService;

    @Override
    public List<User> listByIds(Collection<? extends Serializable> ids) {
        return userService.listByIds(ids);
    }

    @Override
    public User getById(Serializable id) {
        return userService.getById(id);
    }

    @Override
    public UserVO getUserVO(User user) {
        return userService.getUserVO(user);
    }
}


