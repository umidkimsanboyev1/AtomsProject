package uz.master.demotest.entity.auth;

import lombok.Getter;
import lombok.Setter;
import uz.master.demotest.entity.Auditable;

import javax.persistence.*;
import java.time.LocalTime;

@Getter
@Setter
@Entity
public class Token {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;


    @Column(name = "private_token", nullable = false)
    private String privateToken;

    @Column(name = "expire",columnDefinition = "time default current_time+interval'5 minute'")
    private LocalTime expire;

}
