package deliveryharry.domain;

import deliveryharry.domain.*;
import deliveryharry.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class PaymentCanceled extends AbstractEvent {

    private Long id;
    private Integer amount;
    private String userId;
    private Long orderId;
    private String status;

    public PaymentCanceled(PaymentMgmt aggregate) {
        super(aggregate);
    }

    public PaymentCanceled() {
        super();
    }
}
//>>> DDD / Domain Event
