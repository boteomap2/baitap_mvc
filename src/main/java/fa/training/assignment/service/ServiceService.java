package fa.training.assignment.service;

import fa.training.assignment.entity.Service;
import java.util.List;

public interface ServiceService {
    void save(Service service);
    Service getServiceById(String id);
    List<Service> getList();
    void deleteById(String id);
}
