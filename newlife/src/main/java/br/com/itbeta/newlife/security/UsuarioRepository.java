//package br.com.itbeta.newlife.security;
//
//import br.com.itbeta.newlife.model.Usuario;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//import java.util.Optional;
//
//@Repository
//public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
//
//    @Query("SELECT a FROM Usuario a WHERE a.email = :email")
//    Optional<Usuario> findByEmail(String email);
//
//}
