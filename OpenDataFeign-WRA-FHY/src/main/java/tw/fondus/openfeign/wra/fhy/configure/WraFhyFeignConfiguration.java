package tw.fondus.openfeign.wra.fhy.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tw.fondus.openfeign.wra.fhy.v1.dto.request.QueryOptionsEncoder;

@Configuration
public class WraFhyFeignConfiguration {
	@Bean
	public QueryOptionsEncoder queryOptionsEncoder(){
		return new QueryOptionsEncoder();
	}
}
