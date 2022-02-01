package io.h5z.bootolith.apps.invoice.adapter.primary;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
    
    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("moduleName", "invoice");
        return "apps/invoice/index";
    }

}
