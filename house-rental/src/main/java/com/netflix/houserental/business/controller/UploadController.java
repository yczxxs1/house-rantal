package com.netflix.houserental.business.controller;

import com.netflix.houserental.common.result.ResultUtil;
import com.netflix.houserental.common.result.ResultVo;
import com.netflix.houserental.common.util.ControllerFileUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;


@RestController
@RequestMapping("upload")
public class UploadController {

    @PostMapping(value = "/img")
    @ApiOperation(value = "上传图片")
    public ResultVo<String> uploadImg(@RequestParam("file") MultipartFile file)
            throws Exception {
        File destFile=ControllerFileUtils.transferToFile(file);
        return ResultUtil.success("/"+destFile.getName());

    }

}
