package com.lolsearcher.user;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Email;

import static com.lolsearcher.user.UserConstant.EMAIL_REGEX;

@Validated
@RequiredArgsConstructor
@RequestMapping("/user")
@RestController
public class UserController {

	private final UserService userService;

	@PostMapping
	public UserDto create(@RequestBody @Valid UserCreateRequest request) {

		return userService.join(request);
	}

	@GetMapping
	public UserFindResponse isExistedByEmail(@RequestParam @Email(regexp = EMAIL_REGEX) String email) {

		return new UserFindResponse(userService.findByEmail(email));
	}

	@PatchMapping("/{id}")
	public ResponseSuccessDto updateName(
			@PathVariable Long id,
			@RequestBody @Valid UserUpdateRequest request
	) {
		userService.updatePartial(id, request);

		return new ResponseSuccessDto("user data update successfully");
	}

	@DeleteMapping("/{id}")
	public ResponseSuccessDto delete(@PathVariable @Valid Long id) {

		userService.delete(id);

		return new ResponseSuccessDto(String.format("userId : %s delete successfully", id));
	}
}
