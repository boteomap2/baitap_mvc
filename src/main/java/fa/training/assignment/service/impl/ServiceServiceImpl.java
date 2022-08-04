package fa.training.assignment.service.impl;

import fa.training.assignment.entity.Service;
import fa.training.assignment.repository.ServiceRepository;
import fa.training.assignment.service.ServiceService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class ServiceServiceImpl implements ServiceService {
    private final ServiceRepository serviceRepository;

    @Autowired
    public ServiceServiceImpl(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    @Override
    public void save(Service service) {
        serviceRepository.save(service);
    }

    @Override
    public Service getServiceById(String id) {
        return serviceRepository.findById(id).orElse(null);
    }

    @Override
    public List<Service> getList() {
        return serviceRepository.findAll();
    }

    @Override
    public void deleteById(String id) {
        serviceRepository.deleteById(id);
    }
}
