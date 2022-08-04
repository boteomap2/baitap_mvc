package fa.training.assignment.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "KHACHHANG")
public class Customer {
    @Id
    @GenericGenerator(name = "cusIdGen", strategy = "fa.training.assignment.utils.CustomerIdGenerator")
    @GeneratedValue(generator = "cusIdGen")
//    @Pattern(regexp = "^(KH)[0-9]{5}$", message = "Mã khách hàng phải bắt đầu bằng KH và 5 chữ số!")
//    @NotBlank(message = "Mã khách hàng không được bỏ trống")
    @Column(name = "MaKH")
    private String customerId;

    @Column(name = "TenKH")
    @NotBlank(message = "Tên khách hàng không được bỏ trống!")
    private String name;

    @Column(name = "DiaChi")
    @NotBlank(message = "Địa chỉ khách hàng không được bỏ trống!")
    private String address;

    @NotBlank(message = "Số điện thoại không được bỏ trống")
    @Pattern(regexp = "^(090|091|\\(84\\)\\+90|\\(84\\)\\+91)[0-9]{7}$", message = "Số điện thoại phải là 090..., 091..., (84)+90..., (84)+91...!")
    @Column(name = "SoDienThoai")
    private String phone;

    @NotBlank(message = "Địa chỉ email không được bỏ trống!")
    @Pattern(regexp = "^[\\w]+([\\-\\.]{0,1}[\\w])+@([\\w-]+\\.)+[\\w]{2,4}$", message = "Không đúng định dạng email!")
    @Column(name = "DiaChiEmail")
    private String email;

    @ToString.Exclude
//    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<DeviceUsage> deviceUsages = new ArrayList<>();

    @ToString.Exclude
//    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<ServiceUsage> serviceUsages = new ArrayList<>();

    public Customer(String name, String address, String phone, String email) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Customer)) {
            return false;
        }
        Customer customer = (Customer) o;
        return Objects.equals(customerId, customer.customerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId);
    }
}
