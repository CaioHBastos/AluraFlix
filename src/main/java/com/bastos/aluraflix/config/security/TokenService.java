package com.bastos.aluraflix.config.security;

import com.bastos.aluraflix.dataprovider.repository.entity.UsuarioEntity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {

    @Value("${aluraflix.jwt.expiration}")
    private String expiration;

    @Value("${aluraflix.jwt.secret}")
    private String secret;

    public String gerarToken(Authentication authenticate) {
        UsuarioEntity logado = (UsuarioEntity) authenticate.getPrincipal();
        Date hoje = new Date();
        Date dataExpiration = new Date(hoje.getTime() + Long.parseLong(expiration));

        return Jwts.builder()
                .setIssuer("API da AluraFlix")
                .setSubject(logado.getId().toString())
                .setIssuedAt(hoje)
                .setExpiration(dataExpiration)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public boolean isTokenValido(String token) {

        try {
            Jwts.parser()
                    .setSigningKey(this.secret)
                    .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Long getIdUsuario(String token) {
        Claims body = Jwts.parser()
                .setSigningKey(this.secret)
                .parseClaimsJws(token)
                .getBody();

        return Long.valueOf(body.getSubject());
    }
}