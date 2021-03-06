package com.bastos.aluraflix.usecase.gateway;

import com.bastos.aluraflix.usecase.domain.request.CategoriaDomainRequest;
import com.bastos.aluraflix.usecase.domain.response.CategoriaDomainResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoriaGateway {
    Page<CategoriaDomainResponse> getAll(Pageable pageRequest);
    CategoriaDomainResponse getById(Long id);
    CategoriaDomainResponse save(CategoriaDomainRequest categoriaDomainRequest);
    CategoriaDomainResponse update(CategoriaDomainResponse categoriaDomainResponse);
    void deleteById(Long id);
}
