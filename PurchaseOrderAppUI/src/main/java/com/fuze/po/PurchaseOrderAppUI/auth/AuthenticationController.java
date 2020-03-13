package com.fuze.po.PurchaseOrderAppUI.auth;

import java.security.MessageDigest;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Controller
@CrossOrigin
@RequestMapping(produces = {"application/json"})
public class AuthenticationController {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private MessageSource messageSource;
	
	@PostMapping("/login")
	public String getToken(@ModelAttribute("loginForm") UserCredential login, HttpServletRequest request) {
		
		final AuthenticationToken authenticationToken = new AuthenticationToken();
		User user = null;
		if(login.getUsername() == null || login.getPassword() == null) {
			return "redirect:/*";
			//throw new InvalidRequestException();
		} else if ((user = authenticated(login)) == null) {
			return "redirect:/*";
			//throw new AuthenticationException();
		}
		
		if(!user.isActive()) {
			authenticationToken.setMessage("User is inactive");
			//return authenticationToken;
			return "redirect:/*";
		}
		
		if(user.getUserRoles() == null) {
			throw new ForbiddenException();
		}
		
		this.populateAuthentionToken(authenticationToken, user);
		request.getSession(true).setAttribute("currentUserInfo", user);
		//return authenticationToken;
		return "redirect:/index";
	}

	private void populateAuthentionToken(final AuthenticationToken authenticationToken, final User user) {
		final List<String> roles = getUserRoles(user.getUserRoles());
		final UserInfo userInfo = populateUserInfo(user);
		final String accessToken = Jwts.builder().setSubject(user.getUsername()).setIssuedAt(new Date())
				.setExpiration(getExpirationDate()).claim("id", user.getId()).claim("username", user.getUsername())
				.claim("roles", roles).signWith(SignatureAlgorithm.HS256, "secretKey").compact();
		authenticationToken.setAccessToken(accessToken);
		authenticationToken.setUserInfo(userInfo);
	}
	
	private Date getExpirationDate() {
		String lifeTime = String.valueOf(messageSource.getMessage("token.expire.time", null, null));
		return Date.from(LocalDateTime.now().plusSeconds(Integer.valueOf(lifeTime)).atZone(ZoneId.systemDefault()).toInstant());
	}
	
	private List<String> getUserRoles(Set<UserRole> userRoles) {
		final List<String> roles = new ArrayList<String>();
		Iterator<UserRole> it = userRoles.iterator();
		while (it.hasNext()) {
			roles.add(it.next().getRole());
		}
		return roles;
	}

	private UserInfo populateUserInfo(User user) {
		UserInfo userInfo = new UserInfo();
		userInfo.setId(user.getId());
		userInfo.setFirstName(user.getFirstName());
		userInfo.setLastName(user.getLastName());
		userInfo.setUsername(user.getUsername());
		userInfo.setActive(user.isActive());
		userInfo.setTerritory(user.getTerritory());
		userInfo.setMarket(user.getMarket());
		userInfo.setCreatedOn(user.getCreatedOn());
		List<String> userRoles = getUserRoles(user.getUserRoles());
		userInfo.setUserRole(userRoles);
		return userInfo;
	}

	private User authenticated(UserCredential login) {
		String sha256 = AuthenticationController.sha56(login.getPassword());
		User user = userRepository.findByUsernameAndPassword(login.getUsername(), sha256);
		return user;
	}

	private static String sha56(String password) {
		byte[] sha256;
		try {
			sha256 = MessageDigest.getInstance("SHA-256").digest(password.getBytes("UTF-8"));
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < sha256.length; i++) {
				sb.append(Integer.toString((sha256[i] & 0xff) + 0x100, 16).substring(1));
			}
			return sb.toString();
		} catch (Exception e) {

		}
		return null;
	}
}
