package com.xu.xuaicodemother.langgraph4j.config;

import com.xu.xuaicodemother.langgraph4j.CodeGenWorkflow;
import org.bsc.langgraph4j.GraphStateException;
import org.bsc.langgraph4j.studio.springboot.AbstractLangGraphStudioConfig;
import org.bsc.langgraph4j.studio.springboot.LangGraphFlow;
import org.springframework.context.annotation.Configuration;

/**
 * @author xu
 * @version 1.0
 * @CreateTime: 2025-09-03
 * 可视化调试配置
 */
@Configuration
public class LangGraphStudioSampleConfig extends AbstractLangGraphStudioConfig {

    final LangGraphFlow flow;

    public LangGraphStudioSampleConfig() throws GraphStateException {
        var workflow = new CodeGenWorkflow().createWorkflow().stateGraph;
        // define your workflow
        this.flow = LangGraphFlow.builder()
                .title("LangGraph Studio")
                .stateGraph(workflow)
                .build();
    }

    @Override
    public LangGraphFlow getFlow() {
        return this.flow;
    }
}

