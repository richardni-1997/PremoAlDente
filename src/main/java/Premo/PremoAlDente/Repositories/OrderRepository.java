package Premo.PremoAlDente.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import Premo.PremoAlDente.Models.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
}
