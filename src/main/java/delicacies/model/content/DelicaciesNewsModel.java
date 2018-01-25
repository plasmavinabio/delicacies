package delicacies.model.content;

import java.sql.Date;

import org.hibernate.annotations.CreationTimestamp;

public class DelicaciesNewsModel {
	private Long newsId;
	private String title;
	private String description;
	private String body;
	private boolean enabled;
	@CreationTimestamp
	private Date created;
	
	public DelicaciesNewsModel() {
		
	}
	
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
