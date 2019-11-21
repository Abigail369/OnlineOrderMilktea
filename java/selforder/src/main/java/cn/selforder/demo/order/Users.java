package cn.selforder.demo.order;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.GenericGenerators;

import javax.persistence.*;


@Data
@Entity
@Table(name = "users")
public class Users {

    @Id
    @Column(name = "userid")
    private String userId;
    @Column(name = "username")
    private String UserName;

    private String Account;

    private String Password;

    private String Phone;

    @Column(name = "Registrationtime")
    private String RegistrationTime;



}
