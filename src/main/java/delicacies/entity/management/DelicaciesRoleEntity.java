package delicacies.entity.management;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name = "role", //
        uniqueConstraints = { //
                @UniqueConstraint(name = "ROLE_UK", columnNames = "code") })
public class DelicaciesRoleEntity {
     
    @Id
    @GeneratedValue
    @Column(name = "role_id", nullable = false)
    private Long roleId;
 
    @Column(name = "code", length = 30, nullable = false)
    private String roleCode;
 
    @Column(name = "name", length = 256, nullable = false)
    private String roleName;
    
    public Long getRoleId() {
        return roleId;
    }
 
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
 
    public String getRoleCode() {
        return roleCode;
    }
 
    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }
    
    public String getRoleName() {
        return roleName;
    }
 
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
     
}