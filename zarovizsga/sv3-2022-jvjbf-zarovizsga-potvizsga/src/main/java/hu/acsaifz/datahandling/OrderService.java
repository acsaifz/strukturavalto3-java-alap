package hu.acsaifz.datahandling;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Long saveOrder(Order order){
        return orderRepository.saveOrder(order);
    }

    public List<Order> getOrders(){
        return orderRepository.getOrders();
    }

    public int getMostExpensiveOrderPrice() {
        return orderRepository.getMostExpensiveOrderPrice();
    }


    public Map<String, Integer> collectProductsAndCount() {
        return orderRepository
                .getOrders()
                .stream()
                .collect(
                        Collectors.groupingBy(Order::getProductName, Collectors.summingInt(Order::getProductCount))
                );
    }
}
