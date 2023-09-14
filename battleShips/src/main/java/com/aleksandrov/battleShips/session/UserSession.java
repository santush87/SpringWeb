package com.aleksandrov.battleShips.session;

import com.aleksandrov.battleShips.models.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
@Getter
@Setter
@NoArgsConstructor
public class UserSession {
    private Long id;
    private String fullName;

    public void login(User user){
        this.id = user.getId();
        this.fullName = user.getFullName();
    }

    public void logout(){
        this.id = null;
        this.fullName = null;
    }
}
