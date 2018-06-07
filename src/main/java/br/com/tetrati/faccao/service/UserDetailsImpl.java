package br.com.tetrati.faccao.service;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.tetrati.faccao.model.User;

public class UserDetailsImpl implements UserDetails
{
	private static final long serialVersionUID = -3731025248884122007L;
	
	private User user;
	
	public UserDetailsImpl(User user) 
	{
		super();
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() 
	{
		return this.user.getRoles()
				.stream()
				.map(role -> new SimpleGrantedAuthority(role.toString()))
				.collect(Collectors.toList());
	}

	@Override
	public String getPassword() 
	{
		return this.user.getPassword();
	}

	@Override
	public String getUsername() 
	{
		return this.user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() 
	{
		return true;
	}

	@Override
	public boolean isAccountNonLocked() 
	{
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() 
	{
		return true;
	}

	@Override
	public boolean isEnabled() 
	{
		return this.user.isEnabled();
	}

}
