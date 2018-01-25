package delicacies.dao.content;

//import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import delicacies.entity.content.DelicaciesNewsEntity;
import delicacies.model.content.DelicaciesNewsModel;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DelicaciesNewsDAO {

//	@Autowired
	@PersistenceContext
	private EntityManager entityManager;
	
	public DelicaciesNewsDAO() {
		
	}
	
	public DelicaciesNewsEntity finById(Long id) {
		return this.entityManager.find(DelicaciesNewsEntity.class, id);
	}
	
	public List<DelicaciesNewsModel> listDelicaciesNewsModel() {
        String sql = "Select new " + DelicaciesNewsModel.class.getName() //
                + "(e.newsId,e.title) " //
                + " from " + DelicaciesNewsEntity.class.getName() + " e ";
        Query query = entityManager.createQuery(sql, DelicaciesNewsModel.class);
        return query.getResultList();
	}
	@Transactional
	public void DelicaciesNewsEntityCreate(DelicaciesNewsEntity news) {
//		entityManager.getTransaction().begin();
		entityManager.persist(news);
//		entityManager.getTransaction().commit();
		entityManager.close();
	}
	@Transactional
	public void DelicaciesNewsEntityUpdate(DelicaciesNewsEntity news) {
//		entityManager.getTransaction().begin();
		entityManager.persist(news);
		entityManager.close();
//		entityManager.getTransaction().commit();
	}
	@Transactional
	public void DelicaciesNewsEntityDelete(DelicaciesNewsEntity news) {
		entityManager.remove(news);
		entityManager.close();
	}
//	public int test () {
//		String sql = "Select new " + DelicaciesLanguageModel.class.getName() //
//                + "(e.id,e.code,e.name) " //
//                + " from " + DelicaciesLanguageEntity.class.getName() + " e ";
//		Query query = entityManager.createQuery(sql, DelicaciesLanguageModel.class);
//		List<DelicaciesLanguageModel> list = query.getResultList();
//		return list.size();
//	}

}