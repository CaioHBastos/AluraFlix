package com.bastos.aluraflix.usecase.gateway;

import com.bastos.aluraflix.usecase.domain.request.VideoDomainRequest;
import com.bastos.aluraflix.usecase.domain.response.VideoDomainResponse;

import java.util.List;

public interface VideoGateway {

    List<VideoDomainResponse> getAll();
    VideoDomainResponse getById(Long id);
    VideoDomainResponse save(VideoDomainRequest videoDomainRequest);
}
