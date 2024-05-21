package pruebaTecnica.bookStore.repository.service;

import pruebaTecnica.bookStore.entity.like.Like;

import java.util.List;
import java.util.Optional;

public interface LikeRepositoryService {

    Like save(Like like);

    List<Like> findAll();

    Optional<Like> findById(Integer bookId);
}
