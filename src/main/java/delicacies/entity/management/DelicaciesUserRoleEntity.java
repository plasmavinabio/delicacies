package delicacies.entity.management;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "user_role", uniqueConstraints = {@UniqueConstraint(name = "USER_ROLE_UK", columnNames = {"user_id", "role_id"})})
public class DelicaciesUserRoleEntity {
	@Id
	@GeneratedValue
	@Column(name = "id", length = 11, nullable = false)
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private DelicaciesUserEntity user;
 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id", nullable = false)
    private DelicaciesRoleEntity role;
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setUser(DelicaciesUserEntity user) {
		this.user = user;
	}
	
	public DelicaciesUserEntity getUser() {
		return this.user;
	}
	
	public void setRole(DelicaciesRoleEntity role) {
		this.role = role;
	}
	
	public DelicaciesRoleEntity getRole() {
		return this.role;
	}
}
