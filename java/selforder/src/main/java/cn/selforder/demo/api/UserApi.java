package cn.selforder.demo.api;


import cn.selforder.demo.model.response.ResponseResult;
import cn.selforder.demo.order.Users;
import cn.selforder.demo.order.Waiter;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.HashMap;
import java.util.List;

@Api("用户接口")
public interface UserApi {

    @ApiOperation("用户注册, 传入用户信息，并往数据库中添加，无返回值")
    public ResponseResult register(Users users);

    @ApiOperation("查找个人信息  ，传入手机号，返回用户的个人信息")
    public Users findUserByPhone(String phone);

    @ApiOperation("查找店员信息")
    public List<Waiter> findWaiter();

    @ApiOperation("修改信息")
    public void updateWaiter(String id,String newname);

    @ApiOperation("删除信息")
    public void deletewaiter(String id);

}
