package delicacies.form.content;

import java.sql.Date;

import delicacies.entity.content.DelicaciesNewsEntity;

public class DelicaciesNewsForm {
	private Long newsId;
	private String title;
	private String description;
	private String body;
	private boolean enabled;
	private Date created;
	
	public DelicaciesNewsForm() {
		
	}
	public DelicaciesNewsForm(DelicaciesNewsEntity delicaciesNewsEntity) {
		this.newsId = delicaciesNewsEntity.getNewsId();
		this.title = delicaciesNewsEntity.getTitle();
		this.description = delicaciesNewsEntity.getDescription();
		this.body = delicaciesNewsEntity.getBody();
		this.enabled = delicaciesNewsEntity.isEnabled();
		this.created = delicaciesNewsEntity.getCreated();
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
