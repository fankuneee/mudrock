package infrastructure.security;

import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.annotation.web.configurers.SessionManagementConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

/**
 * ClassName: DefaultSecurityConfig.
 * Description:
 * date: 2023/9/22 13:22
 *
 * @author huzhenghui
 */
@EnableWebSecurity
public class DefaultSecurityConfig {


    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

        http
            .csrf(new Customizer<CsrfConfigurer<HttpSecurity>>() {
                @Override
                public void customize(CsrfConfigurer<HttpSecurity> httpSecurityCsrfConfigurer) {
                    // 关闭csrf 跨域
                    httpSecurityCsrfConfigurer.disable();
                }
            })
            .sessionManagement(new Customizer<SessionManagementConfigurer<HttpSecurity>>()  {
                @Override
                public void customize(SessionManagementConfigurer<HttpSecurity> httpSecuritySessionManagementConfigurer) {
                    // 使用session
                    httpSecuritySessionManagementConfigurer.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED);
                    // 限制同一账号只能一个用户使用
                    httpSecuritySessionManagementConfigurer.maximumSessions(1);
                    // 设置 TOKEN 过期响应
                    httpSecuritySessionManagementConfigurer.sessionConcurrency(
                            new Customizer<SessionManagementConfigurer<HttpSecurity>.ConcurrencyControlConfigurer>() {
                        @Override
                        public void customize(SessionManagementConfigurer<HttpSecurity>.ConcurrencyControlConfigurer concurrencyControlConfigurer) {
                            concurrencyControlConfigurer.expiredSessionStrategy(new TokenInformationExpiredStrategy());
                        }
                    });

                }
            });

        return http.build();
    }


}
