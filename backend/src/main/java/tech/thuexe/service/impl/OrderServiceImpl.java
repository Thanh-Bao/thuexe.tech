package tech.thuexe.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.thuexe.entity.OrderEntity;
import tech.thuexe.entity.PostEntity;
import tech.thuexe.entity.UserEntity;
import tech.thuexe.repositoryDAO.OrderRepo;
import tech.thuexe.service.OrderService;
import tech.thuexe.service.PostService;
import tech.thuexe.service.UserService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final UserService userService;
    private final PostService postService;
    private final OrderRepo orderRepo;

    @Override
    public OrderEntity save(OrderEntity orderEntity, int postId) {
        PostEntity postEntity = postService.findById(postId);
        UserEntity userEntity = userService.getUser(userService.getUsername());
        if (postEntity == null || userEntity == null) {
            throw new IllegalStateException("User or Post not found!");
        } else {
            postEntity.setRented(true);
            orderEntity.setUser(userEntity);
            orderEntity.setPost(postEntity);
            return orderRepo.save(orderEntity);
        }
    }

    @Override
    public List<OrderEntity> findAllByUser() {
        UserEntity userEntity = userService.getUser(userService.getUsername());
        if (userEntity == null) {
            throw new IllegalStateException("User not found!");
        }else {
            return orderRepo.findAllByUser(userEntity);
        }
    }
}
