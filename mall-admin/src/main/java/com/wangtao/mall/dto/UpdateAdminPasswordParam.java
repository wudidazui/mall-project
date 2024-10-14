package com.wangtao.mall.dto;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import lombok.Value;

import javax.validation.constraints.NotEmpty;

@Data
public class UpdateAdminPasswordParam {
    @NotEmpty
    @ApiModelProperty(value = "用户名",required = true)
    private String username;
    @NotEmpty
    @ApiModelProperty(value = "旧密码",required = true)
    private String oldPassword;
    @NotEmpty
    @ApiModelProperty(value = "新密码",required = true)
    private String newPassword;
}
