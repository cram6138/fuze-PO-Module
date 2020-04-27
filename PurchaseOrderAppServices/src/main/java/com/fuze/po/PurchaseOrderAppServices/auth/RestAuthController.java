package com.fuze.po.PurchaseOrderAppServices.auth;

import java.security.MessageDigest;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fuze.po.PurchaseOrderAppServices.entity.User;
import com.fuze.po.PurchaseOrderAppServices.entity.UserRole;
import com.fuze.po.PurchaseOrderAppServices.repository.UserRepository;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RestAuthController {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private MessageSource messageSource;
	
	@PostMapping("/login")
	public ResponseEntity<AuthenticationToken> authenticateUser(@RequestBody final UserCredential login,
			HttpSession session) {
		final AuthenticationToken authToken = new AuthenticationToken();
		User user = null;
		if (login.getUsername() == null || login.getPassword() == null) {
			throw new AuthenticationException();
		} else if ((user = authenticated(login)) == null) {
			throw new AuthenticationException();
		}
		if (!user.isActive()) {
			throw new AuthenticationException();
		}

		if (user.getUserRoles() == null) {
			throw new ForbiddenException();
		}
		populateAuthentionToken(authToken, user);
		return new ResponseEntity<AuthenticationToken>(authToken, HttpStatus.OK);
	}
	
	public void populateAuthentionToken(final AuthenticationToken authenticationToken, final User user) {
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
		return Date.from(
				LocalDateTime.now().plusSeconds(Integer.valueOf(lifeTime)).atZone(ZoneId.systemDefault()).toInstant());
	}

	private List<String> getUserRoles(Set<UserRole> userRoles) {
		final List<String> roles = new ArrayList<String>();
		Iterator<UserRole> it = userRoles.iterator();
		while (it.hasNext()) {
			roles.add(it.next().getRole());
		}
		return roles;
	}

	public UserInfo populateUserInfo(User user) {
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

	public User authenticated(UserCredential login) {
		String sha256 = sha56(login.getPassword());
		User user = userRepository.findByUsernameAndPassword(login.getUsername(), sha256);
		return user;
	}

	public static String sha56(String password) {
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
