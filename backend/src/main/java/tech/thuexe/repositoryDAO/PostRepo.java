package tech.thuexe.repositoryDAO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import tech.thuexe.entity.LocationEntity;
import tech.thuexe.entity.PostEntity;

import java.util.List;

public interface PostRepo extends JpaRepository<PostEntity, Integer> {
    List<PostEntity> findAllByOrderByCreatedAtDesc();

    List<PostEntity> findAllByUser(int id);

    Page<PostEntity> findAllByRented(boolean rented, Pageable pageable);

    Page<PostEntity> findByRentedAndLocationIn(boolean rented,
                                               List<LocationEntity> location,
                                               Pageable pageable);
}
