package cn.selforder.demo.Dao;

import cn.selforder.demo.order.tea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import javax.transaction.Transactional;

@Transactional
public interface TeaMilkRepository extends JpaRepository<tea,String> {

    @Modifying
    public void deleteByteaid(String id);




}
