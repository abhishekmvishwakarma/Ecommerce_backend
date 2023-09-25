package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Order;

public interface OrderDao extends JpaRepository<Order, Long>
{

}
