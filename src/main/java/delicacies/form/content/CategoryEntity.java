package delicacies.form.content;

import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKey;
import javax.persistence.MapKeyColumn;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import delicacies.entity.system.DelicaciesLanguageEntity;
import delicacies.form.content.CategoryLangEntity;

@Entity
@Table (name = "category")
public class CategoryEntity {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;
	
	@Column(name = "active")
	private boolean active;
	
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
//    @MapKeyJoinColumn(name = "language_id")
//    @MapKey(name="languageId")
    @MapKeyColumn(name="language_id")
//    private List<CategoryLangEntity> categoryLangEntity;
    private Map<Long, CategoryLangEntity> categoryLangEntity;

    
//	public List<CategoryLangEntity> getCategoryLangEntity() {
//		return categoryLangEntity;
//	}
//
//	public void setCategoryLangEntity(List<CategoryLangEntity> categoryLangEntity) {
//		this.categoryLangEntity = categoryLangEntity;
//	}
	
	
	public Map<Long, CategoryLangEntity> getCategoryLangEntity() {
		return categoryLangEntity;
	}

	public void setCategoryLangEntity(Map<Long, CategoryLangEntity> categoryLangEntity) {
		this.categoryLangEntity = categoryLangEntity;
	}
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
}
