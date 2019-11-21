package cn.selforder.demo.order;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@Table(name = "waiter")
public class Waiter {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String waiterid;
    @Column(name = "waitername")
    private String WaiterName;
    private String Password;

}
