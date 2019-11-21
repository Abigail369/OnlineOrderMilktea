package cn.selforder.demo.Dao;

import cn.selforder.demo.order.Charge;
import cn.selforder.demo.order.TeaWithMilk;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TeaMilkMapper {

    public List<TeaWithMilk> init();

    public void addmilk(TeaWithMilk teaWithMilk);


    public List<String> selectallattribute();

    List<TeaWithMilk> selectmilkByattribute(String attribute);

    List<TeaWithMilk> selectmilkByDis(String Discount);

    List<Charge> selectCharge();
}
