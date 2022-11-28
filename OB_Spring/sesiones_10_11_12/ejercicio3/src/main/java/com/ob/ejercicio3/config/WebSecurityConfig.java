//package com.ob.ejercicio3.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//        http.authorizeRequests()
//                .antMatchers("/hello").permitAll()
//                .antMatchers("/data").hasRole("ADMIN")
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .and()
//                .httpBasic();
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .passwordEncoder(new BCryptPasswordEncoder())
//                .withUser("user").password(passwordEncoder().encode("password")).roles("USER")
//                .and()
//                .withUser("admin").password(passwordEncoder().encode("password")).roles("USER", "ADMIN");
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    @Override
//    public UserDetailsService userDetailsServiceBean() throws Exception {
//        return super.userDetailsServiceBean();
//    }
//
//    @EnableWebSecurity
//    @EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
//    public class WebSecurityConfig {
//        @Bean
//        public UserDetailsService userDetailsService(BCryptPasswordEncoder bCryptPasswordEncoder) {
//            InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//            manager.createUser(User.withUsername("user")
//                    .password(bCryptPasswordEncoder.encode("userPass"))
//                    .roles("USER")
//                    .build());
//            manager.createUser(User.withUsername("admin")
//                    .password(bCryptPasswordEncoder.encode("adminPass"))
//                    .roles("USER", "ADMIN")
//                    .build());
//            return manager;
//        }
//
//        @Bean
//        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//            http.csrf()
//                    .disable()
//                    .authorizeRequests()
//                    .antMatchers(HttpMethod.DELETE)
//                    .hasRole("ADMIN")
//                    .antMatchers("/admin/**")
//                    .hasAnyRole("ADMIN")
//                    .antMatchers("/user/**")
//                    .hasAnyRole("USER", "ADMIN")
//                    .antMatchers("/login/**")
//                    .anonymous()
//                    .anyRequest()
//                    .authenticated()
//                    .and()
//                    .httpBasic()
//                    .and()
//                    .sessionManagement()
//                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//
//            return http.build();
//        }
//    }
//}
//
