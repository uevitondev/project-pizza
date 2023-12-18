package com.uevitondev.mspizza.services;

import com.uevitondev.mspizza.dtos.CartItemDTO;
import com.uevitondev.mspizza.dtos.OrderDTO;
import com.uevitondev.mspizza.dtos.ShoppingCartDTO;
import com.uevitondev.mspizza.entities.*;
import com.uevitondev.mspizza.enums.OrderStatus;
import com.uevitondev.mspizza.exceptions.ResourceNotFoundException;
import com.uevitondev.mspizza.repositories.*;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.Set;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final UserRepository userRepository;
    private final PizzeriaRepository pizzeriaRepository;
    private final ProductRepository productRepository;

    public OrderService(OrderRepository orderRepository, OrderItemRepository orderItemRepository,
                        UserRepository userRepository, PizzeriaRepository pizzeriaRepository,
                        ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
        this.userRepository = userRepository;
        this.pizzeriaRepository = pizzeriaRepository;
        this.productRepository = productRepository;
    }

    @Transactional(readOnly = true)
    public List<OrderDTO> findAllOrders() {
        return orderRepository.findAll().stream().map(OrderDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public List<OrderDTO> findAllOrdersByUser() {
        User user = UserService.userAuthenticated();
        return orderRepository.findByUser(user).stream().map(OrderDTO::new).toList();
    }


    @Transactional(readOnly = true)
    public OrderDTO findOrderById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("order not found, for id: " + id));
        return new OrderDTO(order);
    }

    @Transactional
    public OrderDTO saveNewOrder(ShoppingCartDTO dto) {
        User user = UserService.userAuthenticated();

        if (!userRepository.existsById(dto.getPizzeriaId())) {
            throw new ResourceNotFoundException("pizzeria not found, id: " + dto.getPizzeriaId());
        }
        Pizzeria pizzeria = pizzeriaRepository.getReferenceById(dto.getPizzeriaId());

        Order order = new Order();
        order.setUser(user);
        order.setInstant(Instant.now());
        order.setStatus(OrderStatus.PENDENTE.toString());
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