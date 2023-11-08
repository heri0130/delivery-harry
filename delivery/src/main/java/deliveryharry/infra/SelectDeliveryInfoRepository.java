package deliveryharry.infra;

import deliveryharry.domain.*;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
    collectionResourceRel = "selectDeliveryInfos",
    path = "selectDeliveryInfos"
)
public interface SelectDeliveryInfoRepository
    extends PagingAndSortingRepository<SelectDeliveryInfo, Long> {}
