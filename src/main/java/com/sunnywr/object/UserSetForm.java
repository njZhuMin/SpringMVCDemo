package com.sunnywr.object;

import com.google.common.base.MoreObjects;

import java.util.LinkedHashSet;
import java.util.Set;

public class UserSetForm {
    private Set<User> users;

    public UserSetForm() {
        users = new LinkedHashSet<User>();
        users.add(new User());
        users.add(new User());
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("users", users)
                .toString();
    }
}
