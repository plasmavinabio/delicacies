package delicacies.controller.backend;

import java.util.List;
import java.util.Objects;

import delicacies.entity.content.DelicaciesNewsEntity;
import delicacies.dao.content.DelicaciesNewsDAO;
import delicacies.form.content.DelicaciesNewsForm;
import delicacies.model.content.DelicaciesNewsModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;  
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminNewsController {
	@Autowired
	private DelicaciesNewsDAO delicaciesNewsDAO;
	
	@RequestMapping(value = "/admin/content/news", method = RequestMethod.GET)
	public String showListNews(Model model) {
		List<DelicaciesNewsModel> list = delicaciesNewsDAO.listDelicaciesNewsModel();
		model.addAttribute("listNews", list);
		return "adminListNewsPage";
	}

	@RequestMapping(value = "/admin/content/news/add", method = RequestMethod.GET)
	public String addNews(Model model) {
		
		DelicaciesNewsForm delicaciesNewsForm = new DelicaciesNewsForm();
		model.addAttribute("delicaciesNewsForm", delicaciesNewsForm);
		return "adminAddNewsPage";
	}
	
	@RequestMapping(value = "/admin/content/news/add", method = RequestMethod.POST)
	public String addNewsSubmit(Model model, DelicaciesNewsForm form) {
		
		Long id = form.getNewsId();
		String title = form.getTitle();
		String description = form.getDescription();
		String body = form.getBody();
		String check = "ID=" + id + "-DESC=" + description + "-Body=" + body;
		if (Objects.isNull(id)) {
			DelicaciesNewsEntity news = new DelicaciesNewsEntity();
			news.setTitle(title);
			news.setDescription(description);
			news.setBody(body);
			news.enable();
			delicaciesNewsDAO.DelicaciesNewsEntityCreate(news);
		}
		return "redirect:/admin";
	}

//	@RequestMapping(value = "/admin/language/edit", method = RequestMethod.GET, params = {"id"})
//	public String editLanguage(Model model, @RequestParam(value = "id") int id) {
//		
//		DelicaciesLanguageEntity delicaciesLanguageEntity = delicaciesLanguageDAO.finById(id);
//		DelicaciesLanguageForm delicaciesLanguageForm = new DelicaciesLanguageForm(delicaciesLanguageEntity);
//		model.addAttribute("delicaciesLanguageForm", delicaciesLanguageForm);
//		
//		
//		return "adminEditLanguagePage";
//	}
	
//	@RequestMapping(value = "/admin/language/edit", method = RequestMethod.POST)
//	public String editLanguageSubmit(Model model, DelicaciesLanguageForm form) {
//		DelicaciesLanguageEntity delicaciesLanguageEntity = delicaciesLanguageDAO.finById(form.getId());
//		delicaciesLanguageEntity.setCode(form.getCode());
//		delicaciesLanguageEntity.setName(form.getName());
//		delicaciesLanguageDAO.DelicaciesLanguageEntityUpdate(delicaciesLanguageEntity);
//		return "redirect:/admin/language";
//	}

//	@RequestMapping(value = "/admin/language/delete", method = RequestMethod.GET, params = {"id"})
//	public String deleteLanguage(Model model, @RequestParam(value = "id") int id) {
//		
//		DelicaciesLanguageEntity delicaciesLanguageEntity = delicaciesLanguageDAO.finById(id);
//		delicaciesLanguageDAO.DelicaciesLanguageEntityDelete(delicaciesLanguageEntity);
//		return "redirect:/admin/language";
//	}
	
}