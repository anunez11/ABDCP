package utilitario.request;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



public class RequestData {
	Integer page ;//= 1;
	Integer limit; //= 25;
	HashMap<String, Object> where = new HashMap<String, Object>();
	List<RequestOrderBy> orderBy = new ArrayList<>();
	
	public RequestData() {
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public HashMap<String, Object> getWhere() {
		return where;
	}

	public void setWhere(HashMap<String, Object> where) {
		this.where = where;
	}

	public List<RequestOrderBy> getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(List<RequestOrderBy> orderBy) {
		this.orderBy = orderBy;
	}
	
	public static class RequestDataBuilder {
		RequestData dataRequest;
		
		public RequestDataBuilder() {
			dataRequest = new RequestData();
		}
		
		public RequestDataBuilder setPage(Integer page) {
			dataRequest.setPage(page);
			return this;
		}
		
		public RequestDataBuilder setWhere(HashMap<String, Object> where) {
			dataRequest.setWhere(where);
			return this;
		}
		
		public RequestDataBuilder addWhere(String key, Object value) {
			dataRequest.getWhere().put(key, value);
			return this;
		}
		
		public RequestDataBuilder setOrderBy(List<RequestOrderBy> orderBy) {
			dataRequest.setOrderBy(orderBy);
			return this;
		}
		
		public RequestDataBuilder setLimit(Integer limit) {
			dataRequest.setLimit(limit);
			return this;
		}
		
		public RequestData build() {
			return dataRequest;
		}
		
	}
}
