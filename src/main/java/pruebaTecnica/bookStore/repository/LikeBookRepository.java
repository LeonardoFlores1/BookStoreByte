package pruebaTecnica.bookStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pruebaTecnica.bookStore.entity.like.Like;

@Repository
public interface LikeBookRepository extends JpaRepository<Like, Integer> {
}
