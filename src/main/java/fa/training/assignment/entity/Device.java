package fa.training.assignment.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "MAY")
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @NotBlank(message = "Mã máy không được bỏ trống!")
//    @Pattern(regexp = "^(M)[0-9]{3}$", message = "Mã máy phải bắt đầu bằng chữ M!")
    @Column(name = "MaMay")
    private Integer deviceId;

    @Column(name = "ViTri")
    @NotBlank(message = "Vị trí không được bỏ trống!")
    private String position;

    @Column(name = "TrangThai")
    @NotBlank(message = "Hãy chọn trạng thái!")
    private String status;

    @ToString.Exclude
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "device", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DeviceUsage> deviceUsages = new ArrayList<>();

    public Device(String position, String status) {
        this.position = position;
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Device)) {
            return false;
        }
        Device device = (Device) o;
        return Objects.equals(deviceId, device.deviceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deviceId);
    }
}
