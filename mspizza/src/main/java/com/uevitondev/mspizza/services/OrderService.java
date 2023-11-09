package com.uevitondev.mspizza.services;

import com.uevitondev.mspizza.dtos.CartItemDTO;
import com.uevitondev.mspizza.dtos.OrderDTO;
import com.uevitondev.mspizza.dtos.ShoppingCartDTO;
import com.uevitondev.mspizza.entities.*;
import com.uevitondev.mspizza.enums.OrderStatus;
import com.uevitondev.mspizza.exceptions.ResourceNotFoundException;
import com.uevitondev.mspizza.repositories.*;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.Set;

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

        if (!userRepository.existsById(dto.getUserId())) {
            throw new ResourceNotFoundException("user not found, id: " + dto.getUserId());
        }
        if (!userRepository.existsById(dto.getPizzeriaId())) {
            throw new ResourceNotFoundException("pizzeria not found, id: " + dto.getUserId());
        }
        Order order = new Order();
        User user = userRepository.getReferenceById(dto.getUserId());
        Pizzeria pizzeria = pizzeriaRepository.getReferenceById(dto.getPizzeriaId());
        order.setInstant(Instant.now());
        order.setStatus(OrderStatus.PENDENTE.toString());
        order.setUser(user);
        order.setPizzeria(pizzeria);
        saveOrderItemByOrder(order, dto.getCartItems());
        order.setTotal();
        order = orderRepository.save(order);

        return new OrderDTO(order);
    }

    public void saveOrderItemByOrder(Order order, Set<CartItemDTO> cartItemsDto) {
        for (CartItemDTO cartItem : cartItemsDto) {
            try {
                Product product = productRepository.getReferenceById(cartItem.getProductId());
                OrderItem orderItem = new OrderItem();
                orderItem.setProduct(product);
                orderItem.setQuantity(cartItem.getQuantity());
                orderItem.setSubtotal();
                orderItem.setObservation(cartItem.getObservation());
                orderItem.setOrder(order);
                order.getOrderItems().add(orderItem);
                orderItemRepository.save(orderItem);
            } catch (EntityNotFoundException e) {
                throw new ResourceNotFoundException("product not found, id: " + cartItem.getProductId());
            }
        }
    }
}
