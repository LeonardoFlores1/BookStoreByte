package pruebaTecnica.bookStore.controller.like;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pruebaTecnica.bookStore.dto.request.like.LikeDto;
import pruebaTecnica.bookStore.dto.response.like.LikeResponse;
import pruebaTecnica.bookStore.service.LikeService;

@RestController
@Slf4j
@RequestMapping
public class LikeBookController {

    @Autowired
    LikeService likeService;
    @PostMapping("/likes")
    public ResponseEntity<LikeResponse> saveLike(@RequestBody LikeDto likeDto){
        try {
            LikeResponse likeResponse = likeService.post(likeDto);
            return new ResponseEntity<>(likeResponse, HttpStatus.CREATED);
        } catch (Exception e){
            log.error(e.getMessage(), e);
            return new ResponseEntity<>(LikeResponse.builder().build(), HttpStatus.CONFLICT);
        }
    }
}
