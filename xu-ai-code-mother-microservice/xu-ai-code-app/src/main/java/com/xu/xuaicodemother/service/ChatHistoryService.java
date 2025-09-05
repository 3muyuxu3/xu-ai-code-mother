package com.xu.xuaicodemother.service;

import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.core.service.IService;
import com.xu.xuaicodemother.model.dto.chathistory.ChatHistoryQueryRequest;
import com.xu.xuaicodemother.model.entity.ChatHistory;
import com.xu.xuaicodemother.model.entity.User;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;

import java.time.LocalDateTime;

/**
 * 对话历史 服务层。
 *
 * @author <a href="https://github.com/Gosling-bit">程序员栩</a>
 */
public interface ChatHistoryService extends IService<ChatHistory> {

    /**
     * 添加聊天消息
     *
     * @param appId       应用ID
     * @param userId      用户ID
     * @param message     消息内容
     * @param messageType 消息类型（user/ai）
     * @return 是否添加成功
     */
    boolean addChatMessage(Long appId, String message, String messageType, Long userId);

    /**
     * 根据应用ID删除对话历史
     *
     * @param appId 应用ID
     * @return
     */
    boolean deleteByAppId(Long appId);

    /**
     * 分页获取应用的对话历史
     *
     * @param appId          应用ID
     * @param pageSize       每页大小
     * @param lastCreateTime 游标 - 上一页最后一条记录的创建时间
     * @param loginUser      登录用户
     * @return 聊天记录分页
     */
    Page<ChatHistory> listAppChatHistoryByPage(Long appId, int pageSize,
                                               LocalDateTime lastCreateTime,
                                               User loginUser);

    /**
     * 将对话历史加载到内存中
     *
     * @param appId       应用ID
     * @param chatMemory  对话记忆对象
     * @param maxCount    最大加载数量
     * @return 实际加载数量
     */
    int loadChatHistoryToMemory(Long appId, MessageWindowChatMemory chatMemory, int maxCount);

    /**
     * 构造查询条件
     *
     * @param chatHistoryQueryRequest
     * @return
     */
    QueryWrapper getQueryWrapper(ChatHistoryQueryRequest chatHistoryQueryRequest);
}
