package com.example.chatappbackend.security;
import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.example.chatappbackend.repos.BlackListRepo;
import com.example.chatappbackend.entities.BlackList;
public class JWTAuthenticationFilter extends OncePerRequestFilter{
    private JwtGenerator tokenGenerator;
    private final UserDetailsService customUserDetailsService;
    private final BlackListRepo blackListRepo;
    public JWTAuthenticationFilter(JwtGenerator generator,UserDetailsService customUserDetailsService,BlackListRepo repo){
        this.tokenGenerator=generator;
        this.customUserDetailsService=customUserDetailsService;
        this.blackListRepo=repo;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //System.out.println("Works");

        String token=getJWTFromRequest(request);
        
        //Burda token-i yoxlamaliyiq ki logout zamani qalan cache tokendi ya yox,ve butun vaxti kecmis tokenlari legv etmeliyik
        BlackList deprecatedToken=blackListRepo.findByCustomToken(token);
        /*if(deprecatedToken!=null){
            System.out.println("####  "+deprecatedToken.getCustomToken()+"  ####");
        }*/
        if(token!=null && tokenGenerator.validateToken(token) && deprecatedToken==null){//cunki deprecated token null olmasa token -i bilen istenilen client proqrami istifade ede biler
            String username=tokenGenerator.getUsernameFromJWT(token);
            UserDetails userDetails=customUserDetailsService.loadUserByUsername(username);
            UsernamePasswordAuthenticationToken authenticationToken=new UsernamePasswordAuthenticationToken(userDetails,null, userDetails.getAuthorities());
            authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }
        filterChain.doFilter(request, response);//essestially is the form of middleware
    }
    private String getJWTFromRequest(HttpServletRequest request){
        String bearerToken=request.getHeader("Authorization");
        if(bearerToken!=null && bearerToken.startsWith("Bearer ")){
            return bearerToken.substring(7,bearerToken.length());//"Bearer " ona gore de 7 ci elementden baslayaraq veirirk,token hissesini goturmesi ucun
        }
        return null;
    }
}
