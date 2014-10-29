package de.wschneider.web;

import de.wschneider.entity.UrlEntity;
import de.wschneider.entity.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/url")
@Controller
public class UrlController {

    @Autowired
    private UrlRepository urlRepository;

    @RequestMapping
    public String findAllUrls(Model model) {
        final List<UrlEntity> all = urlRepository.findAll();
        model.addAttribute("urls", all);
        return "url/list";
    }
}
