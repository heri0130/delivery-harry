package deliveryharry.domain;

import deliveryharry.domain.*;
import deliveryharry.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class Ordered extends AbstractEvent {

    private Long id;
    private String userId;
    private String menuName;
    private Integer menuQty;
    private Integer amount;
    private String status;
    private String address;

    public Ordered(OrderMgmt aggregate) {
        super(aggregate);
    }

    public Ordered() {
        super();
    }
}
//>>> DDD / Domain Event
