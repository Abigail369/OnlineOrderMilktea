package cn.selforder.demo.Service;

import cn.selforder.demo.Dao.TeaMilkMapper;
import cn.selforder.demo.Dao.TeaMilkRepository;
import cn.selforder.demo.order.Charge;
import cn.selforder.demo.order.TeaWithMilk;
import cn.selforder.demo.order.tea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeaMilkService {

    @Autowired(required = false)
    TeaMilkMapper teaMilkMapper;
    @Autowired(required = false)
    TeaMilkRepository teaMilkRepository;


    public List<TeaWithMilk> selectall(){
        return teaMilkMapper.init();
//        return asd.sl();
    }

    public void addmilk(tea tea){
        teaMilkRepository.save(tea);
    }

    public List<String> selectallattribute(){
        return teaMilkMapper.selectallattribute();
    }

    public List<TeaWithMilk> selectmilkbyattribute(String attribute){

        if(attribute.equals("1")){
            return teaMilkMapper.selectmilkByDis("1");
        }
        return teaMilkMapper.selectmilkByattribute(attribute);
    }

    public List<Charge> selectCharge(){
        return teaMilkMapper.selectCharge();
    }

    public void deletebyteaid(String teaid){
        teaMilkRepository.deleteByteaid(teaid);
    }
}
