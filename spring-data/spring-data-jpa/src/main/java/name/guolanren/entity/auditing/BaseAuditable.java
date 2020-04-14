package name.guolanren.model.auditing;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * @author guolanren
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseAuditable {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @CreatedDate
    @Column(name = "created_time")
    private Date createdTime;

    @CreatedBy
    @Column(name = "created_user_id")
    private Integer createdUserId;

    @LastModifiedDate
    @Column(name = "last_modified_time")
    private Date lastModifiedTime;

    @LastModifiedBy
    @Column(name = "last_modified_user_id")
    private Integer lastModifiedUserId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Integer getCreatedUserId() {
        return createdUserId;
    }

    public void setCreatedUserId(Integer createdUserId) {
        this.createdUserId = createdUserId;
    }

    public Date getLastModifiedTime() {
        return lastModifiedTime;
    }

    public void setLastModifiedTime(Date lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }

    public Integer getLastModifiedUserId() {
        return lastModifiedUserId;
    }

    public void setLastModifiedUserId(Integer lastModifiedUserId) {
        this.lastModifiedUserId = lastModifiedUserId;
    }
}
