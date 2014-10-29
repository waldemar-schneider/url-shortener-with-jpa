package de.wschneider.web;

import com.google.common.hash.Hashing;
import de.wschneider.entity.UrlEntity;
import de.wschneider.entity.UrlRepository;
import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/url")
@Controller
public class UrlController {

    public static final String[] SCHEMES = new String[] {"http", "https"};
    public static final UrlValidator URL_VALIDATOR = new UrlValidator(SCHEMES);

    @Autowired
    private UrlRepository urlRepository;

    @RequestMapping
    public String findAllUrls(Model model) {
        final List<UrlEntity> all = urlRepository.findAll();
        model.addAttribute("urls", all);
        return "url/list";
    }

    @RequestMapping("{urlId}")
    public String findUrlById(Model model, @PathVariable Long urlId) {
        final UrlEntity urlEntity = urlRepository.findOne(urlId);

        model.addAttribute("url", urlEntity);

        return "url/edit";
    }

    @RequestMapping("/add")
    public String addUrl(Model model){
        model.addAttribute("url", new UrlEntity());
        return "url/edit";
    }

    @RequestMapping("/save")
    public String saveUrl(Model model, @Valid UrlEntity urlEntity, BindingResult bindingResult) {
        if (!URL_VALIDATOR.isValid(urlEntity.getUrl())) {
            final FieldError fieldError = new FieldError("url", "url", "no valid url");
            bindingResult.addError(fieldError);
            model.addAttribute("bindingResult", bindingResult);
            model.addAttribute("url", urlEntity);
            return "url/edit";
        }

        // TODO hash url
        final String hash = Hashing.sha1().hashBytes(urlEntity.getUrl().getBytes()).toString();
        urlEntity.setHash(hash);

        final UrlEntity save = urlRepository.save(urlEntity);

        return Redirect.redirectToUrl(save.getId());
    }
}
