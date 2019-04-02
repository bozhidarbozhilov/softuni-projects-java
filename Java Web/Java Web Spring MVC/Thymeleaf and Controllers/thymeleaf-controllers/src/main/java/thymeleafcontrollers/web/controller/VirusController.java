package thymeleafcontrollers.web.controller;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import thymeleafcontrollers.domain.models.binding.VirusBindingModel;
import thymeleafcontrollers.domain.models.service.CapitalServiceModel;
import thymeleafcontrollers.domain.models.service.VirusServiceModel;
import thymeleafcontrollers.domain.models.view.DeleteVirusViewModel;
import thymeleafcontrollers.domain.models.view.EditVirusViewModel;
import thymeleafcontrollers.domain.models.view.VirusTableViewModel;
import thymeleafcontrollers.service.CapitalService;
import thymeleafcontrollers.service.VirusService;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/viruses")
public class VirusController {
    private final VirusService virusService;
    private final CapitalService capitalService;
    private final ModelMapper modelMapper;
    private final Gson gson;

    @Autowired
    public VirusController(VirusService virusService, CapitalService capitalService, ModelMapper modelMapper, Gson gson) {
        this.virusService = virusService;
        this.capitalService = capitalService;
        this.modelMapper = modelMapper;
        this.gson = gson;
    }

    @ModelAttribute(name="allCapitals")
    public List<String> allCapitals(){
        return this.capitalService.allCapitals().stream()
                .map(CapitalServiceModel::getName)
                .collect(Collectors.toList());
    }

    @ModelAttribute(name="allViruses")
    public List<VirusTableViewModel> allViruses(){
        return this.virusService.allViruses().stream()
                .map(virusServiceModel -> this.modelMapper.map(virusServiceModel, VirusTableViewModel.class))
                .collect(Collectors.toList());
    }
    @GetMapping("/add")
    public ModelAndView getAddVirusPage(@ModelAttribute VirusBindingModel virusBindingModel, ModelAndView modelAndView){

        modelAndView.setViewName("add-virus");
        return modelAndView;
    }

    @PostMapping("/add")
    public ModelAndView createVirus(@Valid @ModelAttribute(name="virusBindingModel") VirusBindingModel virusBindingModel,
                              BindingResult bindingResult, ModelAndView modelAndView){
        if(bindingResult.hasErrors()){
            modelAndView.setViewName("add-virus");
            return modelAndView;
        }else{
            VirusServiceModel virusServiceModel = this.modelMapper.map(virusBindingModel, VirusServiceModel.class);
            this.virusService.addVirus(virusServiceModel);
            modelAndView.setViewName("redirect:/");
        }


        return modelAndView;
    }

    @GetMapping("/show")
    public ModelAndView getShowPage(ModelAndView modelAndView){
        modelAndView.setViewName("show-page");
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView getEditPage(@PathVariable String id,@ModelAttribute EditVirusViewModel editModel,
                                    ModelAndView modelAndView){
        VirusServiceModel foundVirus = this.virusService.findVirusById(id);
        if(foundVirus!=null){
            editModel = this.modelMapper.map(foundVirus, EditVirusViewModel.class);
            modelAndView.addObject("editModel", editModel);
            modelAndView.setViewName("edit-virus");
        }else{
            modelAndView.setViewName("redirect:/");
        }
        return modelAndView;
    }

    @PostMapping("/edit/{id}")
    public ModelAndView editVirus(@Valid @ModelAttribute EditVirusViewModel editModel, BindingResult result,
                                  ModelAndView modelAndView){
        if(result.hasErrors()){
            modelAndView.setViewName("edit-virus");
        }else{
            VirusServiceModel editedVirus =
                    this.virusService.editVirus(this.modelMapper.map(editModel, VirusServiceModel.class));
            if(editedVirus == null){
                modelAndView.setViewName("redirect:/edit/"+editModel.getId());
            }else{
                modelAndView.setViewName("redirect:/viruses");
            }
        }
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView getDeleteVirusView(@ModelAttribute(name="deleteModel") DeleteVirusViewModel deleteModel,
                                    @PathVariable String id,
                                    ModelAndView modelAndView){
        deleteModel = this.modelMapper.map(this.virusService.findVirusById(id), DeleteVirusViewModel.class);
        modelAndView.setViewName("delete-virus");
        return modelAndView;
    }

    @PostMapping("/delete/{id}")
    public ModelAndView deleteVirus(@PathVariable String id,ModelAndView modelAndView){
        this.virusService.deleteVirus(id);
        modelAndView.setViewName("redirect:/viruses");
        return modelAndView;
    }

    @GetMapping(value = "/all", produces="application/json")
    @ResponseBody
    public Object getAllViruses(){

        return allViruses();
    }

}
