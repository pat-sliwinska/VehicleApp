package com.mentoring.vehicleapp.shared.clients.json.placeholder;

import com.mentoring.vehicleapp.shared.clients.json.placeholder.model.CommentResponse;
import com.mentoring.vehicleapp.shared.clients.json.placeholder.model.PostResponse;
import com.mentoring.vehicleapp.shared.common.http.RequestData;
import com.mentoring.vehicleapp.shared.common.http.WebClientConnector;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class JsonPlaceholderConnectorImpl implements JsonPlaceholderApiConnector {

    private final  WebClientConnector webClientConnector;

    @Override
    public Optional<PostResponse[]> getPosts() {
        RequestData<PostResponse[]> postResponseRequestData = RequestData.<PostResponse[]>builder()
                .method(HttpMethod.GET)
                .url("https://jsonplaceholder.typicode.com/posts")
                .headers(Map.of(HttpHeaders.ACCEPT, "application/json"))
                .responseBodyClass(PostResponse[].class)
                .build();
        return webClientConnector.retrieveRequest(postResponseRequestData);
    }

    @Override
    public Optional<CommentResponse[]> getCommentsByPost(Long id) {
        RequestData<CommentResponse[]> commentResponseRequestData = RequestData.<CommentResponse[]>builder()
                .method(HttpMethod.GET)
                .url("https://jsonplaceholder.typicode.com/post/" + id + "/comments")
                .headers(Map.of(HttpHeaders.ACCEPT, "application/json"))
                .responseBodyClass(CommentResponse[].class)
                .build();
        return webClientConnector.retrieveRequest(commentResponseRequestData);
    }

}
//TODO
//pobierz posty ze strony https://jsonplaceholder.typicode.com/posts
// dla każdego posta pobierz dla niego komentarze -> /post/{id}/comments
//zrób endpoint który zwraca kolekcję postów wraz z przypisanymi komentarzami do poszczegolnego posta
// poczytaj o WebClient z biblioteki webflux i o typach Mono i Flux