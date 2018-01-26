package delicacies.controller.backend;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
//import java.sql.Date;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import delicacies.entity.content.DelicaciesImageEntity;
import delicacies.dao.content.DelicaciesImageDAO;
import delicacies.form.content.DelicaciesImageForm;
import delicacies.model.content.DelicaciesImageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class AdminImageController {
	@Autowired
	private DelicaciesImageDAO delicaciesImageDAO;
	private Long time = System.currentTimeMillis() / 1000;
	@RequestMapping(value = "/admin/content/image", method = RequestMethod.GET)
	public String showListImage(Model model) {
		List<DelicaciesImageModel> list = delicaciesImageDAO.listDelicaciesImageModel();
		model.addAttribute("listImage", list);
		return "adminListImagePage";
	}

	@RequestMapping(value = "/admin/content/image/add", method = RequestMethod.GET)
	public String addNews(Model model) {
		DelicaciesImageForm delicaciesImageForm = new DelicaciesImageForm();
		model.addAttribute("delicaciesImageForm", delicaciesImageForm);
		return "adminAddImagePage";
	}
	
	@RequestMapping(value = "/admin/content/image/add", method = RequestMethod.POST)
	public String addNewsSubmit(HttpServletRequest request, //
            Model model, //
            @ModelAttribute("delicaciesImageForm")  DelicaciesImageForm form) {
		 return this.doUpload(request, model, form);
	}

    private String doUpload(HttpServletRequest request, Model model, //
    		DelicaciesImageForm myUploadForm) {
 
//        String description = myUploadForm.getDescription();
//        System.out.println("Description: " + description);
 
        // Thư mục gốc upload file.
        String uploadRootPath = request.getServletContext().getRealPath(DelicaciesImageModel.IMAGE_UPLOAD_PATH);
        System.out.println("uploadRootPath=" + uploadRootPath);
 
        File uploadRootDir = new File(uploadRootPath);
        // Tạo thư mục gốc upload nếu nó không tồn tại.
        if (!uploadRootDir.exists()) {
            uploadRootDir.mkdirs();
        }
        MultipartFile[] fileDatas = myUploadForm.getFileDatas();
        // 
        List<File> uploadedFiles = new ArrayList<File>();
        List<String> failedFiles = new ArrayList<String>();
 
        for (MultipartFile fileData : fileDatas) {
 
            // Tên file gốc tại Client.
            String name = fileData.getOriginalFilename();
            System.out.println("Client File Name = " + name);
            System.out.println("Client File separator = " + File.separator);
            System.out.println("Client File getAbsolutePath = " + uploadRootDir.getAbsolutePath());
 
            if (name != null && name.length() > 0) {
                try {
                    // Tạo file tại Server.
                    File serverFile = new File(uploadRootDir.getAbsolutePath() + File.separator + name);
 
                    BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
                    stream.write(fileData.getBytes());
                    stream.close();
                    DelicaciesImageEntity image = new DelicaciesImageEntity();
                    image.setName(name);
                    image.setCreated(time);
                    
                    delicaciesImageDAO.DelicaciesImageEntityCreate(image);
                    // 
                    uploadedFiles.add(serverFile);
                    System.out.println("Write file: " + serverFile);
                } catch (Exception e) {
                    System.out.println("Error Write file: " + name);
                    failedFiles.add(name);
                }
            }
        }
        model.addAttribute("uploadedFiles", uploadedFiles);
        model.addAttribute("failedFiles", failedFiles);
//        return "uploadResult";
        return "redirect:/admin/content/image/add";
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@RequestMapping(value = "/admin/content/news/{id}/edit", method = RequestMethod.GET)
//	public String editLanguage(Model model, @PathVariable("id") Long id) {
//		
//		DelicaciesNewsEntity delicaciesNewsEntity = delicaciesNewsDAO.finById(id);
//		DelicaciesNewsForm delicaciesNewsForm = new DelicaciesNewsForm(delicaciesNewsEntity);
//		model.addAttribute("delicaciesNewsForm", delicaciesNewsForm);
//		
//		
//		return "adminEditNewsPage";
//	}
//	
//	@RequestMapping(value = "/admin/content/news/edit", method = RequestMethod.POST)
//	public String editNewsSubmit(Model model, DelicaciesNewsForm form) {
//		DelicaciesNewsEntity delicaciesNewsEntity = delicaciesNewsDAO.finById(form.getNewsId());
//		String title = form.getTitle();
//		String description = form.getDescription();
//		String body = form.getBody();
//		boolean enabled = form.isEnabled();
//		delicaciesNewsEntity.setTitle(title);
//		delicaciesNewsEntity.setDescription(description);
//		delicaciesNewsEntity.setBody(body);
//		delicaciesNewsEntity.setUpdated(this.time);
//
//		if (enabled) {
//			delicaciesNewsEntity.enable();
//		}
//		else {
//			delicaciesNewsEntity.disable();
//		}
//		delicaciesNewsDAO.DelicaciesNewsEntityUpdate(delicaciesNewsEntity);
//		return "redirect:/admin/content/news";
//	}
//
//	@RequestMapping(value = "/admin/content/news/{id}/delete", method = RequestMethod.GET)
//	public String deleteLanguage(Model model, @PathVariable("id") Long id) {
//		
//		DelicaciesNewsEntity delicaciesNewsEntity = delicaciesNewsDAO.finById(id);
//		delicaciesNewsDAO.DelicaciesNewsEntityDelete(delicaciesNewsEntity);
//		return "redirect:/admin/content/news";
//	}
	
}