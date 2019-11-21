package cn.selforder.demo.Controller;

import cn.selforder.demo.Dao.TeaMilkMapper;
import cn.selforder.demo.Service.TeaMilkService;
import cn.selforder.demo.api.TeaMilktApi;
import cn.selforder.demo.order.Charge;
import cn.selforder.demo.order.TeaWithMilk;
import cn.selforder.demo.order.tea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/milk")
@CrossOrigin
public class TeaMilktController implements TeaMilktApi {

    @Autowired
    TeaMilkService teaMilkService;

    @Override
    @PostMapping("/add")
    public void addmilk(@RequestBody tea tea){
        teaMilkService.addmilk(tea);
    }

    @Override
    @GetMapping("/selectall")
    public List<TeaWithMilk> init(){
        return teaMilkService.selectall();
    }

    @Override
    @GetMapping("/selectallattribute")
    public List<String> selectallattribute(){
        return teaMilkService.selectallattribute();
    }

    @Override
    @GetMapping("/selectmilkbyattribute/{attribute}")
    public List<TeaWithMilk> selectmilkbyattribute(@PathVariable("attribute") String attribute){
        return teaMilkService.selectmilkbyattribute(attribute);
    }

    @Override
    @GetMapping("/findcharge")
    public List<Charge> selectCharge(){
        return teaMilkService.selectCharge();
    }

    @Override
    @GetMapping("/delete/{teaid}")
    public void deletebyid(@PathVariable("teaid") String teaid){
        teaMilkService.deletebyteaid(teaid);
    }


}
