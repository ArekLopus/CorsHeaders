package cors.enums;

public enum HttpMethods {
	
	GET("GET"),
	HEAD("HEAD"),
	POST("POST"),
	PUT("PUT"),
	DELETE("DELETE"),
	CONNECT("CONNECT"),
	OPTIONS("OPTIONS"),
	TRACE("TRACE"),
	PATCH("PATCH");	
	
	public final static String ALL_METHODS = "GET,HEAD,POST,PUT,DELETE,CONNECT,OPTIONS,TRACE,PATCH";
	
	private String name = "None";
	
	private HttpMethods(String name) {
		this.name = name;
	}
	

	public String getName() {
		return this.name;
	}
}
