package delicacies.model.content;

public class DelicaciesNewsModel {
	private Long newsId;
	private String title;
	private String description;
	private String body;
	private boolean enabled;
	private Long created;
	
	public DelicaciesNewsModel() {
		
	}
	public DelicaciesNewsModel(Long newsId, String title) {
		this.newsId = newsId;
		this.title = title;
	}
//	public DelicaciesNewsModel(Long newsId, String title, String description, String body, boolean enabled, Long created) {
//		this.newsId = newsId;
//		this.title = title;
//		this.description = description;
//		this.body = body;
//		this.enabled = enabled;
//		this.created = created;
//	}
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
	
	public Long getCreated() {
		return this.created;
	}
	public void setCreated(Long created) {
		this.created = created;
	}
}
