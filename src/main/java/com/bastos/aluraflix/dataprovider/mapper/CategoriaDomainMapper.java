package com.bastos.aluraflix.dataprovider.mapper;

import com.bastos.aluraflix.dataprovider.repository.entity.CategoriaEntity;
import com.bastos.aluraflix.usecase.domain.request.CategoriaDomainRequest;
import com.bastos.aluraflix.usecase.domain.response.CategoriaDomainResponse;

import java.util.List;
import java.util.stream.Collectors;

public class CategoriaDomainMapper {

    public static List<CategoriaDomainResponse> toDomain(List<CategoriaEntity> categoriasEntities) {
        return categoriasEntities.stream()
                .map(categoriaEntity -> CategoriaDomainResponse.builder()
                        .id(categoriaEntity.getId())
                        .titulo(categoriaEntity.getTitulo())
                        .cor(categoriaEntity.getCor())
                        .build()).collect(Collectors.toList());
    }

    public static CategoriaDomainResponse toDomain(CategoriaEntity categoriaEntity) {
        return CategoriaDomainResponse.builder()
                .id(categoriaEntity.getId())
                .titulo(categoriaEntity.getTitulo())
                .cor(categoriaEntity.getCor())
                .build();
    }

    public static CategoriaEntity toEntity(CategoriaDomainRequest categoriaDomainRequest) {
        return CategoriaEntity.builder()
                .titulo(categoriaDomainRequest.getTitulo())
                .cor(categoriaDomainRequest.getCor())
                .build();
    }

    public static CategoriaEntity toEntity(CategoriaDomainResponse categoriaDomainResponse) {
        return CategoriaEntity.builder()
                .id(categoriaDomainResponse.getId())
                .titulo(categoriaDomainResponse.getTitulo())
                .cor(categoriaDomainResponse.getCor())
                .build();
    }
}