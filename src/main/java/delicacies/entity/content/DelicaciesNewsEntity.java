package delicacies.entity.content;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table (name = "news")
public class DelicaciesNewsEntity {
	@Id
	@GeneratedValue
	@Column (name = "news_id", nullable = false)
	private Long newsId;
	
	@Column(name = "title", length = 256, nullable = false)
	private String title;
	
	@Column (name = "description")
	private String description;
	
	@Column (name = "body")
	private String body;
	
	@Column (name = "enabled")
	private boolean enabled;
	
	@Column (name = "created", nullable = false, updatable = false)
	@CreationTimestamp
	private Date created;
	
	public void setNewsId(Long newsId) {
		this.newsId = newsId;
	}
	public Long getNewsId () {
		return this.newsId;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitle() {
		return this.title;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDescription() {
		return this.description;
	}
	
	public void setBody(String body) {
		this.body = body;
	}
	public String getBody() {
		return this.body;
	}
	
	public void enable() {
		this.enabled = true;
	}
	public void disable() {
		this.enabled = false;
	}
	public boolean isEnabled() {
		return this.enabled;
	}
	
	public Date getCreated() {
		return this.created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	
}
