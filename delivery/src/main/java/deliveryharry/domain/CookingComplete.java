package deliveryharry.domain;

import deliveryharry.domain.*;
import deliveryharry.infra.AbstractEvent;
import java.util.*;
import lombok.*;

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
}
