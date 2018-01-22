package delicacies.dao.management;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
 
import delicacies.entity.management.DelicaciesUserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class DelicaciesUserDAO {
	 	@Autowired
	    private EntityManager entityManager;
	 
	    public DelicaciesUserEntity findUserAccount(String userName) {
	        try {
	            String sql = "Select e from " + DelicaciesUserEntity.class.getName() + " e " //
	                    + " Where e.username = :userName ";
	 
	            Query query = entityManager.createQuery(sql, DelicaciesUserEntity.class);
	            query.setParameter("username", userName);
	 
	            return (DelicaciesUserEntity) query.getSingleResult();
	        } catch (NoResultException e) {
	            return null;
	        }
	    }
}
