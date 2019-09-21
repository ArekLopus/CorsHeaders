package cors.servlet;

import cors.enums.HttpHeaders;
import cors.enums.HttpMethods;

public class CorsUtils {
	
	public static final String ALLOW_ORIGIN = "Access-Control-Allow-Origin";
	public static final String ALLOW_METHODS = "Access-Control-Allow-Methods";
	public static final String ALLOW_HEDAERS = "Access-Control-Allow-Headers";
	public static final String EXPOSE_HEADERS = "Access-Control-Expose-Headers";
	public static final String ALLOW_CREDENTIALS = "Access-Control-Allow-Credentials";
	public static final String MAX_AGE = "Access-Control-Max-Age";
	
	
	public static String createHeaderFromHttpMethodsEnums(HttpMethods... allowedMethods) {
        
		StringBuilder methods = new StringBuilder();
		for (int i = 0; i < allowedMethods.length; i++) {
			String httpMethod = allowedMethods[i].getName();
			methods.append(httpMethod);
			methods.append(",");
	    }
		methods.deleteCharAt(methods.length()-1);
		return methods.toString();
	}
	
	public static String createHeaderFromHttpHeadersEnums(HttpHeaders... allowedHeaders) {
        
		StringBuilder headers = new StringBuilder();
		for (int i = 0; i < allowedHeaders.length; i++) {
			String httpMethod = allowedHeaders[i].getName();
			headers.append(httpMethod);
			headers.append(",");
	    }
		headers.deleteCharAt(headers.length()-1);
		return headers.toString();
	}
	
}
