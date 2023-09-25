package com.services;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.OrderProductDao;
import com.model.OrderProduct;

@Service
@Transactional
@Component
public class OrderProductServiceImpl implements OrderProductService
{
	@Autowired
	private OrderProductDao oderOrderProductDao;

	@Override
	public OrderProduct create(
			@NotNull(message = "The products for order cannot be null.") @Valid OrderProduct orderProduct) {
		return this.oderOrderProductDao.save(orderProduct);
	}
	
	
}
