package com.fwd.takehometest;

import com.fwd.takehometest.model.TicTacToe;
import com.fwd.takehometest.service.impl.DrawerImpl;
import com.fwd.takehometest.service.impl.InputValidatorImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class TakehometestApplication extends SpringBootServletInitializer{

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(TakehometestApplication.class);
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(TakehometestApplication.class, args);
	}
//	public static void main(String[] args) {
//		final DrawerImpl drawer = new DrawerImpl(System.in);
//		final InputValidatorImpl inputValidator = new InputValidatorImpl();
//		final TicTacToe ticTacToe = new TicTacToe();
//		final Play play = new Play(drawer, inputValidator, ticTacToe);
//		play.start();
//		System.out.println();
//	}
}
