package pruebaTecnica.bookStore.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pruebaTecnica.bookStore.entity.like.Like;
import pruebaTecnica.bookStore.repository.LikeBookRepository;
import pruebaTecnica.bookStore.repository.service.LikeRepositoryService;

import java.util.List;
import java.util.Optional;

@Service
public class LikeRepositoryImpl implements LikeRepositoryService {

    @Autowired
    LikeBookRepository likeBookRepository;
    @Override
    public Like save(Like like) {
        return likeBookRepository.save(like);
    }

    @Override
    public List<Like> findAll() {
        return likeBookRepository.findAll();
    }

    @Override
    public Optional<Like> findById(Integer bookId) {
        return likeBookRepository.findById(bookId);
    }
}
