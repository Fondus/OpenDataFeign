package tw.fondus.openfeign.wra.fhy.autoconfigure;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@EnableFeignClients( basePackages = {
		"tw.fondus.openfeign.wra.fhy"
})
@Configuration
public class WraFhyFeignAutoConfiguration {

}
