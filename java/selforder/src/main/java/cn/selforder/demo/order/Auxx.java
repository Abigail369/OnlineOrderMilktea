package cn.selforder.demo.order;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity
public class Auxx implements Serializable {

    @Id
    private String TeaName;
    private String CupType;
    private int Number;
    private String Charge;
    private String Temperature;
    private String Sugar;
    private int Price;
}
