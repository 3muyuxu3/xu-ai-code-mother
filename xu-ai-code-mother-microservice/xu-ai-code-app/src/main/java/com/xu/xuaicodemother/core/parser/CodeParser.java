package com.xu.xuaicodemother.core.parser;

/**
 * @author xu
 * @version 2.0
 * @CreateTime: 2025-09-01
 * 代码解析器策略接口
 */
public interface CodeParser<T> {

    /**
     * 解析代码内容
     *
     * @param codeContent 原始代码内容
     * @return 解析后的结果对象
     */
    T parseCode(String codeContent);
}
