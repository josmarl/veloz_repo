package pe.com.veloz;

import java.io.IOException;
import java.security.Principal;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.veloz.constants.Roles;
import pe.com.veloz.domain.Usuario;
import pe.com.veloz.service.UsuarioService;

@SpringBootApplication
@RestController
public class SmsApplication extends SpringBootServletInitializer {

    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    private HttpServletRequest request;

    @Autowired
    UsuarioService usuarioService;

    @RequestMapping("/user")
    public Principal user(Principal user) {
        return user;
    }

    @RequestMapping("/resource")
    public Map<String, Object> home() {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("id", UUID.randomUUID().toString());
        model.put("content", "Hello World");
        return model;
    }

    public static void main(String[] args) throws IOException {
        SpringApplication.run(SmsApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SmsApplication.class);
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticationMgr) throws Exception {
        authenticationMgr.authenticationProvider(new AuthenticationProvider() {
            @Override
            public Authentication authenticate(Authentication a) throws AuthenticationException {

                String username = a.getName();
                String password = (String) a.getCredentials();

                Usuario usuario = usuarioService.validateUsuario(username, password);

                if (usuario == null) {
                    throw new BadCredentialsException("Username not found.");
                }

                if (!password.equals(usuario.getPassword())) {
                    throw new BadCredentialsException("Wrong password.");
                }

                Collection<? extends GrantedAuthority> authorities = usuario.getAuthorities();

                for (GrantedAuthority authority : authorities) {
                    logger.info("josmarl " + authority.getAuthority());
                }

                request.getSession().setAttribute("userDetails", usuarioService.findUsuarioByUsername(username));

                return new UsernamePasswordAuthenticationToken(username, password, authorities);
            }

            @Override
            public boolean supports(Class<?> type) {
                return true;
            }
        });

    }

    @Configurable
    @EnableWebSecurity
    protected static class SecurityConfiguration extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            // @formatter:off
            http
                    .httpBasic().and()
                    .authorizeRequests()
                    .antMatchers("/index.html", "/login.html", "/", "/bower_components/**", "/css/**", "/js/**", "/img/**").permitAll()
                    .antMatchers("/producto/**").hasAnyRole(Roles.USER.getRoleSubString(), Roles.ADMIN.getRoleSubString())
                    .antMatchers("/usuario/**").hasAnyRole(Roles.ADMIN.getRoleSubString())
                    .antMatchers("/venta/**").hasAnyRole(Roles.USER.getRoleSubString(), Roles.ADMIN.getRoleSubString())
                    .antMatchers("/cliente/**").hasAnyRole(Roles.USER.getRoleSubString(), Roles.ADMIN.getRoleSubString())
                    .antMatchers("/almacen/**").hasAnyRole(Roles.USER.getRoleSubString(), Roles.ADMIN.getRoleSubString())
                    .antMatchers("/reportes/**").hasAnyRole(Roles.ADMIN.getRoleSubString())
                    .antMatchers("/app/**").hasAnyRole(Roles.USER.getRoleSubString(), Roles.ADMIN.getRoleSubString())
                    //.antMatchers("/app/**").permitAll()
                    //.anyRequest().fullyAuthenticated().and().formLogin().loginPage("/login.html")
                    .and()
                    .csrf()
                    .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()).disable();
            // @formatter:on
        }
    }

}
