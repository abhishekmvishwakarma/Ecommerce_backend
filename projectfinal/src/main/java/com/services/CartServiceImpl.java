package com.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.CartDao;
import com.dao.UserDao;
import com.model.Cart;
import com.model.User;

@Service
@Transactional
@Component
public class CartServiceImpl implements CartService
{
	@Autowired
	private CartDao cartDao;

	@Autowired
	private UserDao userDao;
	
	@Override
	public Cart addCartToUser(Cart cart, long idUser) {
		User user = userDao.findById(idUser).orElse(null);
		user.addCartToUser(cart);
		return cartDao.save(cart);
	}

	@Override
	public void deleteCart(long id) {
		cartDao.deleteById(id);
		
	}

	@Override
	public List<Cart> findCartForUser(long idUser) {
		User user = userDao.findById(idUser).orElse(null);
		return user.getCarts();
	}

	@Override
	public Cart findCartById(long id) {
		return cartDao.findById(id).orElse(null);
	}

	@Override
	public void removeFromCart(long idCart, long idUser) {
		User user = userDao.findById(idUser).orElse(null);
		Cart cart = cartDao.findById(idCart).orElse(null);
		user.removeFromCart(cart);
		cartDao.delete(cart);
		
	}

	@Override
	public Cart findByCartName(String name) {
		Optional<Cart> carts = cartDao.findByName(name);
		if(carts.isPresent())
		{
			Cart cart = carts.get();
			return cart;
		}
		return null;
	}

}
