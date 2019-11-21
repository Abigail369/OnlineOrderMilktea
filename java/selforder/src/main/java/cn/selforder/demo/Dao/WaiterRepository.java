package cn.selforder.demo.Dao;


import cn.selforder.demo.order.Waiter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface WaiterRepository extends JpaRepository<Waiter,String> {

    public List<Waiter> findAll();

    public Waiter findByWaiterid(String id);

    @Modifying
    public void deleteByWaiterid(String id);
}
