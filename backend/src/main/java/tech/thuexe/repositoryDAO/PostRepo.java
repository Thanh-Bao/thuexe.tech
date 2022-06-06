package tech.thuexe.repositoryDAO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tech.thuexe.entity.LocationEntity;
import tech.thuexe.entity.PostEntity;

import java.util.List;

public interface PostRepo extends JpaRepository<PostEntity, Integer> {
    List<PostEntity> findAllByOrderByCreatedAtDesc();

    @Query(value = "select * from _post where user_id = ?1",nativeQuery=true)
    List<PostEntity> findAllByUserId(int id);

    Page<PostEntity> findAllByRented(boolean rented, Pageable pageable);

    Page<PostEntity> findByRentedAndLocationIn(boolean rented,
                                               List<LocationEntity> location,
                                               Pageable pageable);
}
