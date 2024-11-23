package br.com.solarsync.javabackend.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfigurations {

  @Autowired
  private SecurityFilter securityFilter;

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
    httpSecurity
        .csrf(csrf -> csrf.disable()) // Desabilita CSRF para facilitar o uso de tokens
        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .authorizeHttpRequests(authorizeRequests -> authorizeRequests
            // Permitir acesso público para todos os endpoints de /auth
            .requestMatchers("/auth/**").permitAll()

            // Permitir acesso às páginas HTML do Thymeleaf sem autenticação
            .requestMatchers("/clientes/**", "/empresas/**", "/campanhas/**", "/servicos/**").permitAll()

            // Configurar permissões para os endpoints de API das entidades
            .requestMatchers(HttpMethod.GET, "/api/clientes/**").hasAnyRole("USER", "ADMIN")
            .requestMatchers(HttpMethod.POST, "/api/clientes/**").hasRole("ADMIN")
            .requestMatchers(HttpMethod.PUT, "/api/clientes/**").hasRole("ADMIN")
            .requestMatchers(HttpMethod.DELETE, "/api/clientes/**").hasRole("ADMIN")
            .requestMatchers(HttpMethod.GET, "/api/empresas/**").hasAnyRole("USER", "ADMIN")
            .requestMatchers(HttpMethod.POST, "/api/empresas/**").hasRole("ADMIN")
            .requestMatchers(HttpMethod.PUT, "/api/empresas/**").hasRole("ADMIN")
            .requestMatchers(HttpMethod.DELETE, "/api/empresas/**").hasRole("ADMIN")
            .requestMatchers(HttpMethod.GET, "/api/servicos/**").hasAnyRole("USER", "ADMIN")
            .requestMatchers(HttpMethod.POST, "/api/servicos/**").hasRole("ADMIN")
            .requestMatchers(HttpMethod.PUT, "/api/servicos/**").hasRole("ADMIN")
            .requestMatchers(HttpMethod.DELETE, "/api/servicos/**").hasRole("ADMIN")

            // Exigir autenticação para qualquer outra requisição não configurada acima
            .anyRequest().authenticated())
        .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class);

    return httpSecurity.build();
  }

  @Bean
  public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
      throws Exception {
    return authenticationConfiguration.getAuthenticationManager();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
