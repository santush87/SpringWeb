package bg.softuni.mobilele.services.init;

import org.springframework.stereotype.Service;

@Service
public class DataBaseInitServiceImpl implements DataBaseInitService {

    @Override
    public void dbInit() {

    }

    @Override
    public boolean isDbInit() {
        return true;
    }
}
