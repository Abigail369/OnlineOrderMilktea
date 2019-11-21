package cn.selforder.demo.Dao;

import cn.selforder.demo.order.Charge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import javax.transaction.Transactional;

@Transactional
public interface ChargeRepository extends JpaRepository<Charge,String> {

    @Modifying
    public void deleteByChargeId(String id);
}
