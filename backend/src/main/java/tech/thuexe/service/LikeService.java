package tech.thuexe.service;

import tech.thuexe.utility.Config;

import javax.annotation.security.RolesAllowed;

public interface LikeService {

    @RolesAllowed(Config.ROLE.Names.USER)
    void modifyUserLiked(Integer postId);
}
