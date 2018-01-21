package delicacies.form.system;

import delicacies.entity.system.DelicaciesLanguageEntity;

public class DelicaciesLanguageForm {

	private int id;
	private String code;
	private String name;

	public DelicaciesLanguageForm() {
	}

	public DelicaciesLanguageForm(DelicaciesLanguageEntity delicaciesLanguageEntity) {
		this.id = delicaciesLanguageEntity.getId();
		this.code = delicaciesLanguageEntity.getCode();
		this.name = delicaciesLanguageEntity.getName();
	}
	
	public DelicaciesLanguageForm(String code, String name) {
		this.code = code;
		this.name = name;
	}
	public DelicaciesLanguageForm(int id, String code, String name) {
		this.id = id;
		this.code = code;
		this.name = name;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCode (String code) {
		this.code = code;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
