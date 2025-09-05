package com.ai.aicodemother.innerservice;

import com.xu.xuaicodeuser.exception.BusinessException;
import com.xu.xuaicodeuser.exception.ErrorCode;
import com.xu.xuaicodeuser.model.entity.User;
import com.xu.xuaicodeuser.model.vo.UserVO;
import jakarta.servlet.http.HttpServletRequest;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import static com.xu.xuaicodeuser.constant.UserConstant.USER_LOGIN_STATE;

/**
 * @author xu
 * @version 2.0
 * @CreateTime: 2025-09-05
 * 内部使用用户服务
 */
public interface InnerUserService {

    List<User> listByIds(Collection<? extends Serializable> ids);

    User getById(Serializable id);

    UserVO getUserVO(User user);

    // 静态方法，避免跨服务调用
    static User getLoginUser(HttpServletRequest request) {
        Object userObj = request.getSession().getAttribute(USER_LOGIN_STATE);
        User currentUser = (User) userObj;
        if (currentUser == null || currentUser.getId() == null) {
            throw new BusinessException(ErrorCode.NOT_LOGIN_ERROR);
        }
        return currentUser;
    }
}

