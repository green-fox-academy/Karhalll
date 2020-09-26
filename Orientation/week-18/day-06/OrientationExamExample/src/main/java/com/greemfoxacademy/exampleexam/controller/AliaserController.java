package com.greemfoxacademy.exampleexam.controller;

import com.greemfoxacademy.exampleexam.model.Alias;
import com.greemfoxacademy.exampleexam.service.AliaserService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class AliaserController {

  private final AliaserService aliaserService;

  @Autowired
  public AliaserController(AliaserService aliaserService) {
    this.aliaserService = aliaserService;
  }

  @GetMapping("/")
  public String getMainPage(@ModelAttribute("error") String error,
                            @ModelAttribute("aliaser") Alias aliaser,
                            @ModelAttribute("url") String url,
                            @ModelAttribute("alias") String alias,
                            Model model) {
    model.addAttribute("error", error);
    model.addAttribute("aliaser", aliaser);
    model.addAttribute("url", url);
    model.addAttribute("alias", alias);
    return "index";
  }

  @PostMapping("/save-link")
  public RedirectView saveLink(String url, String alias, RedirectAttributes attributes) {
    if (aliaserService.isAlias(alias)) {
      attributes.addFlashAttribute("error", "Your alias is already in use!");
      attributes.addFlashAttribute("url", url);
      attributes.addFlashAttribute("alias", alias);
    } else {
      attributes.addFlashAttribute("aliaser", aliaserService.newAliaser(url, alias));
    }
    return new RedirectView("/");
  }

  @GetMapping("/a/{alias}")
  public ModelAndView redirectToAlias(@PathVariable String alias, HttpServletRequest request) {
    if (aliaserService.isAlias(alias)) {
      return new ModelAndView("redirect:" + aliaserService.getAliasByAlias(alias).getUrl());
    } else {
      request.setAttribute(
          View.RESPONSE_STATUS_ATTRIBUTE, HttpStatus.NOT_FOUND);
      return new ModelAndView();
    }
  }
}
