package org.vipcube.openfeign.wra.fhy.autoconfigure;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@EnableFeignClients( basePackages = {
		"org.vipcube.openfeign.wra.fhy"
})
@Configuration
public class WraFhyFeignAutoConfiguration {

}
