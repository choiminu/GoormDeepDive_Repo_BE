package delivery.api.domain.user.controller;

import delivery.api.common.api.Api;
import delivery.api.domain.user.business.UserBusiness;
import delivery.api.domain.user.controller.model.UserRegisterRequest;
import delivery.api.domain.user.controller.model.UserResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/open-api/user")
public class UserOpenApiController {
    private final UserBusiness userBusiness;

    //http://localhost:8080/open-api/user/register
    @PostMapping("/register")
    public Api<UserResponse> register(@Valid @RequestBody Api<UserRegisterRequest> request) {
        UserResponse response = userBusiness.register(request.getBody());
        return Api.OK(response);
    }
}
