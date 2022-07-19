package tech.thuexe.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import tech.thuexe.security.filter.CustomAuthenticationFilter;
import tech.thuexe.security.filter.CustomAuthorizationFilter;
import tech.thuexe.utility.Config;

import static org.springframework.http.HttpMethod.*;

@Configuration @EnableWebSecurity @RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserDetailsService userDetailsService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/admin");
        CustomAuthenticationFilter customAuthenticationFilter = new CustomAuthenticationFilter(authenticationManagerBean());
        customAuthenticationFilter.setFilterProcessesUrl("/login");
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeHttpRequests().antMatchers(GET, "/users").hasAnyAuthority(Config.ROLE.ADMIN.getValue());
//        http.authorizeHttpRequests().antMatchers(PUT, "/users/**").hasAnyAuthority(Config.ROLE.ADMIN.getValue());
        http.authorizeHttpRequests().antMatchers(GET,
                "/orders/**"
        ).hasAnyAuthority(Config.ROLE.USER.getValue());
        http.authorizeHttpRequests().antMatchers(POST,
                "/posts/**",
                "/orders/**",
                "/image"
        ).hasAnyAuthority(Config.ROLE.USER.getValue());
        http.authorizeHttpRequests().antMatchers(PUT,
                "/posts/**",
                "/orders/**"
        ).hasAnyAuthority(Config.ROLE.USER.getValue());
        http.authorizeHttpRequests().antMatchers(DELETE,
                "/posts/**"
        ).hasAnyAuthority(Config.ROLE.USER.getValue());
        http.authorizeHttpRequests().
                antMatchers("/**").permitAll();
        http.authorizeHttpRequests().anyRequest().authenticated();
        http.addFilter(customAuthenticationFilter);
        http.addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
        return source;
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws  Exception {
        return super.authenticationManagerBean();
    }
}
