package Premo.PremoAlDente.Controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import Premo.PremoAlDente.Models.Order;
import Premo.PremoAlDente.Repositories.OrderRepository;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class OrderController {
	
	@Autowired
	OrderRepository orderRepository;
	
	@GetMapping("/orders")
	public ResponseEntity<List<Order>> getAllOrders() {
		try {
			List<Order> orders = new ArrayList<Order>();
			  orderRepository.findAll().forEach(orders::add);
			 
			if (orders.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<>(orders, HttpStatus.OK);
		   }catch (Exception e) {
			   return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		   }
		}
	
	@GetMapping("/orders/{orderId}")
	public ResponseEntity<Order> getOrderById(@PathVariable("orderId") long orderId) {
		Optional<Order> ordersData = orderRepository.findById(orderId);
		
		if (ordersData.isPresent()) {
			return new ResponseEntity<>(ordersData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/orders")
	public ResponseEntity<Order> createOrder(@RequestBody Order order) {
		try {
			System.out.println(order);
			
		  Order _orders = orderRepository
			 .save(new Order(order.getProducts(), order.getTimestamp(), order.getTotal(), order.getZipcode(),
					 order.getCustomerId(), order.getEmployeeId()));
		  	
		  return new ResponseEntity<>(_orders, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	  }
	
	@PutMapping("/orders/{orderId}")
	public ResponseEntity<Order> updateOrder(@PathVariable("orderId") long orderId, @RequestBody Order order){
	  Optional<Order> ordersData = orderRepository.findById(orderId);
	  
	  if (ordersData.isPresent()) {
		  Order _order = ordersData.get();
		  _order.setCustomerId(order.getCustomerId());
		  _order.setEmployeeId(order.getEmployeeId());
		  _order.setTimestamp(order.getTimestamp());
		  _order.setProducts(order.getProducts());
		  _order.setTotal(order.getTotal());
		  _order.setZipcode(order.getZipcode());
		  return new ResponseEntity<>(orderRepository.save(_order), HttpStatus.OK);
	  	} else {
	  		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	  	}
	   }
	
	@DeleteMapping("/orders/{orderId}")
	public ResponseEntity<HttpStatus> deleteOrder(@PathVariable("orderId") long orderId) {
		try {
		  orderRepository.deleteById(orderId);
		  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
		  return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
