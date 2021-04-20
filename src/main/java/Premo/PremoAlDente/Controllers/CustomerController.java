package Premo.PremoAlDente.Controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import Premo.PremoAlDente.Models.Customer;
import Premo.PremoAlDente.Repositories.CustomerRepository;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class CustomerController {
	@Autowired
	CustomerRepository customerRepository;
	
	//display all the customers in the table
	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> getAllCustomer()
	{
		try
		{
			List<Customer> customer = new ArrayList<Customer>();
			customerRepository.findAll().forEach(customer::add);
			
			if (customer.isEmpty())
			{
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<>(customer, HttpStatus.OK);
		}
		catch (Exception exception)
		{
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//display one customer based off customerId
	@GetMapping("/customers/{customerId}")
	public ResponseEntity<Customer> getCustomerlById(@PathVariable("customerId") long customerId)
	{
		Optional<Customer> customerData = customerRepository.findById(customerId);

	    if (customerData.isPresent()) 
	    {
	      return new ResponseEntity<>(customerData.get(), HttpStatus.OK);
	    } 
	    else 
	    {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	//create the customer
	@PostMapping("/customers")
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) 
	{
	    try 
	    {
	      Customer _customer = customerRepository.save(
	    		  new Customer(customer.getCustomerId(), customer.getName(), customer.getPhoneNumber(), customer.getAddress()));
	      
	      return new ResponseEntity<>(_customer, HttpStatus.CREATED);
	    } 
	    catch (Exception e) 
	    {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	//update the customer using the phone number
	@PutMapping("/customers/{customerId}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable("customerId") long customerId, @RequestBody Customer customer) 
	{
	    Optional<Customer> customerData = customerRepository.findById(customerId);

	    if (customerData.isPresent()) 
	    {
	      Customer _customer = customerData.get();
	      _customer.setCustomerId(customer.getCustomerId());
	      _customer.setPhoneNumber(customer.getPhoneNumber());
	      _customer.setName(customer.getName());
	      _customer.setAddress(customer.getAddress());
	      
	      return new ResponseEntity<>(customerRepository.save(_customer), HttpStatus.OK);
	    } 
	    else 
	    {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	 }
	
	//delete the customer based off the phone number
	 @DeleteMapping("/customers/{customerId}")
	 public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable("customerId") long customerId) 
	 {
	    try 
	    {
	    	customerRepository.deleteById(customerId);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } 
	    catch (Exception exception) 
	    {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

	 //deletes all customers in list
	  @DeleteMapping("/customers")
	  public ResponseEntity<HttpStatus> deleteAllCustomer() 
	  {
	    try 
	    {
	    	customerRepository.deleteAll();
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } 
	    catch (Exception exception) 
	    {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
}

