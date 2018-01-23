package delicacies.service;

import java.util.ArrayList;
import java.util.List;

import delicacies.dao.management.DelicaciesUserDAO;
import delicacies.entity.management.DelicaciesUserEntity;
import delicacies.dao.management.DelicaciesRoleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
 
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
 
    @Autowired
    private DelicaciesUserDAO delicaciesUserDAO;
 
    @Autowired
    private DelicaciesRoleDAO delicaciesRoleDAO;
 
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
    	DelicaciesUserEntity delicaciesUserEntity = this.delicaciesUserDAO.findUserAccount(userName);
 
        if (delicaciesUserEntity == null) {
            System.out.println("User not found! " + userName);
            throw new UsernameNotFoundException("User " + userName + " was not found in the database");
        }
 
        System.out.println("Found User: " + delicaciesUserEntity);
 
        // [ROLE_USER, ROLE_ADMIN,..]
        List<String> roleNames = this.delicaciesRoleDAO.getRoleCodes(delicaciesUserEntity.getUserId());
 
        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        if (roleNames != null) {
            for (String role : roleNames) {
                // ROLE_USER, ROLE_ADMIN,..
                GrantedAuthority authority = new SimpleGrantedAuthority(role);
                grantList.add(authority);
            }
        }
 
        UserDetails userDetails = (UserDetails) new User(delicaciesUserEntity.getUserName(), //
        		delicaciesUserEntity.getEncrytedPassword(), grantList);
 
        return userDetails;
    }
 
}