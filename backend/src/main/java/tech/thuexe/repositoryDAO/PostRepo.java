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
    int countByRented(boolean rented);
    @Query(value = "select * from _post JOIN _user ON _post.user_id = _user.id where _user._username = ?1",nativeQuery=true)
    List<PostEntity> findByUsername(String username);

    Page<PostEntity> findAllByRented(boolean rented, Pageable pageable);

    Page<PostEntity> findByRentedAndLocationIn(boolean rented,
                                               List<LocationEntity> location,
                                               Pageable pageable);
    List<PostEntity> findAllByTitleContains(String name);
    List<PostEntity> findAllByRentedOrderByTitleDesc(boolean rented, Pageable pageable);
    List<PostEntity> findAllByRentedOrderByTitleAsc(boolean rented, Pageable pageable);

}
