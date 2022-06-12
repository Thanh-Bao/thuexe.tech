package tech.thuexe.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.thuexe.entity.LikeEntity;
import tech.thuexe.entity.PostEntity;
import tech.thuexe.entity.UserEntity;
import tech.thuexe.repositoryDAO.LikeRepo;
import tech.thuexe.service.LikeService;
import tech.thuexe.service.PostService;
import tech.thuexe.service.UserService;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class LikeServiceImpl implements LikeService {

    private final PostService postService;
    private final UserService userService;
    private final LikeRepo likeRepo;
    @Override
    public void modifyUserLiked(Integer postId) {
        PostEntity postEntity = postService.findById(postId);
        UserEntity userEntity = userService.getUser(userService.getUsername());
        if (postEntity == null || userEntity == null) {
            throw new IllegalStateException("User or Post not found!");
        } else {
            LikeEntity oldLike = likeRepo.findByUserAndPostLiked(userEntity, postEntity);
            if (oldLike == null) {
                LikeEntity newLike = new LikeEntity(userEntity, postEntity);
                likeRepo.save(newLike);
            } else {
                likeRepo.delete(oldLike);
            }
        }
    }
}
