package api.kitabu.ui;


import api.kitabu.entity.ProfileEntity;
import api.kitabu.enums.ProfileRole;

public class MenuUi {
    AdminUI adminUi = new AdminUI();
    UserUI userUi = new UserUI();
    public void checkUser(ProfileEntity profile) {
        if (profile.getRole().equals(ProfileRole.ADMIN)){
            adminUi.start(profile);
        }else {
            userUi.start(profile);
        }
    }
}
