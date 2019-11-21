package cn.selforder.demo.order;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "ShoppingCart")
public class ShoppingCart {

    @Id
    private String Id;
    @Column(name = "userid")
    private String UserId;
    @Column(name = "teaid")
    private String TeaId;
    private int Number;
    private String Charge;
    private String Temperature;
    private String Sugar;
    private int Price;
}
