package pl.pszczolkowski.demo.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.pszczolkowski.demo.service.MovieService;


@Aspect
@Component
public class Email {

    MovieService movieService;

    @Autowired
    public Email(MovieService movieService) {
        this.movieService = movieService;
    }

    @After("@annotation(MovieAnnotation)")
    private void afterPost(){
        movieService.sendSimpleMail("paulina.kurzyna0628@gmail.com", "Sratata", "Nie ma ptaszka");
        System.out.println("afterPost");
    }
}
