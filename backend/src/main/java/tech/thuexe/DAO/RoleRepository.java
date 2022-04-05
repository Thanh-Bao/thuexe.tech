package tech.thuexe.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.thuexe.entity.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity,Long> {
    RoleEntity findByName(String name);
}
