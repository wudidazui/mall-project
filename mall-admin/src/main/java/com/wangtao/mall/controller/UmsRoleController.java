package com.wangtao.mall.controller;
import com.wangtao.mall.common.api.CommonPage;
import com.wangtao.mall.common.api.CommonResult;
import com.wangtao.mall.model.UmsMenu;
import com.wangtao.mall.model.UmsResource;
import com.wangtao.mall.model.UmsRole;
import com.wangtao.mall.service.UmsRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * 后台用户角色管理Controller
 */

@Controller
@Api(tags = "UmsRoleController")
@Tag(name = "UmsRoleController",description = "后台用户角色管理")
@RequestMapping("/role")
public class UmsRoleController {

    @Autowired
    private UmsRoleService roleService;

    @ApiOperation("添加角色")
    @RequestMapping(value = "/create",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody UmsRole role){
       int count = roleService.create(role);
       if(count > 0){
           return CommonResult.success(count);
       }
       return CommonResult.failed();
    };


    @ApiOperation("修改角色")
    @RequestMapping(value = "/update/{id}",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable Long id, @RequestBody UmsRole role) {
        int count = roleService.update(id,role);
        if(count >0){
            return CommonResult.success(count);
        }else{
            return CommonResult.failed();
        }
    }

    @ApiOperation("批量删除角色")
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@RequestParam("ids") List<Long> ids){
       int count = roleService.delete(ids);
       if(count > 0){
           return CommonResult.success(count);
       }else{
           return CommonResult.failed();
       }
    };

    @ApiOperation("获取所有角色")
    @RequestMapping(value = "/listAll",method = RequestMethod.GET)
    @ResponseBody
    CommonResult listAll(){
        List<UmsRole> roleList = roleService.listAll();
        return CommonResult.success(roleList);
    }

    @ApiOperation("根据角色名称分页获取角色列表")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult list(@RequestParam(value = "keyword",required = false) String keyword,
                             @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize,
                             @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum){
        List<UmsRole> roleList = roleService.list(keyword,pageNum,pageSize);
        return  CommonResult.success(CommonPage.restPage(roleList));
    }

    @ApiOperation("修改角色状态")
    @RequestMapping(value="/updateStatus/{id}",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateStatus(@PathVariable("id") Long id,@RequestParam("status") Integer status){
        UmsRole umsRole = new UmsRole();
        umsRole.setStatus(status);
        int count = roleService.update(id,umsRole);
        if(count > 0){
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    };

    @ApiOperation("获取角色相关菜单")
    @RequestMapping(value = "/listMenu/{roleId}",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult listMenu(@PathVariable Long roleId){
        List<UmsMenu> roleList = roleService.listMenu(roleId);
        return CommonResult.success(roleList);
    }

    @ApiOperation("获取角色相关资源")
    @RequestMapping(value = "/listResource/{roleId}",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<UmsResource>> listResource(@PathVariable Long roleId){
        List<UmsResource> roleList = roleService.listResource(roleId);
        return CommonResult.success(roleList);
    }

    @ApiOperation("给角色分配菜单")
    @RequestMapping(value = "/allocMenu",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult allocMenu(@RequestParam Long roleId,@RequestParam List<Long> menuIds){
        int count = roleService.allocMenu(roleId,menuIds);
        return CommonResult.success(count);
    }

    @ApiOperation("给角色分配资源")
    @RequestMapping(value = "/allocResource",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult allowResource(@RequestParam Long roleId,@RequestParam List<Long> resourceIds){
        int count = roleService.allocResource(roleId,resourceIds);
        return CommonResult.success(count);
    }
}
