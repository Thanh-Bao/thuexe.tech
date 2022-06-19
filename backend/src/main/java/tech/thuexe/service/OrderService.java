package tech.thuexe.service;

import tech.thuexe.entity.OrderEntity;
import tech.thuexe.utility.Config;

import javax.annotation.security.RolesAllowed;
import java.util.List;

public interface OrderService {

    @RolesAllowed(Config.ROLE.Names.USER)
    OrderEntity save(OrderEntity orderEntity, int postId);

    @RolesAllowed(Config.ROLE.Names.USER)
    List<OrderEntity> findAllByUser();
}
