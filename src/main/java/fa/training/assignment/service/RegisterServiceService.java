package fa.training.assignment.service;

import fa.training.assignment.entity.ServiceUsage;
import fa.training.assignment.entity.pk.ServiceUsagePk;
import java.util.List;

public interface RegisterServiceService {
    void save(ServiceUsage serviceUsage);
    ServiceUsage getServiceUsageById(ServiceUsagePk id);
    List<ServiceUsage> getList();
    void deleteById(ServiceUsagePk id);
    void deleteAllByCustomerId(String customerId);
}
