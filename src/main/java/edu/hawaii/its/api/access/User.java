package edu.hawaii.its.api.access;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;

public class User extends org.springframework.security.core.userdetails.User {

    public static final long serialVersionUID = 2L;
    private Long uhuuid;
    private UhAttributes attributes;

    // Constructor.
    public User(String username, Long uhuuid, Collection<GrantedAuthority> authorities) {
        super(username, "", authorities);
        setUhuuid(uhuuid);
    }

    // Constructor.
    public User(String username, Collection<GrantedAuthority> authorities) {
        this(username, null, authorities);
    }

    public String getUid() {
        return getUsername();
    }

    public Long getUhuuid() {
        return uhuuid;
    }

    public void setUhuuid(Long uhuuid) {
        this.uhuuid = uhuuid;
    }

    public String getAttribute(String name) {
        return attributes.getValue(name);
    }

    public UhAttributes getAttributes() {
        return attributes;
    }

    public void setAttributes(UhAttributes attributes) {
        this.attributes = attributes;
    }

    public String getName() {
        return attributes.getValue("cn");
    }

    public boolean hasRole(Role role) {
        return getAuthorities().contains(new SimpleGrantedAuthority(role.longName()));
    }

    public String toString() {
        return "User [uid=" + getUid()
                + ", uhuuid=" + getUhuuid()
                + ", super-class: " + super.toString() + "]";
    }
}
