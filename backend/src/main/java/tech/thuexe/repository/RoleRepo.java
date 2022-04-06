package tech.thuexe.repository;

import tech.thuexe.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<RoleEntity,Long> {
    RoleEntity findByName(String name);
}
