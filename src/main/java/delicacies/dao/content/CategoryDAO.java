package delicacies.dao.content;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import delicacies.entity.content.DelicaciesImageEntity;
import delicacies.form.content.CategoryEntity;
import delicacies.form.content.CategoryLangEntity;

@Repository
@Transactional
public class CategoryDAO {
	@PersistenceContext
    private EntityManager entityManager;
	
	public CategoryLangEntity getCat() {
		String sql = "FROM CategoryLangEntity cl";
		Query query = entityManager.createQuery(sql, CategoryLangEntity.class);
		query.setParameter("id_lang", 1);
		return (CategoryLangEntity) query.getSingleResult();
	}
	public CategoryEntity findById(Long id) {
		return this.entityManager.find(CategoryEntity.class, id);
	}
}
