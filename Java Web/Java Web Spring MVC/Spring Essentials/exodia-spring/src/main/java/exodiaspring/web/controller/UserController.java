package exodiaspring.web.controller;

import exodiaspring.domain.models.binding.LoginBindingModel;
import exodiaspring.domain.models.binding.RegisterBindingModel;
import exodiaspring.domain.models.service.UserServiceModel;
import exodiaspring.repository.UserRepository;
import exodiaspring.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    private final UserService userService;
    private final ModelMapper mapper;

    @Autowired
    public UserController(UserService userService, ModelMapper mapper) {
        this.userService = userService;
        this.mapper = mapper;
    }

    @GetMapping("/register")
    public ModelAndView register(ModelAndView mav, HttpSession session){
        if(session.getAttribute("username") != null){
            mav.setViewName("redirect:/home");
        }else{
            mav.addObject("bindingModel", new RegisterBindingModel());
            mav.setViewName("register");
        }
        return mav;
    }

    @PostMapping("/register")
    public ModelAndView registerConfirm(@ModelAttribute RegisterBindingModel bindingModel,
                                        ModelAndView modelAndView, HttpSession session){

        if(session.getAttribute("username")!=null){
            modelAndView.setViewName("redirect:/home");
        }else{
            UserServiceModel userServiceModel = this.mapper.map(bindingModel, UserServiceModel.class);

            UserServiceModel savedUser = this.userService.saveUser(userServiceModel);

            if(savedUser==null){
                modelAndView.setViewName("redirect:/register");
            }else{
                modelAndView.setViewName("redirect:/login");
            }
        }


        return modelAndView;
    }

    @GetMapping("/login")
    public ModelAndView login(ModelAndView modelAndView, HttpSession session){
        if(session.getAttribute("username") != null){
            modelAndView.setViewName("redirect:/home");
        }else{
            modelAndView.addObject("loginModel", new LoginBindingModel());
            modelAndView.setViewName("login");
        }
        return modelAndView;
    }

    @PostMapping("/login")
    public ModelAndView loginConfirm(@ModelAttribute LoginBindingModel loginModel,
                                     ModelAndView modelAndView, HttpSession session){

        if(session.getAttribute("username")!=null){
            modelAndView.setViewName("redirect:/home");
        }else{
            UserServiceModel loggedUser = this.userService
                    .loginUser(this.mapper.map(loginModel, UserServiceModel.class));

            if(loggedUser==null){
                modelAndView.setViewName("redirect:/login");
            }else{
                session.setAttribute("userId", loggedUser.getId());
                session.setAttribute("username", loggedUser.getUsername());

                modelAndView.setViewName("redirect:/home");
            }
        }


        return modelAndView;
    }

    @GetMapping("/logout")
    public ModelAndView logout(ModelAndView modelAndView, HttpSession session){
        session.invalidate();
        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }


}
