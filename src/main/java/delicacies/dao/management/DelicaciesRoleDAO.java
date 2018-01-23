package delicacies.dao.management;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
 
import delicacies.entity.management.DelicaciesUserRoleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class DelicaciesRoleDAO {
    @Autowired
    private EntityManager entityManager;
 
    public List<String> getRoleCodes(Long userId) {
        String sql = "Select ur.delicaciesRoleEntity.roleCode from " + DelicaciesUserRoleEntity.class.getName() + " ur " //
                + " where ur.delicaciesUserEntity.userId = :userId ";
 
        Query query = this.entityManager.createQuery(sql, String.class);
        query.setParameter("userId", userId);
        return query.getResultList();
    }
}
