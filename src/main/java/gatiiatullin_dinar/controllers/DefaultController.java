package gatiiatullin_dinar.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


    @Controller
    public class DefaultController {

        @RequestMapping("/admin")
        public String index() {
            // ищет файл index.html в resources/templates
            return "index";
        }
}
