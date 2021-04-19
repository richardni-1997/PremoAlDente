//package Premo.PremoAlDente.Controllers;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//
//@CrossOrigin(origins = "http://localhost:4200")
//@RestController
//@RequestMapping("/api")
//public class CustomerController {
//	@Autowired
//	CustomerRepository customerRepository;
//	
//	//display all the customers in the table
//	@GetMapping("/customers")
//	public ResponseEntity<List<Customer>> getAllCustomer()
//	{
//		try
//		{
//			List<Customer> customer = new ArrayList<Customer>();
//			customerRepository.findAll().forEach(customer::add);
//			
//			if(customer.isEmpty())
//			{
//				return new ReponseEntity<>(HttpStatus.NO_CONTENT);
//			}
//			
//			return new ResponseEntity<>
//		}
//	}
//}
