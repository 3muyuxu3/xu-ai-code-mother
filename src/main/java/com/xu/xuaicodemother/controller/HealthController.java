package com.xu.xuaicodemother.controller;

import com.xu.xuaicodemother.common.BaseResponse;
import com.xu.xuaicodemother.common.ResultUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xu
 * @version 1.0
 * @CreateTime: 2025-08-31
 * 测试 knife4j 是否生效
 */
@RestController
@RequestMapping("/health")
public class HealthController {

    @GetMapping("/")
    public BaseResponse<String> healthCheck() {
        return ResultUtils.success( "ok");
    }
}
