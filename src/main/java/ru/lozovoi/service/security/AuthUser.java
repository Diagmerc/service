package ru.lozovoi.service.security;

import lombok.Getter;
import org.springframework.lang.NonNull;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import ru.lozovoi.service.domain.User;

import java.util.Collections;

public class AuthUser extends org.springframework.security.core.userdetails.User {
    @Getter
    @NonNull
    private final User user;

    public AuthUser(@NonNull User user) {
        super(user.getUsername(), user.getPassword(), Collections.singletonList(new SimpleGrantedAuthority(user.getRole())));
        this.user = user;
    }

    public long id() {
        return user.getId();
    }
}