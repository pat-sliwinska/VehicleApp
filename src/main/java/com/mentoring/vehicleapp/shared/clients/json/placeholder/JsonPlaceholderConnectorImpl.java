package com.mentoring.vehicleapp.shared.clients.json.placeholder;

import com.mentoring.vehicleapp.shared.clients.json.placeholder.model.CommentResponse;
import com.mentoring.vehicleapp.shared.clients.json.placeholder.model.PostResponse;
import com.mentoring.vehicleapp.shared.common.http.WebClientConnector;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class JsonPlaceholderConnectorImpl implements JsonPlaceholderApiConnector {

    private WebClientConnector webClientConnector;

    @Override
    public Optional<PostResponse[]> getPosts() {
        return webClientConnector.retrieveRequest();
    }

    @Override
    public Optional<CommentResponse[]> getCommentsByPost(Long id) {
        return null;
    }

}
//TODO
//pobierz posty ze strony https://jsonplaceholder.typicode.com/posts
// dla każdego posta pobierz dla niego komentarze -> /post/{id}/comments
//zrób endpoint który zwraca kolekcję postów wraz z przypisanymi komentarzami do poszczegolnego posta
// poczytaj o WebClient z biblioteki webflux i o typach Mono i Flux