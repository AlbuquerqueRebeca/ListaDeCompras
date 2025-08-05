package com.projeto.projetolistacompras.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.projeto.projetolistacompras.Entidade.Usuario;

public class UsuarioDetailsImpl implements UserDetails{
	
	
	
	     private String email;
	     private String nome;
         private String username;
         private String password;
         
         
         
         
         
         public UsuarioDetailsImpl(String email, String nome, String username, String password,
        		Collection<? extends GrantedAuthority> authorities) {
        	 
        	 
        	    super();
        	    this.email = email;
        	    this.nome = nome;
        	    this.username = username;
        	    this.password = password;
        	    this.authorities = authorities;
        	 
         }
         
         public static UsuarioDetailsImpl build(Usuario usuario) {
        	      
        	           return  new UsuarioDetailsImpl(usuario.getEmail(),
        	        		   usuario.getNome(),
        	        		   usuario.getlogin(),
        	        		   usuario.getSenha(),
        	        		   new ArrayList<>();
        	 
         }
         
         private Collection<? extends GrantedAuthority> authorities;
         
                           
         @Override
         public Collection<? extends GrantedAuthority> getAuthorities(){
        	       
        	             return authories;
         } 
         
         @Override
         public String getPassword() {
        	      
        	      return password;
         }
         
         @Override
         public String getUsername() {
        	  
        	     return username;
         }
         
         @Override
         public boolean isAccountNonExpired() {
        	       
        	       return true;
         }
         
         @Override
         
}
