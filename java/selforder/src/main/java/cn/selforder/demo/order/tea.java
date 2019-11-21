package cn.selforder.demo.order;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@Table(name = " teawithmilk")
public class tea {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String teaid;

    private String teaname;
    private String Attribute;
    private String Photo;
    private String cuptype;
    private Boolean Discount;
    private int Price;
}
