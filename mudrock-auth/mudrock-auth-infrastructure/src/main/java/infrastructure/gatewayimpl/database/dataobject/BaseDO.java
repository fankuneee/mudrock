package infrastructure.gatewayimpl.database.dataobject;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;


@MappedSuperclass
@Data
public class BaseDO {

    /**
     * 创建人.
     */
    @Column(name = "creator")
    @CreatedBy
    private String creator;

    /**
     * 修改人.
     */
    @Column(name = "modifier")
    @LastModifiedBy
    private String modifier;


    /**
     * 创建时间.
     */
    @Column(name = "create_time")
    @CreatedDate
    private Date createTime;

    /**
     * 更新时间.
     */
    @Column(name = "update_time")
    @LastModifiedDate
    private Date updateTime;
}