package bg.softuni.mobilele.services.role;


import bg.softuni.mobilele.domain.dtos.view.UserRoleViewDto;
import bg.softuni.mobilele.services.init.DataBaseInitService;

import java.util.List;

public interface UserRoleService extends DataBaseInitService {

    public void dbInit();
    public boolean isDbInit();
    public List<UserRoleViewDto> getAll();
}