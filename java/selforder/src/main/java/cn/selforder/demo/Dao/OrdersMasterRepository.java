package cn.selforder.demo.Dao;

import cn.selforder.demo.order.OrdersMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
public interface OrdersMasterRepository extends JpaRepository<OrdersMaster,String> {

    @Query(value = "UPDATE ordersmaster a SET a.Status = :newstatus WHERE orderid = :orderid",nativeQuery = true)
    @Modifying
    public void complete(@Param("orderid") String orderid,@Param("newstatus") String newstatus);

    public Optional<OrdersMaster> findByOrderId(String id);
}
