package tech.thuexe.service;

import tech.thuexe.entity.OrderEntity;
import tech.thuexe.utility.CustomException;

import java.util.List;

public interface OrderService {

    OrderEntity save(OrderEntity orderEntity, int postId);

    List<OrderEntity> findAllByUser();

    OrderEntity findById(int id);

    void checkout(int id) throws CustomException;
}
