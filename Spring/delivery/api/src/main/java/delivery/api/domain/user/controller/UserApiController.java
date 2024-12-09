package delivery.api.domain.user.controller;

import delivery.api.common.annotation.UserSession;
import delivery.api.common.api.Api;
import delivery.api.domain.user.business.UserBusiness;
import delivery.api.domain.user.controller.model.UserResponse;
import delivery.api.domain.user.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserApiController {

    private final UserBusiness userBusiness;

    //http://localhost:8080/api/user/me
    @GetMapping("/me")
    public Api<UserResponse> me(@UserSession User user) {
        UserResponse response = userBusiness.me(user.getId());
        return Api.OK(response);
    }
}
