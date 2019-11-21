package cn.selforder.demo.api;


import cn.selforder.demo.order.Charge;
import cn.selforder.demo.order.TeaWithMilk;
import cn.selforder.demo.order.tea;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

@Api(value = "对奶茶的管理" ,description = "---")
public interface TeaMilktApi {

    @ApiOperation("添加,或者修改奶茶 奶茶")
    public void addmilk(tea tea);

    @ApiOperation("下架奶茶信息")
    public void deletebyid(String tedid);

    @ApiOperation("查询")
    public List<TeaWithMilk> init();

    @ApiOperation("查询所有种类的名称")
    public List<String> selectallattribute();

    @ApiOperation("根据奶茶类型查询所有奶茶")
    public List<TeaWithMilk> selectmilkbyattribute(String attribute);

    @ApiOperation("查找小料")
    public List<Charge> selectCharge();
}
