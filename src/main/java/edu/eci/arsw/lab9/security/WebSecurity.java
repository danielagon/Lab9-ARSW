/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.lab9.security;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.context.annotation.Bean;

import static edu.eci.arsw.lab9.security.SecurityConstants.SIGN_UP_URL;
import edu.eci.arsw.lab9.services.UserDetailsServiceImpl;

/**
 *
 * @author danielagonzalez
 */
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter{
    
    private UserDetailsServiceImpl userDetailsService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public WebSecurity(UserDetailsServiceImpl userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userDetailsService = userDetailsService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable().authorizeRequests()
                .antMatchers(HttpMethod.POST, SIGN_UP_URL).permitAll()
                .antMatchers(HttpMethod.POST, "/request").permitAll()
                .antMatchers(HttpMethod.GET, "/").permitAll()
                .antMatchers(HttpMethod.GET, "/request").permitAll()
                .antMatchers(HttpMethod.GET, "/index.html").permitAll()
                .antMatchers(HttpMethod.GET, "/js/ChainController.js").permitAll()
                .antMatchers(HttpMethod.GET, "/js/ChainRestController.js").permitAll()
                .antMatchers(HttpMethod.GET, "/js/bootstrap.css").permitAll()
                .antMatchers(HttpMethod.GET, "/js/bootstrap.js").permitAll()
                .antMatchers(HttpMethod.GET, "/js/cover.css").permitAll()
                .antMatchers(HttpMethod.GET, "/js/jquery-3.2.1.js").permitAll()
                .antMatchers(HttpMethod.GET, "/js/popper.js").permitAll()
                .antMatchers(HttpMethod.GET, "/js/signin.css").permitAll()
                .antMatchers(HttpMethod.GET, "/registerChain.html").permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilter(new JWTAuthenticationFilter(authenticationManager()))
                .addFilter(new JWTAuthorizationFilter(authenticationManager()))
                // this disables session creation on Spring Security
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }

  @Bean
  CorsConfigurationSource corsConfigurationSource() {
    final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
    return source;
  }
}
