package delicacies.form.content;

import org.springframework.web.multipart.MultipartFile;

import delicacies.entity.content.DelicaciesImageEntity;

public class DelicaciesImageForm {
	private Long imageId;
	private String name;
	private Long created;
	private MultipartFile[] fileDatas;
	
	public DelicaciesImageForm() {
		
	}
	public DelicaciesImageForm(DelicaciesImageEntity delicaciesImageEntity) {
		this.imageId = delicaciesImageEntity.getImageId();
		this.name = delicaciesImageEntity.getName();
		this.created = delicaciesImageEntity.getCreated();
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
 
    public MultipartFile[] getFileDatas() {
        return fileDatas;
    }
    public void setFileDatas(MultipartFile[] fileDatas) {
        this.fileDatas = fileDatas;
    }
	
}
