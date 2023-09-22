package infrastructure.gatewayimpl.database.dao;

import infrastructure.gatewayimpl.database.dataobject.UserDO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * ClassName: UserDao.
 * Description:
 * date: 2023/9/22 14:35
 *
 * @author huzhenghui
 */
public interface UserDao extends JpaRepository<UserDO, Long> {
}
