# 木羽 AI 零代码生成平台

作者：木羽栩

## 项目介绍

基于 Spring Boot + MyBatis Flex + LangChain4j + LangGraph4j 的 AI 零代码应用生成平台。用户只需输入自然语言描述，AI Agent 即可自动完成素材收集、代码生成、质量检查、项目构建的完整工作流，最终一键部署为可访问的 Web 应用。

## 核心能力

1. 智能代码生成：用户输入需求描述，AI 自动分析并选择合适的生成策略（原生 HTML / 原生多文件 / Vue 工程），通过工具调用生成代码文件，采用 SSE 流式输出让用户实时看到 AI 的执行过程。
2. 可视化编辑：生成的应用实时展示，可进入编辑模式，自由选择网页元素并与 AI 对话，快速修改页面。
3. 一键部署分享：将生成的应用一键部署到云端并自动截取封面图，获得可访问的地址进行分享，同时支持完整项目源码下载。
4. 企业级管理：提供用户管理、应用管理、对话管理、系统监控、业务指标监控等后台功能，管理员可以设置精选应用、监控 AI 调用情况和系统性能。

## 工作流编排

平台基于 LangGraph4j 将代码生成流程编排为状态图，核心节点如下：

```
START
  -> image_collector     素材收集（Logo、插画、图表、内容配图等并发采集后聚合）
  -> prompt_enhancer     提示词增强
  -> router              智能路由，选择代码生成策略
  -> code_generator      代码生成
  -> code_quality_check  质量检查（AI 评审 + 程序校验）
       |-- build       质检通过且需要构建 -> project_builder
       |-- skip_build  质检通过但跳过构建 -> END
       |-- fail        质检失败 -> 回到 code_generator 重新生成
  -> project_builder     项目构建
  -> END
```

- 支持顺序工作流、并发工作流、子图工作流三种编排方式。
- 内置 LangGraph4j Studio 可视化调试配置，可查看流程图并逐步调试。
- 完整执行过程通过 SSE 实时推送给前端。

## 使用技术栈

### 后端技术栈

| 分类 | 技术 |
| --- | --- |
| 核心框架 | Spring Boot 3.5.x + Java 21 |
| 数据访问 | MyBatis Flex + HikariCP |
| AI 技术 | LangChain4j + LangGraph4j + Tool Calling + Guardrails 护轨 + 文生图 AI 大模型 |
| AI 模型 | 阿里云百炼（通义千问 qwen3-coder-plus / qwen3-max / qwen-turbo）+ DeepSeek |
| 微服务 | Spring Cloud Alibaba + Dubbo RPC + Nacos 注册中心 + Higress 网关 |
| 数据存储 | MySQL + Redis + Caffeine + 腾讯云 COS 对象存储 |
| 监控运维 | ARMS 性能监控 + Prometheus 指标收集 + Grafana 可视化面板 |
| 工具库 | Redisson + Selenium + jsoup + Hutool + Lombok |
| 接口文档 | Knife4j（OpenAPI 3 / Swagger） |
| 设计模式 | 门面模式 + 策略模式 + 执行器 + 模板方法 + 工厂模式 |

### 前端技术栈

| 分类 | 技术 |
| --- | --- |
| 核心框架 | Vue 3 + Ant Design Vue + Pinia + Vue Router + Axios |
| 工程化 | Vite + TypeScript + ESLint + Prettier + OpenAPI（openapi2ts 自动生成接口代码） |
| 内容渲染 | markdown-it + highlight.js |

## 项目结构

```
xu-ai-code-mother/
├── src/                                  # 后端主应用（单体，端口 8123）
│   └── main/java/com/xu/xuaicodemother/
│       ├── ai/                           # AI 服务、护轨、工具集、消息模型
│       ├── aop/                          # 鉴权、日志等切面
│       ├── config/                       # 通用配置
│       ├── controller/                   # 接口层（用户、应用、对话、静态资源等）
│       ├── core/                         # 代码解析、保存、构建核心逻辑
│       ├── langgraph4j/                  # LangGraph4j 工作流（节点、状态、配置）
│       ├── mapper/                       # MyBatis Flex 数据访问
│       ├── manager/                      # 通用业务管理器
│       ├── model/                        # 实体、DTO、VO、枚举
│       ├── monitor/                      # 业务指标监控
│       ├── ratelimit/                    # 接口限流（注解 + 切面）
│       ├── service/                      # 业务服务
│       └── utils/                        # 工具类
├── xu-ai-code-mother-frontend/           # 前端工程（Vue 3 + Vite）
├── xu-ai-code-mother-microservice/       # 微服务拆分工程
├── sql/create_table.sql                  # 数据库初始化脚本
├── grafana/ai_model_grafana_config.json  # Grafana 监控面板配置
├── prometheus.yml                        # Prometheus 采集配置
└── pom.xml                               # Maven 依赖管理
```

微服务工程模块划分：

```
xu-ai-code-mother-microservice/
├── xu-ai-code-common/      # 公共模块
├── xu-ai-code-model/       # 实体模型模块
├── xu-ai-code-client/      # 服务接口模块（Dubbo 接口定义）
├── xu-ai-code-user/        # 用户服务（端口 8124）
├── xu-ai-code-app/         # 应用服务（端口 8125）
├── xu-ai-code-ai/          # AI 代码生成服务
└── xu-ai-code-screenshot/  # 网页截图服务（端口 8127）
```

## 快速开始

### 环境要求

- JDK 21
- Maven 3.8+
- Node.js 20.19+ 或 22.12+
- MySQL 8.x
- Redis 5.x 及以上

### 1. 初始化数据库

```sql
source sql/create_table.sql
```

脚本会自动创建 `xu_ai_code_mother` 库以及用户表、应用表、对话历史表。

### 2. 启动后端

修改 `src/main/resources/application-local.yml` 中的 AI 模型、对象存储等配置（密钥需自行申请），

然后在项目根目录执行：

```bash
mvn spring-boot:run
```

后端启动后地址为 `http://localhost:8123/api`，接口文档地址为 `http://localhost:8123/api/doc.html`。

### 3. 启动前端

```bash
cd xu-ai-code-mother-frontend
npm install
npm run dev
```

前端开发服务器默认将 `/api` 代理到 `http://localhost:8123`，启动后访问控制台输出的地址即可。

## 功能模块

### 用户端

| 页面 | 说明 |
| --- | --- |
| 主页 | 展示精选应用，支持按名称搜索、查看详情 |
| 应用对话页 | 输入自然语言生成应用，SSE 实时展示生成过程，支持可视化编辑与部署分享 |
| 用户登录 / 注册 | 账号密码登录，会话基于 Redis 存储 |

### 管理端

| 页面 | 说明 |
| --- | --- |
| 应用管理 | 应用的增删改查、设置精选与优先级、查看应用详情 |
| 用户管理 | 用户增删改查、重置密码、设置角色 |
| 对话管理 | 查看全部对话历史记录 |

## 主要接口

| 方法 | 路径 | 说明 |
| --- | --- | --- |
| POST | /user/register | 用户注册 |
| POST | /user/login | 用户登录 |
| POST | /user/logout | 用户注销 |
| GET | /user/get/login | 获取当前登录用户 |
| POST | /app/add | 创建应用 |
| GET | /app/chat/gen/code | AI 生成代码（SSE 流式返回） |
| POST | /app/deploy | 部署应用并生成截图 |
| GET | /app/download/{appId} | 下载应用源码 |
| POST | /app/my/list/page/vo | 分页查询我的应用 |
| POST | /app/good/list/page/vo | 分页查询精选应用 |
| GET | /app/get/vo | 查询应用详情 |
| GET | /chatHistory/app/{appId} | 查询应用的对话历史 |
| POST | /workflow/execute | 执行代码生成工作流 |
| GET | /workflow/execute-flux | 执行工作流（SSE 流式返回） |
| GET | /static/{deployKey}/** | 访问已部署应用 |

完整接口定义以 Knife4j 文档为准。

## 设计要点

- 策略模式：根据用户需求自动选择代码生成策略，三种模式（原生 HTML、原生多文件、Vue 工程）分别对应不同的解析器、保存器与构建器。
- 流式输出：基于 SSE + Reactor Flux 实现 AI 响应的实时推送，支持文本流与结构化消息流两种处理器。
- 并发素材收集：图片收集节点内部拆分为 Logo、插画、图表、内容配图等多个子任务并行执行，再统一聚合。
- 护轨机制：通过 LangChain4j Guardrails 对输入输出进行安全校验，保证生成内容合规。
- 限流保护：基于注解 + AOP + Redisson 实现接口级别的限流。
- 监控体系：通过 Micrometer 暴露 Prometheus 指标，结合 Grafana 面板监控 AI 模型调用情况与系统性能。

## 作者

木羽栩
