package com.xu.xuaicodemother.service;

import jakarta.servlet.http.HttpServletResponse;

/**
 * @author xu
 * @version 1.0
 * @CreateTime: 2025-09-03
 */
public interface ProjectDownloadService {

    /**
     * 下载项目为压缩包
     *
     * @param projectPath 项目路径
     * @param downloadFileName 下载文件名
     * @param response 响应对象
     */
    void downloadProjectAsZip(String projectPath, String downloadFileName, HttpServletResponse response);
}
