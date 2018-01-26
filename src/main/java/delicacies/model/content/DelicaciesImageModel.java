package delicacies.model.content;

public class DelicaciesImageModel {

	final public static String IMAGE_UPLOAD_PATH = "upload/image";
	private Long imageId;
	private String name;
	private Long created;
	private String path;
	

	public DelicaciesImageModel() {
		
	}
	
	public DelicaciesImageModel(Long imageId, String name, Long created) {
		this.imageId = imageId;
		this.name = name;
		this.created = created;
	}

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
	
	public void setPath(String path) {
		this.path = path;
	}
	public String getPath() {
		return IMAGE_UPLOAD_PATH + "/" + this.name;
	}
}
