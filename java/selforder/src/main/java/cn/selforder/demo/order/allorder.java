package cn.selforder.demo.order;

import lombok.Data;
import lombok.ToString;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@ToString
public class allorder implements Serializable {

    @Id
    private String OrderId;
    private String UserId;
    private String WaiterId;
    private String Time;
    private String Status;
    private String EndTime;
    private int allprice;
    @ElementCollection(targetClass = Auxx.class)
    public List<Auxx> auxxes;
}