package exodiaspring.web.controller;

import exodiaspring.domain.models.binding.DocumentScheduleBindingModel;
import exodiaspring.domain.models.service.DocumentServiceModel;
import exodiaspring.domain.models.view.DocumentDetailsViewModel;
import exodiaspring.domain.models.view.DocumentPrintViewModel;
import exodiaspring.service.DocumentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class DocumentController {

    private final DocumentService documentService;
    private final ModelMapper modelMapper;

    @Autowired
    public DocumentController(DocumentService documentService, ModelMapper modelMapper) {
        this.documentService = documentService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/schedule")
    public ModelAndView schedule(ModelAndView modelAndView, HttpSession session){
        if(session.getAttribute("username")==null){
            modelAndView.setViewName("redirect:/login");
        }else{
            modelAndView.addObject("scheduleModel", new DocumentScheduleBindingModel());
            modelAndView.setViewName("/schedule");
        }

        return modelAndView;
    }

    @PostMapping("/schedule")
    public ModelAndView scheduleConfirm(@ModelAttribute DocumentScheduleBindingModel scheduleModel,
                                        ModelAndView modelAndView, HttpSession session){
        if(session.getAttribute("username")==null){
            modelAndView.setViewName("redirect:/login");
        }else{
            DocumentServiceModel documentServiceModel = this.modelMapper
                    .map(scheduleModel, DocumentServiceModel.class);

            DocumentServiceModel savedDocument = this.documentService.saveDocument(documentServiceModel);

            modelAndView.setViewName("redirect:/details/" + savedDocument.getId());
        }
        return modelAndView;
    }

    @GetMapping("/details/{id}")
    public ModelAndView details(@PathVariable(name="id")String id, ModelAndView modelAndView, HttpSession session){
        if(session.getAttribute("username")==null){
            modelAndView.setViewName("redirect:/login");
        }else{
            DocumentServiceModel foundDocument = this.documentService.findDocumentById(id);
            modelAndView.setViewName("details");
            modelAndView.addObject("documentDetails",
                    this.modelMapper.map(foundDocument, DocumentDetailsViewModel.class));
        }
        return modelAndView;
    }

    @GetMapping("/print/{id}")
    public ModelAndView print(@PathVariable(name="id")String id, ModelAndView modelAndView, HttpSession session){
        if(session.getAttribute("username")==null){
            modelAndView.setViewName("redirect:/login");
        }else{
            DocumentServiceModel foundDocumentById = this.documentService.findDocumentById(id);
            modelAndView.setViewName("print");
            modelAndView.addObject("printDetails",
                    this.modelMapper.map(foundDocumentById, DocumentPrintViewModel.class));
        }
        return modelAndView;
    }

    @PostMapping("/print/{id}")
    public ModelAndView printConfirm(@PathVariable(name="id")String id, ModelAndView modelAndView, HttpSession session){
        if(session.getAttribute("username")==null){
            modelAndView.setViewName("redirect:/login");
        }else{
            this.documentService.printDocument(id);
            modelAndView.setViewName("print");
            modelAndView.setViewName("redirect:/home");
        }
        return modelAndView;
    }

}
