package de.wschneider.web;

public class Redirect {

    public static final String URL_ID = "redirect:/url/%s";

    public static String redirectToUrl(final Long urlId) {
        return String.format(URL_ID, urlId);
    }
}
