package com.netflix.houserental.business.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.netflix.houserental.business.condition.Condition;
import com.netflix.houserental.business.form.RentalInfoPostForm;
import com.netflix.houserental.business.form.RentalInfoQueryForm;
import com.netflix.houserental.business.model.RentalInfo;
import com.netflix.houserental.business.service.RentalInfoService;
import com.netflix.houserental.common.result.PageVo;
import com.netflix.houserental.common.result.ResultUtil;
import com.netflix.houserental.common.result.ResultVo;
import com.netflix.houserental.common.util.ControllerFileUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.glasnost.orika.MapperFacade;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@RestController
@RequestMapping("rentalInfo")
@Api(tags = "房源信息")
public class RentalInfoController {

    private final RentalInfoService rentalInfoService;

    private final ModelMapper modelMapper;

    private final MapperFacade mapperFacade;

    @Autowired
    public RentalInfoController(RentalInfoService rentalInfoService, ModelMapper modelMapper,MapperFacade mapperFacade) {
        this.rentalInfoService = rentalInfoService;
        this.modelMapper = modelMapper;
        this.mapperFacade=mapperFacade;
    }


    @PostMapping
    @ApiOperation(value = "发布房源")
    public ResultVo<String> postRentalInfo(RentalInfoPostForm rentalInfoPostForm)
            throws Exception {
        RentalInfo rentalInfo=mapperFacade.map(rentalInfoPostForm, RentalInfo.class);
        rentalInfo.setHouseType(rentalInfo.getBedroomNum()+"室"+rentalInfo.getLivingRoomNum()+"厅"+rentalInfo.getBathroomNum()+"卫");
        rentalInfoService.postRentalInfo(rentalInfo);
        return ResultUtil.success();

    }


    @PostMapping("/includeImgs")
    @ApiOperation(value = "发布房源")
    public ResultVo<String> postRentalInfo(@RequestParam("file") MultipartFile[] files, @RequestParam String jsonStr)
            throws Exception {
        List<File> destFiles = ControllerFileUtils.transferToFileList(files);
        RentalInfoPostForm rentalInfoPostForm = JSON.parseObject(jsonStr, RentalInfoPostForm.class);
        rentalInfoPostForm.validate();// 校验表单数据
        RentalInfo rentalInfo=mapperFacade.map(rentalInfoPostForm, RentalInfo.class);
        rentalInfoService.postRentalInfo(rentalInfo,destFiles);
        return ResultUtil.success();

    }

    @GetMapping("/list")
    @ApiOperation(value = "查看列表")
    public ResultVo<PageVo<RentalInfo>> listRentalInfo(RentalInfoQueryForm rentalInfoQueryForm,
                                                  @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size) {
        PageHelper.startPage(page, size);
        PageInfo<RentalInfo> pageInfo = new PageInfo<>(rentalInfoService.listRentalInfo(modelMapper.map(rentalInfoQueryForm, Condition.class)));
        return ResultUtil.success(new PageVo<>(pageInfo));
    }


    @GetMapping("/{rentalInfoId}")
    @ApiOperation(value = "查看详情", notes = "rentalInfoId(在url上)")
    public ResultVo<RentalInfo> getRentalInfo(@PathVariable String rentalInfoId) {
        return ResultUtil.success(rentalInfoService.getRentalInfo(rentalInfoId));
    }

    @PostMapping("/{rentalInfoId}/remove")
    @ApiOperation(value = "删除", notes = "rentalInfoId(在url上)")
    public ResultVo<String> remove(@PathVariable String rentalInfoId) {
        rentalInfoService.removeRentalInfo(rentalInfoId);
        return ResultUtil.success();
    }

    @PostMapping("/{rentalInfoId}/edit")
    @ApiOperation(value = "编辑", notes = "rentalInfoId(在url上)")
    public ResultVo<String> edit(@PathVariable String rentalInfoId,RentalInfoPostForm rentalInfoPostForm) {
        RentalInfo rentalInfo=modelMapper.map(rentalInfoPostForm,RentalInfo.class);
        rentalInfo.setRentalInfoId(rentalInfoId);
        rentalInfoService.updateRentalInfo(rentalInfo);
        return ResultUtil.success();
    }
}
