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
import delicacies.entity.management.DelicaciesUserEntity;
import delicacies.entity.management.DelicaciesRoleEntity;

@Entity
@Table(name = "user_role", //
       uniqueConstraints = { //
               @UniqueConstraint(name = "USER_ROLE_UK", columnNames = { "user_id", "role_id" }) })
public class DelicaciesUserRoleEntity {

   @Id
   @GeneratedValue
   @Column(name = "id", nullable = false)
   private Long id;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "user_id", nullable = false)
   private DelicaciesUserEntity delicaciesUserEntity;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "role_id", nullable = false)
   private DelicaciesRoleEntity delicaciesRoleEntity;

   public Long getId() {
       return id;
   }

   public void setId(Long id) {
       this.id = id;
   }

   public DelicaciesUserEntity getDelicaciesUserEntity() {
       return delicaciesUserEntity;
   }

   public void setDelicaciesUserEntity(DelicaciesUserEntity delicaciesUserEntity) {
       this.delicaciesUserEntity = delicaciesUserEntity;
   }

   public DelicaciesRoleEntity getAppRole() {
       return delicaciesRoleEntity;
   }

   public void setDelicaciesRoleEntity(DelicaciesRoleEntity delicaciesRoleEntity) {
       this.delicaciesRoleEntity = delicaciesRoleEntity;
   }
    
}
