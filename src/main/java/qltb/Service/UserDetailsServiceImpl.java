package qltb.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import qltb.Configuration.MyUserDetails;
import qltb.Model.User;
import qltb.Repository.UserRepository;
 
public class UserDetailsServiceImpl implements UserDetailsService {
 
    @Autowired
    private UserRepository userRepository;
     
    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
    	User user = userRepository.getUserByUsername(username);
    	if(user == null) {
    		user = new User();
    		user.setPassword("");
    	}
        return new MyUserDetails(user);
    }
 
}
