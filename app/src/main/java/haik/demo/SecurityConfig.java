package haik.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    // =====  SECURITY CONFIG  ============

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.headers().frameOptions().disable();
        http
                .authorizeRequests()
<<<<<<< HEAD
                .antMatchers("/", "/profile", "/welcome", "/signup").permitAll()
                .antMatchers("/admin").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll();
=======
                        .antMatchers("/", "/index", "/welcome","/signup","/user/**").permitAll()
                        .antMatchers("/admin").hasRole("ADMIN")
                        .anyRequest().authenticated()
                        .and()
                        .formLogin()
                        .loginPage("/login")
                        .permitAll();
>>>>>>> 1fe87a4238b721d1f13a3d914d31339d62db21cc

    }

}
