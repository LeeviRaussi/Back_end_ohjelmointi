package backend2026.musiikkikokoelma.web;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import backend2026.musiikkikokoelma.domain.AppUser;
import backend2026.musiikkikokoelma.domain.AppUserRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService{

    private final AppUserRepository appUserRepository;

    public UserDetailServiceImpl(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser currUser = appUserRepository.findByUsername(username);
        UserDetails user = new User(username, currUser.getPasswordHash(), AuthorityUtils.createAuthorityList(currUser.getRole()));
        return user;
    }

}
