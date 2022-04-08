package tech.thuexe.repository;
import tech.thuexe.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserEntity,String> {
    UserEntity findByUsername(String username);
    boolean existsByUsername(String username);
}
