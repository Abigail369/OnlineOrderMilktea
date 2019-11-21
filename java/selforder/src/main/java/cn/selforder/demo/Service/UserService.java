package cn.selforder.demo.Service;

import cn.selforder.demo.Dao.UsersRepository;
import cn.selforder.demo.Dao.WaiterRepository;
import cn.selforder.demo.Utils.Util;
import cn.selforder.demo.model.response.CommonCode;
import cn.selforder.demo.model.response.Response;
import cn.selforder.demo.model.response.ResponseResult;
import cn.selforder.demo.order.Users;
import cn.selforder.demo.order.Waiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UsersRepository usersRepository;

    @Autowired(required = false)
    WaiterRepository waiterRepository;

    @Autowired(required = false)
    Util util;

    public ResponseResult register(Users users){
        String id = "U" + users.getPhone();
        Optional<Users> optionalUsers = usersRepository.findById(id);
        if(optionalUsers.isPresent()){
            return new ResponseResult(CommonCode.FAIL);
        }
        users.setUserId(id);
        users.setRegistrationTime(util.gettime());
        usersRepository.save(users);
        return new ResponseResult(CommonCode.SUCCESS);
    }

    public Users findUserByPhone(String phone){
        Optional<Users> optionalUsers = usersRepository.findByPhone(phone);
        if(optionalUsers.isPresent()){
            Users users= optionalUsers.get();
            return users;
        }
        return null;
    }

    public List<Waiter> findWaiter(){
        return waiterRepository.findAll();
    }

    public void updateWaiter(String id,String newname){
        Waiter waiter = waiterRepository.findByWaiterid(id);
        waiter.setWaiterName(newname);
        waiterRepository.save(waiter);
    }

    public void deletewaiter(String id){
        waiterRepository.deleteByWaiterid(id);
    }
}

