package cn.selforder.demo.Service;

import cn.selforder.demo.Dao.AuxiliaryRepository;
import cn.selforder.demo.Dao.OrdersMasterRepository;
import cn.selforder.demo.Dao.ShopMapper;
import cn.selforder.demo.Utils.Util;
import cn.selforder.demo.order.Auxiliary;
import cn.selforder.demo.order.OrdersMaster;
import cn.selforder.demo.order.Ordersmasters;
import cn.selforder.demo.order.allorder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class ShopService {

    @Autowired(required = false)
    ShopMapper shopMapper;

    @Autowired
    OrdersMasterRepository ordersMasterRepository;

    @Autowired
    AuxiliaryRepository auxiliaryRepository;

    @Autowired(required = false)
    Util util;

    public List<allorder> selectCartByUserid(String userid){
        return shopMapper.findorder(userid);
    }

    public List<allorder> findall(){
        return shopMapper.findall();
    }

    public List<allorder> findfail(){
        return shopMapper.findfail();
    }

    public List<allorder> findsucc(){
        return shopMapper.findsucc();
    }

    public OrdersMaster addorder(Ordersmasters ordersmasters){

        String id = util.getrandomid();
        Optional<OrdersMaster> optional = ordersMasterRepository.findByOrderId(id);
        while(optional.isPresent()){
            id = util.getrandomid();
            optional = ordersMasterRepository.findByOrderId(id);
        }
        OrdersMaster ordersMaster = new OrdersMaster();
        ordersMaster.setOrderId(id);
        ordersMaster.setWaiterId(ordersmasters.getWaiterid());
        ordersMaster.setUserId(ordersmasters.getUserid());
        ordersMaster.setTime(util.gettime());
        ordersMaster.setStatus(ordersmasters.getStatus());
        ordersMaster.setEndTime("---");
        ordersMaster.setAllprice(ordersmasters.getAllprice());
        ordersMasterRepository.save(ordersMaster);
        List<Auxiliary> auxiliaries = ordersmasters.getAuxiliarylist();
        for(Auxiliary auxiliary:auxiliaries){
            auxiliary.setOrderId(id);
            auxiliaryRepository.save(auxiliary);
        }
        return ordersMaster;

    }

    public void editstatus(String orderid,String newsatus){
        Optional<OrdersMaster> optional = ordersMasterRepository.findByOrderId(orderid);
        if(optional.isPresent()){
            OrdersMaster ordersMaster = optional.get();
            ordersMaster.setEndTime(util.gettime());
            ordersMaster.setStatus(newsatus);
            ordersMasterRepository.save(ordersMaster);
        }

    }


}
