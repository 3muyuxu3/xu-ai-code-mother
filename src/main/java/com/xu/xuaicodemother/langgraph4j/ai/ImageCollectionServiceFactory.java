package com.xu.xuaicodemother.langgraph4j.ai;

import com.xu.xuaicodemother.ai.AiCodeGenTypeRoutingService;
import com.xu.xuaicodemother.langgraph4j.tools.ImageSearchTool;
import com.xu.xuaicodemother.langgraph4j.tools.LogoGeneratorTool;
import com.xu.xuaicodemother.langgraph4j.tools.MermaidDiagramTool;
import com.xu.xuaicodemother.langgraph4j.tools.UndrawIllustrationTool;
import com.xu.xuaicodemother.utils.SpringContextUtil;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.service.AiServices;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xu
 * @version 1.0
 * @CreateTime: 2025-09-03
 */
@Slf4j
@Configuration
public class ImageCollectionServiceFactory {

    @Resource(name = "openAiChatModel")
    private ChatModel chatModel;

    @Resource
    private ImageSearchTool imageSearchTool;

    @Resource
    private UndrawIllustrationTool undrawIllustrationTool;

    @Resource
    private MermaidDiagramTool mermaidDiagramTool;

    @Resource
    private LogoGeneratorTool logoGeneratorTool;

    /**
     * 创建图片收集 AI 服务
     */
    @Bean
    public ImageCollectionService createImageCollectionService() {
        return AiServices.builder(ImageCollectionService.class)
                .chatModel(chatModel)
                .tools(
                        imageSearchTool,
                        undrawIllustrationTool,
                        mermaidDiagramTool,
                        logoGeneratorTool
                )
                .build();
    }
}