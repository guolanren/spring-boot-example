package name.guolanren.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author guolanren
 */
@Entity
@Table(name = "example_auditing_log")
public class ApiAuditingLog implements Serializable {

    private static final long serialVersionUID = -5868328703085960997L;

    @Id
    @Column(name = "auditing_log_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long auditingLogId;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "ip", nullable = false)
    private String ip;

    @Column(name = "menu", nullable = false)
    private String menu;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "status", nullable = false)
    private Integer status;

    @Column(name = "description")
    private String description;

    @Column(name = "operated_time", nullable = false)
    private Date operatedTime;

    public Long getAuditingLogId() {
        return auditingLogId;
    }

    public void setAuditingLogId(Long auditingLogId) {
        this.auditingLogId = auditingLogId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getOperatedTime() {
        return operatedTime;
    }

    public void setOperatedTime(Date operatedTime) {
        this.operatedTime = operatedTime;
    }
}
