package com.lucasdev.desafio;

import com.lucasdev.desafio.entities.Order;
import com.lucasdev.desafio.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
public class DesafioApplication implements CommandLineRunner {

	@Autowired
	private OrderService orderService;

	public static void main(String[] args) {
		SpringApplication.run(DesafioApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Scanner sc = new Scanner(System.in).useLocale(Locale.US);
		Locale.setDefault(Locale.US);

		System.out.println("Dados do pedido: ");
		System.out.print("Codigo: ");
		int code = sc.nextInt();
		System.out.print("valor Básico: ");
		double basic = sc.nextDouble();
		System.out.print("Porcentagem do desconto: ");
		double discount = sc.nextDouble();

		Order order = new Order(code, basic, discount);
		double total = orderService.total(order);

		System.out.println("Pedido código " + code);
		System.out.println("Valor total: R$ " + String.format("%.2f", total));


		sc.close();

	}
}
