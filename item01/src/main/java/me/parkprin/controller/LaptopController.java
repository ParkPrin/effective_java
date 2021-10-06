package me.parkprin.controller;

import me.parkprin.dto.LaptopDto;
import me.parkprin.model.LaptopForm;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/laptop")
public class LaptopController {

	@RequestMapping("/add")
	public LaptopDto addLaptop(@RequestBody LaptopForm laptopForm){
		return null;
	}

}
