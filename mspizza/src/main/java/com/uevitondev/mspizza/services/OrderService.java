package com.uevitondev.mspizza.services;

import com.uevitondev.mspizza.dtos.CartItemDTO;
import com.uevitondev.mspizza.dtos.OrderDTO;
import com.uevitondev.mspizza.dtos.ShoppingCartDTO;
import com.uevitondev.mspizza.entities.*;
import com.uevitondev.mspizza.enums.OrderStatus;
import com.uevitondev.mspizza.exceptions.ResourceNotFoundException;
import com.uevitondev.mspizza.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PizzeriaRepository pizzeriaRepository;
    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    public List<OrderDTO> findAllOrders() {
        return orderRepository.findAll().stream().map(OrderDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public OrderDTO findOrderById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("order not found, for id: " + id));
        return new OrderDTO(order);
    }

    @Transactional
    public OrderDTO insertNewOrder(ShoppingCartDTO dto) {

        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("user not found, for id: " + dto.getUserId()));

        Pizzeria pizzeria = pizzeriaRepository.findById(dto.getPizzeriaId())
                .orElseThrow(() -> new ResourceNotFoundException("pizzeria not found, for id: " + dto.getPizzeriaId()));

        Order order = new Order();
        order.setInstant(Instant.now());
        order.setDescription(dto.getDescription());
        order.setStatus(OrderStatus.PENDENTE.toString());
        order.setUser(user);
        order.setPizzeria(pizzeria);

        saveOrderItemByOrder(order, dto.getCartItens());
        Double total = 0.0;
        for (OrderItem orderItem : order.getOrderItems()) {
            total += orderItem.getSubtotal();
        }
        order.setTotal(total);
        order = orderRepository.save(order);
        return new OrderDTO(order);
    }

    public void saveOrderItemByOrder(Order order, List<CartItemDTO> cartItems) {

        for (CartItemDTO cartItem : cartItems) {
            OrderItem orderItem = new OrderItem();
            Product product = productRepository.findById(cartItem.getProductId())
                    .orElseThrow(() -> new ResourceNotFoundException("product not found, for id: " + cartItem.getProductId()));

            orderItem.setProduct(product);
            orderItem.setQtd(cartItem.getQtd());
            orderItem.setOrder(order);
            Double subtotal = cartItem.getQtd() * product.getPrice();
            orderItem.setSubtotal(subtotal);
            order.getOrderItems().add(orderItem);
            orderItemRepository.save(orderItem);
        }
    }
}
