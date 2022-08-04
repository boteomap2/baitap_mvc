package fa.training.assignment.service;

import fa.training.assignment.entity.Device;
import java.util.List;

public interface DeviceService {
    void save(Device device);
    Device getDeviceById(Integer id);
    List<Device> getList();
    void deleteById(Integer id);

    List<Device> getInactiveList();

}
