package tech.thuexe.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Collection;
import static javax.persistence.FetchType.EAGER;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@Table(name = "_User")
public class UserEntity extends BaseEntity {

    @Column(name = "_name", length = 20)
    @Size(min = 3, max = 20, message = "Tên phải từ 3 đến 20 ký tự")
    private String name;

    @Column(name = "_username", unique = true, nullable = false, length = 20)
    @NotBlank(message = "username không được bỏ trống")
    @Size(min = 3, max = 20, message = "Tên tài khoản phải từ 3 đến 20 ký tự")
    private String username;

    @Column(name = "_phone")
    @Size( min = 10, max=10,message = "Số điện thoại phải 10 chữ số")
    private String phone;

    @Column(name = "_password")
    @NotBlank(message = "mật khẩu không được bỏ trống")
    private String password;

    @ManyToMany(fetch = EAGER)
    private Collection<RoleEntity> roles = new ArrayList<>();
}
