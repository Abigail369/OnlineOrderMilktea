package cn.selforder.demo.api;

import cn.selforder.demo.order.Charge;
import cn.selforder.demo.order.OrdersMaster;
import cn.selforder.demo.order.Ordersmasters;
import cn.selforder.demo.order.allorder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Api("购物车接口")
public interface ShopApi {

//    @ApiOperation("通过用户id查找该用户的购物车")
//    public List<ShoppingCart> findCartByUserid(String userid);

//    @ApiOperation("添加物品进购物车")
//    public void addShop();

    @ApiOperation("根据用户id 查找用户的所有订单信息")
    public List<allorder> findorder(String userid);

    @ApiOperation("添加订单")
    public OrdersMaster addorder(Ordersmasters ordersmasters);

    @ApiOperation("查看所有订单")
    public List<allorder> findallorder();

    @ApiOperation("查看未完成所有订单")
    public List<allorder> findfail();

    @ApiOperation("查看完成所有订单")
    public List<allorder> findsucc();

    @ApiOperation("完成 或者 取消某订单")
    public void editstatus(String orderid,String newstatus);

    @ApiOperation("增加或修改小料信息")
    public void addcharge(Charge charge);

    @ApiOperation("删除小料")
    public void deletecharge(String id);

}
