//package br.com.itbeta.newlife.security;
//
//import br.com.itbeta.newlife.model.Usuario;
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.SignatureAlgorithm;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.core.Authentication;
//import org.springframework.stereotype.Service;
//
//import io.jsonwebtoken.Jwts;
//
//import java.util.Date;
//
//@Service
//public class TokenService {
//    @Value("${newlife.jwt.secret}")
//    private String secret;
//
//    @Value("${newlife.jwt.expiration}")
//    private String expiration;
//
//    public String gerarToken(Authentication authentication) {
//        Usuario logado = (Usuario) authentication.getPrincipal();
//        Date hoje = new Date();
//        Date dataExpiracao = new Date(hoje.getTime() + Long.parseLong(expiration));
//
//        return Jwts.builder()
//                .setSubject(logado.getId().toString())
//                .setIssuedAt(hoje)
//                .setExpiration(dataExpiracao)
//                .signWith(SignatureAlgorithm.HS256, secret)
//                .compact();
//    }
//
//    public boolean isTokenValido(String token) {
//        try {
//            Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }
//
//    public Long getIdUsuario(String token) {
//        Claims claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
//        return Long.parseLong(claims.getSubject());
//    }
//
//}
