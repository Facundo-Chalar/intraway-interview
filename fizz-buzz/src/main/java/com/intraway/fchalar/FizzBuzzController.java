package com.intraway.fchalar;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.IntStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.intraway.fchalar.exceptions.BadRequestException;

@RestController
public class FizzBuzzController {

	
	private final AtomicLong fizzCounter = new AtomicLong();
	private static final String WRONG_VALUE_ERROR_MESSAGE = "Los parametros enviados son incorrectos";
	private static final String MULTIPLE_OF_3_FOUND = "Se encontraron múltiplos de 3";
	private static final String MULTIPLE_OF_5_FOUND = "Se encontraron múltiplos de 5";
	private static final String MULTIPLE_OF_BOTH_FOUND = "Se encontraron múltiplos de 3 y de 5";
	private static final String NO_MULTIPLE_FOUND = "No se encontraron múltiplos de 3 ni de 5";
	
	
	/*	CrossOrigin annotation added to avoid CORS restriction 
		with the angular project if both are served locally. 
		This should obviously be removed for a real world app.
	*/
	@CrossOrigin(origins = "http://localhost:8000")
	@GetMapping(value="fizzbuzz/{min}/{max}")
	public FizzBuzz createFizzBuzz(	@PathVariable int min,
									@PathVariable int max)
	throws BadRequestException
	{
		if(min > max) throw new BadRequestException();
		Timestamp fizzBuzzTime = new Timestamp(System.currentTimeMillis());
		ArrayList<String> fizzBuzzList = generateFizzBuzzList(min, max);
		String description = getListDescription(fizzBuzzList);
		
		return new FizzBuzz(fizzCounter.incrementAndGet(), fizzBuzzList, fizzBuzzTime, description);
	}
	
	private String calculateFizzBuzz(int value) {
			return value % 3 == 0 ? (value %5 == 0 ? "FizzBuzz":"Fizz"):(value %5 == 0? "Buzz": Integer.toString(value));
	}
	
	private ArrayList<String> generateFizzBuzzList(int min, int max) {
		ArrayList<String> list = new ArrayList<String>();
		
		IntStream.rangeClosed(min, max)
		.mapToObj(value -> calculateFizzBuzz(value))
		.forEach(x-> list.add(x.toString()));
		
		return list;
	}
	
	private String getListDescription(ArrayList<String> list) {
		if(list.size() >= 30) return MULTIPLE_OF_BOTH_FOUND; 
		return list.contains("Fizz") ? (list.contains("Buzz") ? MULTIPLE_OF_BOTH_FOUND:MULTIPLE_OF_3_FOUND):(list.contains("Buzz")? MULTIPLE_OF_5_FOUND: NO_MULTIPLE_FOUND);
	}
	
	@ExceptionHandler({BadRequestException.class, NumberFormatException.class})
	void wrongValuesExceptionHandler(HttpServletResponse response) throws IOException{
			response.sendError(HttpStatus.BAD_REQUEST.value(), WRONG_VALUE_ERROR_MESSAGE);
	}

}
