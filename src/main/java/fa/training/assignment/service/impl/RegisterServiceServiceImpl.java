package fa.training.assignment.service.impl;

import fa.training.assignment.entity.ServiceUsage;
import fa.training.assignment.entity.pk.ServiceUsagePk;
import fa.training.assignment.repository.RegisterServiceRepository;
import fa.training.assignment.service.RegisterServiceService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegisterServiceServiceImpl implements RegisterServiceService {

    private final RegisterServiceRepository registerServiceRepository;

    @Autowired
    public RegisterServiceServiceImpl(RegisterServiceRepository registerServiceRepository) {
        this.registerServiceRepository = registerServiceRepository;
    }

    @Override
    public void save(ServiceUsage serviceUsage) {
        registerServiceRepository.save(serviceUsage);
    }

    @Override
    public ServiceUsage getServiceUsageById(ServiceUsagePk id) {
        return registerServiceRepository.findById(id).orElse(null);
    }

    @Override
    public List<ServiceUsage> getList() {
        return registerServiceRepository.findAll();
    }

    @Override
    public void deleteById(ServiceUsagePk id) {
        registerServiceRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAllByCustomerId(String customerId) {
        registerServiceRepository.deleteAllByCustomerId(customerId);
    }
}
