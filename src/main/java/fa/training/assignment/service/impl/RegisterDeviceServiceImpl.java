package fa.training.assignment.service.impl;

import fa.training.assignment.entity.DeviceUsage;
import fa.training.assignment.entity.pk.DeviceUsagePk;
import fa.training.assignment.repository.RegisterDeviceRepository;
import fa.training.assignment.service.RegisterDeviceService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegisterDeviceServiceImpl implements RegisterDeviceService {

    private final RegisterDeviceRepository registerDeviceRepository;

    @Autowired
    public RegisterDeviceServiceImpl(RegisterDeviceRepository registerDeviceRepository) {
        this.registerDeviceRepository = registerDeviceRepository;
    }

    @Override
    public void save(DeviceUsage deviceUsage) {
        registerDeviceRepository.save(deviceUsage);
    }

    @Override
    public DeviceUsage getDeviceUsageById(DeviceUsagePk id) {
        return registerDeviceRepository.findById(id).orElse(null);
    }

    @Override
    public List<DeviceUsage> getList() {
        return registerDeviceRepository.findAll();
    }

    @Override
    public void deleteById(DeviceUsagePk id) {
        registerDeviceRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAllByCustomerId(String customerId) {
        registerDeviceRepository.deleteAllByCustomerId(customerId);
    }

    @Override
    @Transactional
    public void updateDeviceStatusBeforeDelete(String customerId) {
        registerDeviceRepository.updateDeviceStatusBeforeDelete(customerId);
    }
}
