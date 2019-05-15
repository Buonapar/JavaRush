package test.controller;

import org.springframework.web.bind.annotation.*;
import test.model.Part;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import test.service.PartService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PartController {

    private  int page; String sorted;

    private PartService partService;

    @Autowired
    public void setPartService(PartService partService) {
        this.partService = partService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView allParts(@RequestParam(defaultValue = "1") int page,@RequestParam(defaultValue = "1") int importance, @RequestParam(defaultValue = "id") String sorted) {

        List<Part> parts= new ArrayList<>();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("parts");
        int partCount = partService.partsCount();
        int pageCount = (partCount + 9) / 10;
        int countPC = partService.countPC();

        if((page < 1) || (page > pageCount)) page = 1;
        if ((importance < 1) || (importance > 3)) importance = 1;

        this.page = page;
        this.sorted = sorted;

        switch (importance) {

            case 1: parts = partService.PartsList(page, sorted);
                    break;

            case 2: parts = partService.allNecessity();
                    break;

            case 3: parts = partService.allNotNecessity();
                    break;
        }

        modelAndView.addObject("page", page);
        modelAndView.addObject("sorted", sorted);
        modelAndView.addObject("importance", importance);
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

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ModelAndView searchParts(@RequestParam String name) {
        List<Part> searchParts = partService.search(name);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("search");
        modelAndView.addObject("searchParts", searchParts);
        modelAndView.addObject("query", name);
        return modelAndView;
    }
}
