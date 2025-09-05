package com.xu.xuaicodemother.core.saver;

import cn.hutool.core.util.StrUtil;
import com.xu.xuaicodemother.ai.model.HtmlCodeResult;
import com.xu.xuaicodemother.exception.BusinessException;
import com.xu.xuaicodemother.exception.ErrorCode;
import com.xu.xuaicodemother.model.enums.CodeGenTypeEnum;

/**
 * @author xu
 * @version 2.0
 * @CreateTime: 2025-09-01
 * HTML代码文件保存器
 */
public class HtmlCodeFileSaverTemplate extends CodeFileSaverTemplate<HtmlCodeResult> {

    @Override
    protected CodeGenTypeEnum getCodeType() {
        return CodeGenTypeEnum.HTML;
    }

    @Override
    protected void saveFiles(HtmlCodeResult result, String baseDirPath) {
        // 保存 HTML 文件
        writeToFile(baseDirPath, "index.html", result.getHtmlCode());
    }

    @Override
    protected void validateInput(HtmlCodeResult result) {
        super.validateInput(result);
        // HTML 代码不能为空
        if (StrUtil.isBlank(result.getHtmlCode())) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "HTML代码内容不能为空");
        }
    }
}
