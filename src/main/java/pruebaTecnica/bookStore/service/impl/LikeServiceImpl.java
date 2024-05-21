package pruebaTecnica.bookStore.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pruebaTecnica.bookStore.dto.request.like.LikeDto;
import pruebaTecnica.bookStore.dto.response.like.LikeResponse;
import pruebaTecnica.bookStore.entity.book.Books;
import pruebaTecnica.bookStore.entity.like.Like;
import pruebaTecnica.bookStore.repository.impl.BookServiceImpl;
import pruebaTecnica.bookStore.repository.impl.LikeRepositoryImpl;
import pruebaTecnica.bookStore.service.LikeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class LikeServiceImpl implements LikeService {

    @Autowired
    LikeRepositoryImpl likeRepository;

    @Autowired
    BookServiceImpl bookService;
    @Override
    public LikeResponse post(LikeDto likeDto) {
        try {
            LikeResponse likeResponse = new LikeResponse();
            Like like = new Like();
            List<String> customers = new ArrayList<>();
            Optional<Books> books = bookService.findById(likeDto.getBookId());
            Optional<Like> likes = likeRepository.findById(likeDto.getBookId());
            if (books.isPresent()){
                if (likes.isPresent()){
                    like.setBookId(likeDto.bookId);
                    like.setLikes(likes.get().getLikes() + 1);
                    customers = likes.get().getCustomers();
                    customers.add(likeDto.getCustomerEmail());
                    like.setCustomers(customers);
                    likeResponse.setCustomers(customers);
                    likeResponse.setLikes(likes.get().getLikes() + 1);
                } else {
                    like.setBookId(likeDto.getBookId());
                    like.setLikes(1);
                    customers.add(likeDto.getCustomerEmail());
                    like.setCustomers(customers);
                    likeResponse.setCustomers(customers);
                    likeResponse.setLikes(1);
                }

                likeRepository.save(like);
                likeResponse.setBookId(likeDto.getBookId());
            }
            return likeResponse;
        } catch (Exception e){
            log.error(e.getMessage(), e);
            return LikeResponse.builder().build();
        }
    }
}
