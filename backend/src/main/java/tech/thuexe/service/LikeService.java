package tech.thuexe.service;

import javax.annotation.security.RolesAllowed;

public interface LikeService {

    @RolesAllowed("USER")
    void modifyUserLiked(Integer postId);
}
