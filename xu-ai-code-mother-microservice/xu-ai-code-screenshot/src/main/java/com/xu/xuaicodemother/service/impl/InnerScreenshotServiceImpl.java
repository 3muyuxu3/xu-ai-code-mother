package com.xu.xuaicodemother.service.impl;

import com.ai.xuaicodemother.innerservice.InnerScreenshotService;
import com.xu.xuaicodemother.service.ScreenshotService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @author xu
 * @version 1.0
 * @CreateTime: 2025-09-05
 */
@DubboService
@Slf4j
public class InnerScreenshotServiceImpl implements InnerScreenshotService {

    @Resource
    private ScreenshotService screenshotService;

    @Override
    public String generateAndUploadScreenshot(String webUrl) {
        return screenshotService.generateAndUploadScreenshot(webUrl);
    }
}

