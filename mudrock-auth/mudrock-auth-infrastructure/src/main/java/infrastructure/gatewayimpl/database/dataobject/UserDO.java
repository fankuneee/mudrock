package infrastructure.gatewayimpl.database.dataobject;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName: User.
 * Description:
 * date: 2023/9/22 14:18
 *
 * @author huzhenghui
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sys_user")
public class UserDO extends BaseDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

}
