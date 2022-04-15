package com.fwd.takehometest.controller;

import com.fwd.takehometest.Play;
import com.fwd.takehometest.model.TicTacToe;
import com.fwd.takehometest.service.impl.DrawerImpl;
import com.fwd.takehometest.service.impl.InputValidatorImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class GameController {

    final DrawerImpl drawer = new DrawerImpl(System.in);
    final InputValidatorImpl inputValidator = new InputValidatorImpl();
    final TicTacToe ticTacToe = new TicTacToe();
    final Play play = new Play(drawer, inputValidator, ticTacToe);

    @RequestMapping("/")
    public String home(Map<String, Object> model) {
        model.put("message", "this.message");
        return "index";
    }

    @RequestMapping("/boardsize/{size}")
    public String boardsize(Map<String, Object> model, @PathVariable String size) {
        play.initiate(size, model);
        model.put("message", size);
        return "index";
    }

    @RequestMapping("/coordinate/{coordinate}")
    public String coordinate(Map<String, Object> model, @PathVariable String coordinate) {
        play.start(coordinate, model);
        model.put("message", coordinate);
        return "index";
    }

}
