package com.services;

import java.util.List;

import com.model.Cart;

public interface CartService 
{
	Cart addCartToUser(Cart cart,long idUser);
	void deleteCart(long id);
	List<Cart> findCartForUser(long idUser);
	Cart findCartById(long id);
	void removeFromCart(long idCart,long idUser);
	Cart findByCartName(String name);

}
