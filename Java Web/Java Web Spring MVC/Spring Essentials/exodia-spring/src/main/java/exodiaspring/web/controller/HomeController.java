package exodiaspring.web.controller;

import exodiaspring.domain.models.service.DocumentServiceModel;
import exodiaspring.domain.models.view.DocumentHomeDetailsViewModel;
import exodiaspring.service.DocumentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HomeController {
    private final DocumentService documentService;
    private final ModelMapper modelMapper;

    @Autowired
    public HomeController(DocumentService documentService, ModelMapper modelMapper) {
        this.documentService = documentService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/")
    public ModelAndView index(ModelAndView mav, HttpSession session){
        if(session.getAttribute("username") != null){
            mav.setViewName("redirect:/home");
        }else{
            mav.setViewName("index");
        }
        return mav;
    }

    @GetMapping("/home")
    public ModelAndView home(ModelAndView modelAndView, HttpSession session){
        if(session.getAttribute("username")==null){
            modelAndView.setViewName("redirect:/login");
        }else{
            List<DocumentServiceModel> allDocuments = this.documentService.findAllDocuments();
            List<DocumentHomeDetailsViewModel> documents =
                    allDocuments
                            .stream()
                            .map(doc->this.modelMapper.map(doc, DocumentHomeDetailsViewModel.class))
                            .peek(doc->{
                                if(doc.getTitle().length()>12){
                                    doc.setTitle(doc.getTitle().substring(0,12)+"...");
                                }
                            }).collect(Collectors.toList());
            modelAndView.addObject("documents", documents);
            modelAndView.setViewName("home");
        }
        return modelAndView;
    }
}
