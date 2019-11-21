package cn.selforder.demo.Controller;

import cn.selforder.demo.Dao.TeaMilkMapper;
import cn.selforder.demo.Service.UserService;
import cn.selforder.demo.api.UserApi;
import cn.selforder.demo.model.response.ResponseResult;
import cn.selforder.demo.order.Users;
import cn.selforder.demo.order.Waiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController implements UserApi {

    @Autowired(required = false)
    UserService userService;

    @Autowired(required = false)
    TeaMilkMapper teaMilkMapper;

    @Override
    @PostMapping("/register")
    public ResponseResult register(@RequestBody Users users){
         return userService.register(users);
    }

    @Override
    @GetMapping("/finduser/{phone}")
    public Users findUserByPhone(@PathVariable("phone") String phone) {
            return userService.findUserByPhone(phone);
    }

    @Override
    @GetMapping("/findwaiter")
    public List<Waiter> findWaiter(){
        return userService.findWaiter();
    }

    @Override
    @GetMapping("/updatewaiter/{id}/{newname}")
    public void updateWaiter(@PathVariable("id")String id,@PathVariable("newname") String newname){
        userService.updateWaiter(id,newname);
    }

    @Override
    @GetMapping("/deleteewaiter/{id}")
    public void deletewaiter(@PathVariable("id") String id){
        userService.deletewaiter(id);
    }
}
