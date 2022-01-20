package com.GyanDaan.confiig;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.GyanDaan.Service.Impl.UserDetailsServiceImpl;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;
	@Autowired
	private JwtUtil jwtutil; //using this class as it have all the methods that will check token 
	
	
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		 final String requestTokenHeader = request.getHeader("authorization");
		
		
		
		System.out.println(requestTokenHeader);
	    String username = null;
	    String jwtToken = null;
		
	    if(requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
	    	
	    	//token is valid
	    	 try {
				jwtToken = requestTokenHeader.substring(7);
				username= this.jwtutil.extractUsername(jwtToken);
				
				
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
	    	
	    	
	    }else {
	    	System.out.println("tttoken"+requestTokenHeader);
	    	System.out.println("Invalid token");
	    }
	    
	    //validate user
	    if(username !=null && SecurityContextHolder.getContext().getAuthentication()==null) {
	    	UserDetails userDetails = this.userDetailsServiceImpl.loadUserByUsername(username);
	    	if(this.jwtutil.validateToken(jwtToken, userDetails)) {
	    		//is valid token
	    		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
	    		
	    		usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
	    		SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
	    	}
	    }else {
	    	System.out.println("Invalid Token");
	    }
	    
	   
	    filterChain.doFilter(request, response);
	}
	
	
}
