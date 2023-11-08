package deliveryharry.domain;

import deliveryharry.OrderApplication;
import deliveryharry.domain.OrderCancelled;
import deliveryharry.domain.Ordered;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "OrderMgmt_table")
@Data
//<<< DDD / Aggregate Root
public class OrderMgmt {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userId;

    private String menuName;

    private Integer menuQty;

    private Integer amount;

    private String status;

    private String address;

    @PostPersist
    public void onPostPersist() {
        Ordered ordered = new Ordered(this);
        ordered.publishAfterCommit();
    }

    @PostUpdate
    public void onPostUpdate() {
        OrderCancelled orderCancelled = new OrderCancelled(this);
        orderCancelled.publishAfterCommit();
    }

    public static OrderMgmtRepository repository() {
        OrderMgmtRepository orderMgmtRepository = OrderApplication.applicationContext.getBean(
            OrderMgmtRepository.class
        );
        return orderMgmtRepository;
    }
}
//>>> DDD / Aggregate Root
