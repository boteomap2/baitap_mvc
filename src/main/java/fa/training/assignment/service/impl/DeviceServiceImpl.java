package fa.training.assignment.service.impl;

import fa.training.assignment.entity.Device;
import fa.training.assignment.repository.DeviceRepository;
import fa.training.assignment.service.DeviceService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeviceServiceImpl implements DeviceService {

    private final DeviceRepository deviceRepository;

    @Autowired
    public DeviceServiceImpl(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    @Override
    public void save(Device device) {
        deviceRepository.save(device);
    }

    @Override
    public Device getDeviceById(Integer id) {
        return deviceRepository.findById(id).orElse(null);
    }

    @Override
    public List<Device> getList() {
        return deviceRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        deviceRepository.deleteById(id);
    }

    @Override
    public List<Device> getInactiveList() {
        return deviceRepository.getInactiveList();
    }
}
