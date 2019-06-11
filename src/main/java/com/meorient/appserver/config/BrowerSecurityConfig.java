//package com.meorient.appserver.config;
//
//import java.io.IOException;
//import java.util.List;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.authentication.AuthenticationFailureHandler;
//import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
//
//import com.meorient.appserver.mapper.UserMapper;
//import com.meorient.appserver.pojo.User;
//
//@Configuration
//public class BrowerSecurityConfig extends WebSecurityConfigurerAdapter {
//	
//	@Autowired
//	private UserMapper userMapper;
//	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//	     http.authorizeRequests()
//         .antMatchers("/customers").hasAnyRole("USER", "ADMIN")
//         .antMatchers("/contacts").hasAnyRole("USER", "ADMIN")
//         .anyRequest().authenticated()
//         .and()
//         .formLogin()
//         .loginPage("/login")
//         .successHandler(new AuthenticationSuccessHandler() {
//             @Override
//             public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication arg2)
//                     throws IOException, ServletException {
//                 Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//                 if (principal != null && principal instanceof UserDetails) {
//                     UserDetails user = (UserDetails) principal;
//                     System.out.println("loginUser:"+user.getUsername());
//                     response.addHeader("token", user.toString());
//                 }
//             }
//         })
//         //失败处理
//         .failureHandler(new AuthenticationFailureHandler() {
//             @Override
//             public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException authenticationException)
//                     throws IOException, ServletException {
//                 System.out.println("error："+authenticationException.getMessage());
//                 response.sendRedirect("/login");
//             }
//         })
//         .permitAll()
//         .and()
//         .logout()
//         .permitAll()  //注销行为任意访问
//         .and()
//         .csrf().disable();  //暂时禁用CSRF，否则无法提交表单
//	}
//	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////		List<User> userList = userMapper.selectUsers();
////		for(User u : userList) {
//			auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("dd").password(new BCryptPasswordEncoder().encode("qwe123")).roles("USER");
////		}
//	}
//}
