package delicacies.controller.backend;

import java.util.List;

import delicacies.dao.system.DelicaciesLanguageDAO;
//import org.o7planning.springbootjpa.form.SendMoneyForm;
import delicacies.model.system.DelicaciesLanguageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;  
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminLanguageController {
	@Autowired
	private DelicaciesLanguageDAO delicaciesLanguageDAO;
	
	@RequestMapping(value = "/admin/language", method = RequestMethod.GET)
	public String showLanguages(Model model) {
		List<DelicaciesLanguageModel> list = delicaciesLanguageDAO.listDelicaciesLanguageModel();
		model.addAttribute("listLanguages", list);
		return "adminListLanguagePage";
	}
	
	@RequestMapping("/test")
	public String test() {
		return "adminListLanguagePage";
	}
	
}
