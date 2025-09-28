# AI 零代码生成平台

作者：木羽栩 

# 项目介绍
基于SpringBoot+MyBatis Flex+LangChain4j+LangGraaph4j的AI零代码应用生成平台。用户输入自然语言，由AI Agent自动执行并发素材收集、代码生成、质量检查、项目构建的完整工作流，最后一键部署为可访问的Web应用。
## 核心能力
1）智能代码生成：用户输入需求描述，AI 自动分析并选择合适的生成策略，通过工具调用生成代码文件，采用流式输出让用户实时看到 AI 的执行过程。
2）可视化编辑：生成的应用将实时展示，可以进入编辑模式，自由选择网页元素并且和 AI 对话来快速修改页面。
3）一键部署分享：可以将生成的应用一键部署到云端并自动截取封面图，获得可访问的地址进行分享，同时支持完整项目源码下载。
4）企业级管理：提供用户管理、应用管理、系统监控、业务指标监控等后台功能，管理员可以设置精选应用、监控 AI 调用情况和系统性能。
# 使用技术栈
## 前端技术栈
### 核心框架
Vue3 + Ant Desidn Vue + Pinia + Axios
### 工程化
Vite + TypeScript + ESLint + Prettier + OpenAPI
## 后端技术栈
### 监控运维
ARMS 性能监控 + Prometheus 指标收集 + Grafana 可视化面板
### 核心框架
SpringBoot3.x + Java21
MyBatis Flex 数据访问
微服务:SpringCloud Alibaba +  Dubbo RPC调用 + Nacos注册中心 + Higress网关
### AI 技术
LangChain4j + LangGraph4j + Tool Calling + Guardrails护轨 + 文生图AI大模型
OpenAI + DeepSeek
### 数据存储
MySQL + Redis + Caffeine + COS 对象存储
### 设计模式
门面模式 + 策略模式 + 执行器 + 模板方法 + 工厂模式
### 工具库
Redisson + Selenium + jsoup + Lombok + Knife4j(Swagger) + Hutool工具库
