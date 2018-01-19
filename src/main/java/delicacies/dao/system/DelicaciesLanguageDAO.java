package delicacies.dao.system;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
 
import delicacies.entity.system.DelicaciesLanguageEntity;
import delicacies.model.system.DelicaciesLanguageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DelicaciesLanguageDAO {
	@Autowired
	private EntityManager entityManager;
	
	public DelicaciesLanguageDAO() {
		
	}
	
	public DelicaciesLanguageEntity finById(int id) {
		return this.entityManager.find(DelicaciesLanguageEntity.class, id);
	}
	
	public List<DelicaciesLanguageModel> listDelicaciesLanguageModel() {
        String sql = "Select new " + DelicaciesLanguageModel.class.getName() //
                + "(e.id,e.code,e.name) " //
                + " from " + DelicaciesLanguageEntity.class.getName() + " e ";
        Query query = entityManager.createQuery(sql, DelicaciesLanguageModel.class);
        return query.getResultList();
	}
}
