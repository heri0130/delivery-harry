package deliveryharry.domain;

import deliveryharry.domain.*;
import deliveryharry.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class CookingComplete extends AbstractEvent {

    private Long id;
    private String userId;
    private String menuName;
    private Integer menuQty;
    private Long orderId;
    private Long payId;
    private Integer amount;
    private String status;

    public CookingComplete(StoreOrderMgmt aggregate) {
        super(aggregate);
    }

    public CookingComplete() {
        super();
    }
}
//>>> DDD / Domain Event
