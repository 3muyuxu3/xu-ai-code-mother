package com.xu.xuaicodemother.service;

/**
 * @author xu
 * @version 1.0
 * 截图服务接口
 */
public interface ScreenshotService {

    /**
     * 通用的截图服务，可以得到访问地址
     *
     * @param webUrl 网址
     * @return
     */
    String generateAndUploadScreenshot(String webUrl);
}
