package cn.selforder.demo.order;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@ToString
//@Table(name = "Auxiliary")
public class Auxiliary implements Serializable {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String Id;
    @Column(name = "orderid")
    private String OrderId;
    @Column(name = "teaid")
    private String TeaId;
    private int Number;
    private String Charge;
    private String Temperature;
    private String Sugar;
    private int Price;

}
