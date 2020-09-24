package devoir1.springdev.security;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder passwordEncoder = passwordEncoder();
        System.out.println(passwordEncoder.encode("passer"));
        auth.inMemoryAuthentication().withUser("sarr").password(passwordEncoder.encode("passer")).roles("ADMIN");
        auth.inMemoryAuthentication().withUser("moussa").password(passwordEncoder.encode("passer")).roles("SUPERADMIN");
        auth.inMemoryAuthentication().withUser("seye").password(passwordEncoder.encode("passer")).roles("CAISSIER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().loginPage("/login");
        http.authorizeRequests().antMatchers("/login").permitAll();
        http.authorizeRequests().antMatchers("/dashboard/**","/caissiers/**","/comptes/**").hasRole("SUPERADMIN");
        http.authorizeRequests().antMatchers("/dashboard/**","/clients/**").hasRole("ADMIN");
        http.authorizeRequests().antMatchers("/dashboard/**","/commissions/**","/operations/**").hasRole("CAISSIER");
        //http.authorizeRequests().antMatchers("/resources/**/**/**").permitAll();
        http.exceptionHandling().accessDeniedPage("/notAuthorized");
        //http.authorizeRequests().anyRequest().authenticated();
        http.rememberMe().tokenValiditySeconds(2592000).key("mySecrete!");

    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
