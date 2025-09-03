package com.xu.xuaicodemother.service;

import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.core.service.IService;
import com.xu.xuaicodemother.model.dto.app.AppQueryRequest;
import com.xu.xuaicodemother.model.entity.App;
import com.xu.xuaicodemother.model.entity.User;
import com.xu.xuaicodemother.model.vo.AppVO;
import reactor.core.publisher.Flux;

import java.util.List;

/**
 * 应用 服务层。
 *
 * @author <a href="https://github.com/Gosling-bit">程序员栩</a>
 */
public interface AppService extends IService<App> {

    /**
     * 部署应用
     *
     * @param appId     应用 ID
     * @param loginUser 登录用户
     * @return 部署访问 URL
     */
    String deployApp(Long appId, User loginUser);

    /**
     * 异步生成应用截图并更新封面
     *
     * @param appId  应用ID
     * @param appUrl 应用访问URL
     */
    void generateAppScreenshotAsync(Long appId, String appUrl);

    /**
     * 对话生成应用代码
     *
     * @param appId     应用 ID
     * @param message   用户消息
     * @param LoginUser 登录用户
     * @return
     */
    Flux<String> chatToGenCode(Long appId, String message, User LoginUser);

    /**
     * 获取应用封装类
     *
     * @param app
     * @return
     */
    AppVO getAppVO(App app);

    /**
     * 获取应用封装类列表
     *
     * @param appList
     * @return
     */
    List<AppVO> getAppVOList(List<App> appList);

    /**
     * 构建应用查询条件
     *
     * @param appQueryRequest
     * @return
     */
    QueryWrapper getQueryWrapper(AppQueryRequest appQueryRequest);
}
