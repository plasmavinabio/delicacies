package delicacies.dao.content;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import delicacies.entity.content.DelicaciesImageEntity;
import delicacies.model.content.DelicaciesImageModel;
import org.springframework.stereotype.Repository;

@Repository
public class DelicaciesImageDAO {
//	@Autowired
	@PersistenceContext
	private EntityManager entityManager;
	
	public DelicaciesImageDAO() {
		
	}
	
	public DelicaciesImageEntity finById(Long id) {
		return this.entityManager.find(DelicaciesImageEntity.class, id);
	}
	
	public List<DelicaciesImageModel> listDelicaciesImageModel() {
        String sql = "Select new " + DelicaciesImageModel.class.getName() //
                + "(e.imageId,e.name) " //
                + " from " + DelicaciesImageEntity.class.getName() + " e ";
        Query query = entityManager.createQuery(sql, DelicaciesImageModel.class);
        return query.getResultList();
	}
	@Transactional
	public void DelicaciesImageEntityCreate(DelicaciesImageEntity image) {
//		entityManager.getTransaction().begin();
		entityManager.persist(image);
//		entityManager.getTransaction().commit();
		entityManager.close();
	}
	@Transactional
	public void DelicaciesImageEntityUpdate(DelicaciesImageEntity image) {
//		entityManager.getTransaction().begin();
		entityManager.persist(image);
		entityManager.close();
//		entityManager.getTransaction().commit();
	}
	@Transactional
	public void DelicaciesImageEntityDelete(DelicaciesImageEntity image) {
		entityManager.remove(image);
		entityManager.close();
	}
}
