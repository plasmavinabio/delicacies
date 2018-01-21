package delicacies.controller.backend;

import java.util.List;

import delicacies.entity.system.DelicaciesLanguageEntity;
import delicacies.dao.system.DelicaciesLanguageDAO;
import delicacies.form.system.DelicaciesLanguageForm;
import delicacies.model.system.DelicaciesLanguageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;  
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminLanguageController {
	@Autowired
	private DelicaciesLanguageDAO delicaciesLanguageDAO;
	
	@RequestMapping(value = "/admin/language", method = RequestMethod.GET)
	public String showLanguages(Model model) {
		List<DelicaciesLanguageModel> list = delicaciesLanguageDAO.listDelicaciesLanguageModel();
		model.addAttribute("listLanguages", list);
		int check = delicaciesLanguageDAO.test();
		model.addAttribute("check", check);
		return "adminListLanguagesPage";
	}

	@RequestMapping(value = "/admin/language/add", method = RequestMethod.GET)
	public String addLanguage(Model model) {
		
		DelicaciesLanguageForm delicaciesLanguageForm = new DelicaciesLanguageForm();
		model.addAttribute("delicaciesLanguageForm", delicaciesLanguageForm);
		return "adminAddLanguagePage";
	}
	
	@RequestMapping(value = "/admin/language/add", method = RequestMethod.POST)
	public String addLanguageSubmit(Model model, DelicaciesLanguageForm form) {
		String code = form.getCode();
		String name = form.getName();
		int id = form.getId();
		String check = "ID:" + id + ",Code:" + code + ",Name" + name;
		
		model.addAttribute("check", check);

		
		if (id == 0) {
			DelicaciesLanguageEntity language = new DelicaciesLanguageEntity();
			language.setCode(code);
			language.setName(name);
			delicaciesLanguageDAO.DelicaciesLanguageEntityCreate(language);
		}
		return "redirect:/admin/language";
	}

	@RequestMapping(value = "/admin/language/edit", method = RequestMethod.GET, params = {"id"})
	public String editLanguage(Model model, @RequestParam(value = "id") int id) {
		
		DelicaciesLanguageEntity delicaciesLanguageEntity = delicaciesLanguageDAO.finById(id);
		DelicaciesLanguageForm delicaciesLanguageForm = new DelicaciesLanguageForm(delicaciesLanguageEntity);
		model.addAttribute("delicaciesLanguageForm", delicaciesLanguageForm);
		
		
		return "adminEditLanguagePage";
	}
	
	@RequestMapping(value = "/admin/language/edit", method = RequestMethod.POST)
	public String editLanguageSubmit(Model model, DelicaciesLanguageForm form) {
		DelicaciesLanguageEntity delicaciesLanguageEntity = delicaciesLanguageDAO.finById(form.getId());
		delicaciesLanguageEntity.setCode(form.getCode());
		delicaciesLanguageEntity.setName(form.getName());
		delicaciesLanguageDAO.DelicaciesLanguageEntityUpdate(delicaciesLanguageEntity);
		return "redirect:/admin/language";
	}

	@RequestMapping(value = "/admin/language/delete", method = RequestMethod.GET, params = {"id"})
	public String deleteLanguage(Model model, @RequestParam(value = "id") int id) {
		
		DelicaciesLanguageEntity delicaciesLanguageEntity = delicaciesLanguageDAO.finById(id);
		delicaciesLanguageDAO.DelicaciesLanguageEntityDelete(delicaciesLanguageEntity);
		return "redirect:/admin/language";
	}
	
}