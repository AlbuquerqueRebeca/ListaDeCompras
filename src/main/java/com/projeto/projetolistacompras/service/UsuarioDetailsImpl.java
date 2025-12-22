package com.projeto.projetolistacompras.service;


import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.projeto.projetolistacompras.Entidade.Usuario;

public class UsuarioDetailsImpl implements UserDetails{
	
	
	
	     private String email;
	     private String nome;
         private String username;
         private String password;
         
         
         
         
         
         public UsuarioDetailsImpl(String email, String nome, String password,
        		Collection<? extends GrantedAuthority> authorities) {
        	 
        	 
        	    super();
        	    this.email = email;
        	    this.nome = nome;
        	    this.password = password;
        	    this.authorities = authorities;
        	 
         }
         
         public static UsuarioDetailsImpl build(Usuario usuario) {
        	  

        	           return  new UsuarioDetailsImpl(
        	        		   usuario.getEmail(),
        	        		   usuario.getNome(),
        	        		   usuario.getSenha(),
        	        		   List.of()
                    );        
        	 
         }
         
         private Collection<? extends GrantedAuthority> authorities;
         
                           
         @Override
         public Collection<? extends GrantedAuthority> getAuthorities(){
        	       
        	             return authorities;
         } 
         
         @Override
         public String getPassword() {
        	      
        	      return password;
         }
         
         @Override
         public String getUsername() {
        	  
        	     return email;
         }
         
         @Override
         public boolean isAccountNonExpired() {
        	       
        	       return true;
         }
         
         @Override
         public boolean isAccountNonLocked() {
        	          
        	        return true;
         }
         
         @Override
         public boolean isCredentialsNonExpired() {
        	 return true;
         }
         
         @Override
         public boolean isEnabled() {
        	       
        	       return true;
         }
         
         public String getEmail() {
             return email;
         }
         
         public String getNome() {
             return nome;
         }
         
}
