package com.utn.PhoneLines;

import com.utn.PhoneLines.model.City;
import com.utn.PhoneLines.model.Customer;
import com.utn.PhoneLines.repository.CityRepository;
import com.utn.PhoneLines.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class PhoneLinesApplication  {

	public static void main(String[] args) {

		SpringApplication.run(PhoneLinesApplication.class, args);

	}


}
