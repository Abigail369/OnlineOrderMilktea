package cn.selforder.demo.order;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Teawithmilk")
public class TeaWithMilk {

    @Id
    @Column(name = "teaid")
    private String teaId;

    @Column(name = "teaname")
    private String TeaName;
    private String Attribute;
    private String Photo;
    @Column(name = "cuptype")
    private String CupType;
    private Boolean Discount;
    private int count = 0;
    private int Price;
}
