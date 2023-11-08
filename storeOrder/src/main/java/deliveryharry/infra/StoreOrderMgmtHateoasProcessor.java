package deliveryharry.infra;

import deliveryharry.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class StoreOrderMgmtHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<StoreOrderMgmt>> {

    @Override
    public EntityModel<StoreOrderMgmt> process(
        EntityModel<StoreOrderMgmt> model
    ) {
        return model;
    }
}
