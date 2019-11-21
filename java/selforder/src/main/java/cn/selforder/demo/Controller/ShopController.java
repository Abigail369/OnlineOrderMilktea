package cn.selforder.demo.Controller;

import cn.selforder.demo.Dao.ChargeRepository;
import cn.selforder.demo.Dao.ShopMapper;
import cn.selforder.demo.Service.ShopService;
import cn.selforder.demo.api.ShopApi;
import cn.selforder.demo.order.Charge;
import cn.selforder.demo.order.OrdersMaster;
import cn.selforder.demo.order.Ordersmasters;
import cn.selforder.demo.order.allorder;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shop")
@CrossOrigin
public class ShopController implements ShopApi {

    @Autowired
    ShopService shopService;


    @Override
    @GetMapping("findorder/{userid}")
    public List<allorder> findorder(@PathVariable("userid") String userid){
        return shopService.selectCartByUserid(userid);
    }

    @Override
    @GetMapping("findallorder")
    public List<allorder> findallorder(){
        return shopService.findall();
    }

    @Override
    @GetMapping("findfail")
    public List<allorder> findfail(){
        return shopService.findfail();
    }

    @Override
    @GetMapping("findsucc")
    public List<allorder> findsucc(){
        return shopService.findsucc();
    }

    @Override
    @GetMapping("complete/{orderid}/{newstatus}")
    public void editstatus(@PathVariable("orderid") String orderid,@PathVariable("newstatus") String newstatus){
        shopService.editstatus(orderid,newstatus);
    }

    @Override
    @PostMapping("addorder")
    public OrdersMaster addorder(@RequestBody Ordersmasters ordersmasters){
        return shopService.addorder(ordersmasters);
    }

    @Autowired
    ChargeRepository chargeRepository;

    @Override
    @PostMapping("addcharge")
    public void addcharge(@RequestBody Charge charge){
        chargeRepository.save(charge);
    }

    @Override
    @DeleteMapping("deletecharge/{id}")
    public void deletecharge(@PathVariable("id") String id){
        chargeRepository.deleteByChargeId(id);
    }
}
