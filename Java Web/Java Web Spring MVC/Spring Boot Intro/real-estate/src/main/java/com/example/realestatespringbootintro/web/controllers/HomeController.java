package com.example.realestatespringbootintro.web.controllers;

import com.example.realestatespringbootintro.domain.models.view.OfferViewModel;
import com.example.realestatespringbootintro.service.OfferService;
import com.example.realestatespringbootintro.util.HtmlReader;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HomeController {
    private static final String INDEX_HTML_FILE_PATH = "F:\\softuni-projects-java\\Java Web\\Java Web Spring MVC\\" +
            "Spring Boot Intro\\real-estate\\src\\main\\resources\\static\\views\\index.html";

    private final OfferService offerService;
    private final ModelMapper mapper;
    private final HtmlReader reader;

    public HomeController(OfferService offerService, ModelMapper mapper, HtmlReader reader) {
        this.offerService = offerService;
        this.mapper = mapper;
        this.reader = reader;
    }

    @GetMapping("/")
    @ResponseBody
    public String index() throws IOException {
        String htmlFile = this.reader.readHtmlFile(INDEX_HTML_FILE_PATH);

        List<OfferViewModel> offers = this.offerService.getAllOffers().stream()
                .map(osm->this.mapper.map(osm, OfferViewModel.class))
                .collect(Collectors.toList());

        if(offers.size() == 0){
            htmlFile = htmlFile.replace("{{offersList}}",
                    "<div class=\"apartment\" style=\"border: solid red 1px\"> " +
                            "There aren't any offers</div>");

        }else{
            StringBuilder offersList = new StringBuilder();
            offers.stream().map(o->"<div class=\"apartment\">" +
                    "<p>Rent: " + o.getApartmentRent()+"</p>" +
                    "<p>Type: " + o.getApartmentType()+"</p>" +
                    "<p>Commission: " + o.getAgencyCommission()+"</p>" +
                    "</div>").forEach(offersList::append);
            htmlFile = htmlFile.replace("{{offersList}}",
                    offersList.toString());
        }
        return htmlFile;
    }
}
