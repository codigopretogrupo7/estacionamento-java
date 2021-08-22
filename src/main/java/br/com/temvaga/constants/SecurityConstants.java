package br.com.temvaga.constants;

public class SecurityConstants {
    public static final String[] SIGN_UP_URL = {"/api/usuarios/add","/api/estacionamentos/login","/api/vagas/insertveiculo**","/api/vagas/checkout**"};
    public static final String[] URLS = {
            "/api/usuarios/list/name**",
            "/api/estacionamentos/list**",
            "/api/estacionamentos/list/id**",
            "/api/vagas/listvaga**",
            "/api/vagas/listid**",
            "/api/vagas/vagaslivres**"
    };
    public static final String[] AUTH_LIST = {
            // -- swagger ui
            "**/swagger-resources/**",
            "/swagger-ui.html",
            "/webjars/**",
            "/api/**"

    };
    public static final String KEY = "q3t6w9z$C&F)J@NcQfTjWnZr4u7x!A%D*G-KaPdSgUkXp2s5v8y/B?E(H+MbQeTh";
    public static final String HEADER_NAME = "Authorization";
    public static final Long EXPIRATION_TIME =  1000L * 60 * 60 * 24;
}
