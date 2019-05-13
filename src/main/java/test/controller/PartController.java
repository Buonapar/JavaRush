package test.controller;

import org.springframework.web.bind.annotation.*;
import test.model.Part;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
        int pageCount = (partCount + 9) / 10;
        int countPC = partService.countPC();
        modelAndView.setViewName("parts");
        modelAndView.addObject("page", page);
        modelAndView.addObject("partsList", parts);
        modelAndView.addObject("partCount", partCount);
        modelAndView.addObject("pageCount", pageCount);
        modelAndView.addObject("countPC", countPC);
        return modelAndView;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editPage(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        Part part = partService.getId(id);
        modelAndView.setViewName("editParts");
        modelAndView.addObject("part", part);
        return modelAndView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView edit(@ModelAttribute("part") Part part) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        partService.edit(part);
        return modelAndView;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public  ModelAndView delete(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        Part part = partService.getId(id);
        partService.delete(part);
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editParts");
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addPart(@ModelAttribute("part") Part part) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        partService.add(part);
        return modelAndView;
    }
}
