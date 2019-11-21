package cn.selforder.demo.order;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Charge")
public class Charge {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name = "chargeid")
    private String chargeId;
    @Column(name = "chargename")
    private String ChargeName;
    private int Price;
}
