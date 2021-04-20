package Premo.PremoAlDente.Repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import Premo.PremoAlDente.Models.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
	List<Order> findByTimestampContaining(Date timestamp);
}
