package cn.selforder.demo.Dao;

import cn.selforder.demo.order.TeaWithMilk;
import cn.selforder.demo.order.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users,String> {

    @Query(value = "SELECT userid,username,account,PASSWORD,phone,registrationtime FROM users WHERE phone = :phone",nativeQuery = true)
    public Optional<Users> findByPhone(@Param("phone") String phone);

    public Optional<Users> findByUserId(String id);
}
