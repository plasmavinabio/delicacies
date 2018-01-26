package delicacies.entity.content;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "image")
public class DelicaciesImageEntity {
	@Id
	@GeneratedValue
	@Column (name = "image_id", nullable = false)
	private Long imageId;
	
	@Column(name = "name", length = 128, nullable = false)
	private String name;
	
	@Column (name = "created", nullable = false, updatable = false)
	private Long created;
	
	public void setImageId(Long imageId) {
		this.imageId = imageId;
	}
	public Long getImageId () {
		return this.imageId;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	
	public Long getCreated() {
		return this.created;
	}
	public void setCreated(Long created) {
		this.created = created;
	}
}
