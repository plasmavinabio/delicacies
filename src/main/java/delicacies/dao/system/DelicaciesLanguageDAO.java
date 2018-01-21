package delicacies.dao.system;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import delicacies.entity.system.DelicaciesLanguageEntity;
import delicacies.model.system.DelicaciesLanguageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DelicaciesLanguageDAO {
//	@Autowired
	@PersistenceContext
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
	@Transactional
	public void DelicaciesLanguageEntityCreate(DelicaciesLanguageEntity language) {
//		entityManager.getTransaction().begin();
		entityManager.persist(language);
//		entityManager.getTransaction().commit();
		entityManager.close();
	}
	@Transactional
	public void DelicaciesLanguageEntityUpdate(DelicaciesLanguageEntity language) {
//		entityManager.getTransaction().begin();
		entityManager.persist(language);
		entityManager.close();
//		entityManager.getTransaction().commit();
	}
	@Transactional
	public void DelicaciesLanguageEntityDelete(DelicaciesLanguageEntity language) {
		entityManager.remove(language);
		entityManager.close();
	}
	public int test () {
		String sql = "Select new " + DelicaciesLanguageModel.class.getName() //
                + "(e.id,e.code,e.name) " //
                + " from " + DelicaciesLanguageEntity.class.getName() + " e ";
		Query query = entityManager.createQuery(sql, DelicaciesLanguageModel.class);
		List<DelicaciesLanguageModel> list = query.getResultList();
		return list.size();
	}
}
