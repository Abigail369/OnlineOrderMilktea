package cn.selforder.demo.Dao;

import cn.selforder.demo.order.Ordersmasters;
import cn.selforder.demo.order.allorder;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShopMapper {

    public List<allorder> findorder(String usersid);

    public List<allorder> findall();

    public List<allorder> findfail();

    public List<allorder> findsucc();
}
