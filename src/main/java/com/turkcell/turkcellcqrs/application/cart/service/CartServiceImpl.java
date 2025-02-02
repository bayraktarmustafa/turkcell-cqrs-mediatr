package com.turkcell.turkcellcqrs.application.cart.service;

import com.turkcell.turkcellcqrs.domain.entity.Cart;
import com.turkcell.turkcellcqrs.domain.entity.Student;
import com.turkcell.turkcellcqrs.persistence.cart.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    final CartRepository cartRepository;


    @Override
    public Cart createCartForStudent(Student student) {
        Cart cart = new Cart();
        cart.setStudent(student);
        cartRepository.save(cart);
        return cart;

    }

    @Override
    public Cart getOrCreateCartForStudent(Student student) {
        Cart cart= cartRepository.findByStudentId(student.getId().orElse(null));

        if (cart== null)
            cart= this.createCartForStudent(student);
    }
}
