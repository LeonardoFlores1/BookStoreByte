package pruebaTecnica.bookStore.service;

import pruebaTecnica.bookStore.dto.request.like.LikeDto;
import pruebaTecnica.bookStore.dto.response.like.LikeResponse;

public interface LikeService {

    LikeResponse post(LikeDto likeDto);
}
