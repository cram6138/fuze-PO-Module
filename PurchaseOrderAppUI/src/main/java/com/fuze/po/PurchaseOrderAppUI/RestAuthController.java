package com.fuze.po.PurchaseOrderAppUI;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fuze.po.PurchaseOrderAppUI.auth.AuthenticationController;
import com.fuze.po.PurchaseOrderAppUI.auth.AuthenticationException;
import com.fuze.po.PurchaseOrderAppUI.auth.AuthenticationToken;
import com.fuze.po.PurchaseOrderAppUI.auth.ForbiddenException;
import com.fuze.po.PurchaseOrderAppUI.auth.User;
import com.fuze.po.PurchaseOrderAppUI.auth.UserCredential;
import com.fuze.po.PurchaseOrderAppUI.auth.UserInfo;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RestAuthController {
	
	@Autowired
	private ServletContext servletContext;
	
	@Autowired
	private AuthenticationController authController;
	
	@PostMapping("/ang/login")
	public ResponseEntity<AuthenticationToken> authenticateUser(@RequestBody final UserCredential login,
			HttpSession session) {
		final AuthenticationToken authToken = new AuthenticationToken();
		User user = null;
		if (login.getUsername() == null || login.getPassword() == null) {
			throw new AuthenticationException();
		} else if ((user = authController.authenticated(login)) == null) {
			throw new AuthenticationException();
		}
		if (!user.isActive()) {
			//authToken.setMessage("User is inactive");
			throw new AuthenticationException();
		}

		if (user.getUserRoles() == null) {
			throw new ForbiddenException();
		}
		authController.populateAuthentionToken(authToken, user);
		UserInfo userInfo = authController.populateUserInfo(user);
		session.setAttribute("currentUserInfo", userInfo);
		authToken.setSessionId(session.getId());
		servletContext.setAttribute(session.getId(), session);
		System.out.println(servletContext.getAttribute(session.getId()));
		return new ResponseEntity<AuthenticationToken>(authToken, HttpStatus.OK);
	}

}
