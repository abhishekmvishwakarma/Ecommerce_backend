package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.OrderProduct;

public interface OrderProductDao extends JpaRepository<OrderProduct, Long>
{

}
