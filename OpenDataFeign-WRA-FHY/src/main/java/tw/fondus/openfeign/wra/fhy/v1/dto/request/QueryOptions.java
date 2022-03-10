package tw.fondus.openfeign.wra.fhy.v1.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class QueryOptions {
	private String filter;
	private String select;
	private String orderBy;
	private Integer top;
	private Integer skip;
}
