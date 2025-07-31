package com.projeto.projetolistacompras.service;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UsuarioDetailsImpl implements UserDetails{
	
	
	
	     private String email;
	     private String nome;
         private String username;
         private String password;
         
         
         
         
         
         public UsuarioDetailsImpl(String email, String nome, String username, String password,
        		Collection<? extends GrantedAuthority> authorities) {
        	 
        	 
        	    super();
        	    this.email = email;
        	 
         }
}
