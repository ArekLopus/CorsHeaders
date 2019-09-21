package cors.servlet.filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

import cors.servlet.Cors;
import cors.servlet.CorsBuilder;
import cors.servlet.CorsStage;
import cors.servlet.CorsUtils;

@WebFilter(value = "/*", asyncSupported = true, filterName = "cors-headers-filter")
public class CorsServletFilter implements Filter {

	private static CorsStage SERVLET_CORS_HEADERS;
	private Cors cors;
	
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletResponse resp = (HttpServletResponse) response; 
		
		if(SERVLET_CORS_HEADERS == null) {
			CorsBuilder.getDefaultCors();
		}
		
		if(SERVLET_CORS_HEADERS == null) {					// CorsJaxrs object is null, return.
			return;
		} else {
			cors = SERVLET_CORS_HEADERS.getCors();
			
			if(cors == null || cors.isNoCors()) {			// if Cors object is null or we skip cors, return.
				return;
			}
		}
		
		
		setOrAppendCorsHeader(CorsUtils.ALLOW_ORIGIN, cors.isAppendAllowOrigin(), cors.getAllowOrigin(), resp);
		
		setOrAppendCorsHeader(CorsUtils.ALLOW_METHODS, cors.isAppendAllowMethods(), cors.getAllowMethods(), resp);
		setOrAppendCorsHeader(CorsUtils.ALLOW_HEDAERS, cors.isAppendAllowHeaders(), cors.getAllowHeaders(), resp);
		setOrAppendCorsHeader(CorsUtils.EXPOSE_HEADERS, cors.isAppendExposeHeaders(), cors.getExposeHeaders(), resp);
		
		setCorsHeader(CorsUtils.ALLOW_CREDENTIALS, cors.isAllowCredentials(), resp);
		setCorsHeader(CorsUtils.MAX_AGE, cors.getMaxAge(), resp);
		
		setOrAppendCorsHeader(cors.getInfoHeaderName(), cors.isAppendInfoHeader(), cors.getInfoHeaderInfo(), resp);
		
		
		chain.doFilter(request, response);
	}
	
	
	
	private <T> void setCorsHeader(String headerName, T newHeader, HttpServletResponse resp) {
		
		if(newHeader == null) {											// Header is not set.
			return;
		}
		if(newHeader instanceof String && newHeader.equals("")) {		// Also return when empty string 
			return;
		}
		
		if(!resp.containsHeader(headerName)) {							// If no header, add it.
			resp.addHeader(headerName, String.valueOf(newHeader));
		} else {														// If header exists, override to a new value.
			resp.setHeader(headerName, String.valueOf(newHeader));
		}
		
	}
	
	
	
	private void setOrAppendCorsHeader(String headerName, boolean appendFlag, String newHeaders, HttpServletResponse resp) {
		
		if(newHeaders == null || newHeaders.equals("")) {				// Header is not set.
			return;
		}
		
		if(!resp.containsHeader(headerName)) {							// If no header, add it (for add or append).
			
			resp.addHeader(headerName, newHeaders);
		
		} else {
			
			if(appendFlag == false) {									// If header exists but no append flag set, override to a new value.
				
				resp.setHeader(headerName, newHeaders);
			
			} else {													// If header exists and append flag is set.
				
				Collection<String> oldHeaders = resp.getHeaders(headerName);
				
				String appendedHeader = this.createAppendedHeader(oldHeaders, newHeaders);
				
				resp.setHeader(headerName, appendedHeader);
				
			}
		}
	}
	
	// Parses new and old headers, eliminates duplicates, and creates a String of all headers 
	private String createAppendedHeader(Collection<String> oldHeaders, String newHeaders) {
        
		HashSet<String> headers = new HashSet<>();						// To remove duplicates.
		
		String[] splittedNewHeaders = newHeaders.split("\\s*,\\s*");
		headers.addAll(Arrays.asList(splittedNewHeaders));
		
		oldHeaders.forEach(e -> {
			String str = (String) e;
			String[] splittedOldHeaders = str.split("\\s*,\\s*");
			headers.addAll(Arrays.asList(splittedOldHeaders));
		});
		
		StringBuilder sb = new StringBuilder();
		
		headers.forEach(e -> {
			sb.append(e);
			sb.append(",");
		});
		
		sb.deleteCharAt(sb.length() - 1);		// Removes last comma.
		
		return sb.toString();
	}
	
	
	
	public static void setServletCorsHeaders(CorsStage corsJaxrs) {
		SERVLET_CORS_HEADERS = corsJaxrs;
	}
	
	
	
	@Override
	public void destroy() {} 
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}
	
}