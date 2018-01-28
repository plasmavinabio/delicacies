package delicacies.form.content;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import delicacies.entity.management.DelicaciesUserEntity;
import delicacies.entity.system.DelicaciesLanguageEntity;
import delicacies.form.content.CategoryEntity;

@Entity
@Table (name = "category_lang")
public class CategoryLangEntity {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;
	
	@Column(name="category_id")
	private Long categoryId;
	
   public DelicaciesLanguageEntity getLanguage() {
		return language;
	}

	public void setLanguage(DelicaciesLanguageEntity language) {
		this.language = language;
	}

@ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "language_id", nullable = false)
   private DelicaciesLanguageEntity language;
	
//	@Column (name = "language_id")
//	private Long languageId;
	
	@Column (name = "name")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

//   @ManyToOne(fetch = FetchType.LAZY)
//   @JoinColumn(name = "category_id", nullable = false)
//   private CategoryEntity categoryLangEntity;
	
	public Long getId() {
		return id;
	}

//	public CategoryEntity getCategoryLangEntity() {
//		return categoryLangEntity;
//	}
//
//	public void setCategoryLangEntity(CategoryEntity categoryLangEntity) {
//		this.categoryLangEntity = categoryLangEntity;
//	}

	public void setId(Long id) {
		this.id = id;
	}

//	public Long getLanguageId() {
//		return languageId;
//	}
//
//	public void setLanguageId(Long languageId) {
//		this.languageId = languageId;
//	}
	
}
