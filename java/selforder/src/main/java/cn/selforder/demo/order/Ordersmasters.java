package cn.selforder.demo.order;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@ToString
public class Ordersmasters implements Serializable {

    @Id
    private String orderid;
    private String userid;
    private String waiterid;
    private String time;
    private String Status;
    private String endtime;
    private int allprice;
    @ElementCollection(targetClass = Auxiliary.class)
    public List<Auxiliary> auxiliarylist;
}
