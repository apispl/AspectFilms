package pl.pszczolkowski.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import pl.pszczolkowski.demo.model.Movie;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {
    List<Movie> movieList = new ArrayList<>();
    JavaMailSender javaMailSender;

    @Autowired
    public MovieService(JavaMailSender javaMailSender) {
        movieList.add(new Movie("JURASSIC WORLD", "Colin Trevorrow",2015L));
        movieList.add(new Movie("HOBBIT: NIEZWYKŁA PODRÓŻ", "Peter Jackson",2012L));
        movieList.add(new Movie("ZIELONA MILA", "Frank Darabont",1999L));
        movieList.add(new Movie("JAK ZOSTAŁEM GANGSTEREM. HISTORIA PRAWDZIWA", "Maciej Kawulski",2019L));
        this.javaMailSender = javaMailSender;
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    public Movie addMovie(Movie movie){
        movieList.add(movie);
        return movie;
    }

    public void sendSimpleMail(String to, String subject, String text){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(text);

        javaMailSender.send(simpleMailMessage);
    }

}
