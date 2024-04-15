package dev.petproject.twitter.security.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/demo")
public class DemoController {

  public static final String DEFAULT_MESSAGE = "This is protected resource";

  @GetMapping("/just-auth")
  public String hitJustAuthEndpoint() {
    return DEFAULT_MESSAGE;
  }

  @GetMapping("/just-role-user")
  public String hitJustRoleUserEndpoint() {
    return DEFAULT_MESSAGE;
  }

  @GetMapping("/just-role-admin")
  public String hitJustRoleAdminEndpoint() {
    return DEFAULT_MESSAGE;
  }
}
