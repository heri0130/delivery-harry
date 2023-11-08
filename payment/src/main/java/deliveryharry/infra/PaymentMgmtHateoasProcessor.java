package deliveryharry.infra;

import deliveryharry.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class PaymentMgmtHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<PaymentMgmt>> {

    @Override
    public EntityModel<PaymentMgmt> process(EntityModel<PaymentMgmt> model) {
        return model;
    }
}
