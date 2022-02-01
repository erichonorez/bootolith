package io.h5z.bootolith.components.auth.adapter.primary.security;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import io.h5z.bootolith.components.auth.domain.Role;
import io.h5z.bootolith.components.auth.domain.Credential;
import io.h5z.bootolith.components.auth.domain.CredentialRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private CredentialRepository userRepository;
	
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
	
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<Credential> optionalUser = userRepository.findByUsername(userName);
        if(optionalUser.isPresent()) {
        	Credential users = optionalUser.get();
        	
        	List<String> roleList = new ArrayList<String>();
        	for(Role role:users.getRoles()) {
        		roleList.add(role.getRoleName());
        	}
        	
			return User.builder()
            	.username(users.getUsername())
            	.password(bCryptPasswordEncoder.encode(users.getPassword()) )
            	.disabled(users.isDisabled())
            	.accountExpired(users.isAccountExpired())
            	.accountLocked(users.isAccountLocked())
            	.credentialsExpired(users.isCredentialsExpired())
            	.roles(roleList.toArray(new String[0]))
            	.build();
        } else {
        	throw new UsernameNotFoundException("User Name is not Found");
        }   
    }
}
