package test.controller;

import test.model.Part;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import test.service.PartService;

import java.util.List;

@Controller
public class PartController {

    private  int page;

    private PartService partService;

    @Autowired
    public void setPartService(PartService partService) {
        this.partService = partService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView allParts(@RequestParam(defaultValue = "1") int page) {
        this.page = page;
        ModelAndView modelAndView = new ModelAndView();
        List<Part> parts = partService.PartsList(page);
        int partCount = partService.partsCount();
        int pageCount = (partCount + 9) /10;
        modelAndView.setViewName("parts");
        modelAndView.addObject("page", page);
        modelAndView.addObject("partsList", parts);
        modelAndView.addObject("partCount", partCount);
        modelAndView.addObject("pageCount", pageCount);
        return modelAndView;
    }
}
