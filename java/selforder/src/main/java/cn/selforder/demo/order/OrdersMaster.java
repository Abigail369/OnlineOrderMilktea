package cn.selforder.demo.order;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Ordersmaster")
public class OrdersMaster {

    @Id
    @Column(name = "orderid")
    private String orderId;
    @Column(name = "waiterid")
    private String WaiterId;
    @Column(name = "Userid")
    private String UserId;
    private String Time;
    private String Status;
    @Column(name = "endtime")
    private String EndTime;
    private int allprice;
}
