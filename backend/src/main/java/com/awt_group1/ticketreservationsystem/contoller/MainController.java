package com.awt_group1.ticketreservationsystem.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping(value={"/", "/timetable", "/account" })
    public String HomePage() {
        return "index";
    }

}
