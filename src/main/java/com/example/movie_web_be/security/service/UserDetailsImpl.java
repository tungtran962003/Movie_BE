package com.example.movie_web_be.security.service;

import com.example.movie_web_be.entity.Account;
import com.example.movie_web_be.entity.RankCustomer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailsImpl implements UserDetails {

    private Integer id;

    private String name;

    private String email;

    private String password;

    private Date birthDay;

    private Date createDate;

    private Date updateDate;

    private String phoneNumber;

    private String avatar;

    private Boolean isActive;

    private RankCustomer rankCustomer;

    private AccountStatus accountStatus;

    private Collection<? extends GrantedAuthority> roles;

    public static UserDetailsImpl build(Account account) {
        GrantedAuthority role = new SimpleGrantedAuthority(account.getRole().getName());
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(role);
        return new UserDetailsImpl(
                account.getId(),
                account.getName(),
                account.getEmail(),
                account.getPassword(),
                account.getBirthDay(),
                account.getCreateDate(),
                account.getUpdateDate(),
                account.getPhoneNumber(),
                account.getAvatar(),
                account.getIsActive(),
                account.getRankCustomer(),
                account.getAccountStatus(),
                authorities
        );
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
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
}
