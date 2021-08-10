package mz.ac.ujc.esa.boot.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    // AUTENTICACAO
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
        .usersByUsernameQuery("select username,password,enabled from users where username=?")
		.authoritiesByUsernameQuery("select username,authority from authorities where username=?");

    }

    // AUTORIZACAO
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // http.authorizeRequests()
        
        //         .antMatchers("/cargos/listar").permitAll()
        //         .antMatchers("/admin").hasRole("ADMIN")
        //         .antMatchers("/home").hasAnyRole("ADMIN", "USER")
        //         .antMatchers("/cargos/listar").hasRole("ADMIN")
        //         .antMatchers("/gestor").hasRole("GESTOR")
        //         .and()
        //         .formLogin();

        http.csrf()
        .disable().
        authorizeRequests()
            // .antMatchers("/admin/pages/**").permitAll() 
		.antMatchers("/welcome").permitAll()
		
		.antMatchers("/admin").hasRole("ADMIN")
		.antMatchers("http://localhost:8080/cargos/**").hasAuthority("ADMIN")
		.antMatchers("/gestor").hasRole("USER")
		.antMatchers("/home").hasAnyRole("USER")
        .antMatchers("/pages/**").permitAll()
        
		
		// Any other URLs which are not configured in above antMatchers
		// generally declared aunthenticated() in real time
		.anyRequest().permitAll()
		
		//Login Form Details
		.and()
		.formLogin()
		// .defaultSuccessUrl("/welcome", true)
		
		//Logout Form Details
		.and()
		.logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				
		//Exception Details		
		.and()	
		.exceptionHandling()
		.accessDeniedPage("/accessDenied")
        
		;


    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

}
