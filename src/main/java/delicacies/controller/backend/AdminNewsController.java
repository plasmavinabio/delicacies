package delicacies.controller.backend;

//import java.sql.Date;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import delicacies.entity.content.DelicaciesNewsEntity;
import delicacies.dao.content.DelicaciesNewsDAO;
import delicacies.form.content.DelicaciesNewsForm;
import delicacies.model.content.DelicaciesNewsModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminNewsController {
	@Autowired
	private DelicaciesNewsDAO delicaciesNewsDAO;
	private Long time = System.currentTimeMillis() / 1000;
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
//		String check = "ID=" + id + "-DESC=" + description + "-Body=" + body;
		if (Objects.isNull(id)) {
			DelicaciesNewsEntity news = new DelicaciesNewsEntity();
			news.setTitle(title);
			news.setDescription(description);
			news.setBody(body);
			news.enable();
			news.setCreated(this.time);
			news.setUpdated(this.time);
			delicaciesNewsDAO.DelicaciesNewsEntityCreate(news);
		}
		return "redirect:/admin/content/news";
	}

	@RequestMapping(value = "/admin/content/news/{id}/edit", method = RequestMethod.GET)
	public String editLanguage(Model model, @PathVariable("id") Long id) {
		
		DelicaciesNewsEntity delicaciesNewsEntity = delicaciesNewsDAO.finById(id);
		DelicaciesNewsForm delicaciesNewsForm = new DelicaciesNewsForm(delicaciesNewsEntity);
		model.addAttribute("delicaciesNewsForm", delicaciesNewsForm);
		
		
		return "adminEditNewsPage";
	}
	
	@RequestMapping(value = "/admin/content/news/edit", method = RequestMethod.POST)
	public String editNewsSubmit(Model model, DelicaciesNewsForm form) {
		DelicaciesNewsEntity delicaciesNewsEntity = delicaciesNewsDAO.finById(form.getNewsId());
		String title = form.getTitle();
		String description = form.getDescription();
		String body = form.getBody();
		boolean enabled = form.isEnabled();
		delicaciesNewsEntity.setTitle(title);
		delicaciesNewsEntity.setDescription(description);
		delicaciesNewsEntity.setBody(body);
		delicaciesNewsEntity.setUpdated(this.time);

		if (enabled) {
			delicaciesNewsEntity.enable();
		}
		else {
			delicaciesNewsEntity.disable();
		}
		delicaciesNewsDAO.DelicaciesNewsEntityUpdate(delicaciesNewsEntity);
		return "redirect:/admin/content/news";
	}

	@RequestMapping(value = "/admin/content/news/{id}/delete", method = RequestMethod.GET)
	public String deleteLanguage(Model model, @PathVariable("id") Long id) {
		
		DelicaciesNewsEntity delicaciesNewsEntity = delicaciesNewsDAO.finById(id);
		delicaciesNewsDAO.DelicaciesNewsEntityDelete(delicaciesNewsEntity);
		return "redirect:/admin/content/news";
	}
	
}