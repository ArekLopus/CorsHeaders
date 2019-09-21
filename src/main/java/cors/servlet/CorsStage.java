package cors.servlet;

import java.util.concurrent.TimeUnit;

import cors.enums.CorsType;
import cors.enums.HttpHeaders;
import cors.enums.HttpMethods;
import cors.servlet.filter.CorsServletFilter;

/**
 * 
 * This class exposes methods to create CORS headers.
 * <p>
 * setXXX methods - set headers if they do not exist already or override existing ones.
 * <p>
 * appendXXX methods - set headers if they do not exist already or append to the existing ones.
 * <p>
 * If a header is not declared in the builder, it is not set. 
 * <p> 
 * Set null to explicitly disable a header (the header set by any other means, like other filter, is still visible).
 * 
 */
public class CorsStage {
	
	private Cors cors;
	
	
	public CorsStage(CorsType type) {
		
		cors = new Cors();
		
		switch (type) {
			
			case BUILDER:
				break;
			case DEFAULT:
				setDefaultCors();
				build();
				break;
			case DISABLED:
				cors.setNoCors(true);
				build();
				break;
			default:
				break;
		}
		
	}
	
	
	
	/**
	 * Sets 'Access-Control-Allow-Origin' header, if this header already exists, it is overridden.
	 */
	public CorsStage setAllowOrigin(String allowedOrigins) {
		cors.setAllowOrigin(allowedOrigins);
		return this;
	}
	
	/**
	 * Sets if does not exist or appends to an existing 'Access-Control-Allow-Origin' header.
	 */
	public CorsStage appendAllowOrigin(String allowedOrigins) {
		cors.setAllowOrigin(allowedOrigins);
		cors.setAppendAllowOrigin(true);
		return this;
	}
	
	
	
	/**
	 * Sets 'Access-Control-Allow-Headers' header, if this header already exists, it is overridden.
	 * @param allowedHeaders  This version accepts a String with comma separated values.
	 */
	public CorsStage setAllowHeaders(String allowedHeaders) {
		cors.setAllowHeaders(allowedHeaders);
		cors.setAppendAllowHeaders(false);
		return this;
	}
	
	/**
	 * Sets 'Access-Control-Allow-Headers' header, if this header already exists, it is overridden.
	 * @param allowedHeaders  This version accepts HttpHeaders enum (comma separated for multi values).
	 */
	public CorsStage setAllowHeaders(HttpHeaders... allowedHeaders) {
		String allowHeaders = CorsUtils.createHeaderFromHttpHeadersEnums(allowedHeaders);
		cors.setAllowHeaders(allowHeaders);
		cors.setAppendAllowHeaders(false);
		return this;
	}
	
	/**
	 * Sets if does not exist or appends to an existing 'Access-Control-Allow-Headers' header.
	 * @param allowedHeaders  This version accepts a String with comma separated values.
	 */
	public CorsStage appendAllowHeaders(String allowedHeaders) {
		cors.setAllowHeaders(allowedHeaders);
		cors.setAppendAllowHeaders(true);
		return this;
	}
	
	/**
	 * Sets if does not exist or appends to an existing 'Access-Control-Allow-Headers' header.
	 * @param allowedHeaders  This version accepts HttpHeaders enum (comma separated for multi values).
	 */
	public CorsStage appendAllowHeaders(HttpHeaders... allowedHeaders) {
		String allowHeaders = CorsUtils.createHeaderFromHttpHeadersEnums(allowedHeaders);
		cors.setAllowHeaders(allowHeaders);
		cors.setAppendAllowHeaders(true);
		return this;
	}
		
	
	
	/**
	 * Sets 'Access-Control-Expose-Headers' header, if this header already exists, it is overridden.
	 * @param exposedHeaders  This version accepts a String with comma separated values.
	 */
	public CorsStage setExposeHeaders(String exposedHeaders) {
		cors.setExposeHeaders(exposedHeaders);
		cors.setAppendExposeHeaders(false);
		return this;
	}
	
	/**
	 * Sets 'Access-Control-Expose-Headers' header, if this header already exists, it is overridden.
	 * @param exposedHeaders  This version accepts HttpHeaders enum (comma separated for multi values).
	 */
	public CorsStage setExposeHeaders(HttpHeaders... exposedHeaders) {
		String exposeHeaders = CorsUtils.createHeaderFromHttpHeadersEnums(exposedHeaders);
		cors.setExposeHeaders(exposeHeaders);
		cors.setAppendExposeHeaders(false);
		return this;
	}
	
	/**
	 * Sets if does not exist or appends to an existing 'Access-Control-Expose-Headers' header.
	 * @param exposedHeaders  This version accepts a String with comma separated values.
	 */
	public CorsStage appendExposeHeaders(String exposedHeaders) {
		cors.setExposeHeaders(exposedHeaders);
		cors.setAppendExposeHeaders(true);
		return this;
	}
	
	/**
	 * Sets if does not exist or appends to an existing 'Access-Control-Expose-Headers' header.
	 * @param exposedHeaders  This version accepts HttpHeaders enum (comma separated for multi values).
	 */
	public CorsStage appendExposeHeaders(HttpHeaders... exposedHeaders) {
		String exposeHeaders = CorsUtils.createHeaderFromHttpHeadersEnums(exposedHeaders);
		cors.setExposeHeaders(exposeHeaders);
		cors.setAppendExposeHeaders(true);
		return this;
	}
	
	
	
	/**
	 * Sets 'Access-Control-Allow-Methods' header, if this header already exists, it is overridden.
	 * @param allowedMethods  This version accepts a String with comma separated values.
	 */
	// Comma separated methods
	public CorsStage setAllowMethods(String allowedMethods) {
		cors.setAllowMethods(allowedMethods);
		cors.setAppendAllowMethods(false);
		return this;
	}
	
	/**
	 * Sets 'Access-Control-Allow-Methods' header, if this header already exists, it is overridden.
	 * @param allowedMethods  This version accepts HttpMethods enum (comma separated for multi values).
	 */
	public CorsStage setAllowMethods(HttpMethods... allowedMethods) {
		String allowMethods = CorsUtils.createHeaderFromHttpMethodsEnums(allowedMethods);
		cors.setAllowMethods(allowMethods);
		cors.setAppendAllowMethods(false);
		return this;
	}
	
	/**
	 * Sets if does not exist or appends to an existing 'Access-Control-Allow-Methods' header.
	 * @param allowedMethods  This version accepts a String with comma separated values.
	 */
	public CorsStage appendAllowMethods(String allowedMethods) {
		cors.setAllowMethods(allowedMethods);
		cors.setAppendAllowMethods(true);
		return this;
	}
	
	/**
	 * Sets if does not exist or appends to an existing 'Access-Control-Allow-Methods' header.
	 * @param allowedMethods  This version accepts HttpMethods enum (comma separated for multi values).
	 */
	public CorsStage appendAllowMethods(HttpMethods... allowedMethods) {
		String allowMethods = CorsUtils.createHeaderFromHttpMethodsEnums(allowedMethods);
		cors.setAllowMethods(allowMethods);
		cors.setAppendAllowMethods(true);
		return this;
	}
	
	
	
	/**
	 * Sets 'Access-Control-Allow-Credentials' header, if this header already exists, it is overridden.
	 */
	public CorsStage setAllowCredentials(Boolean allowCredentials) {
		cors.setAllowCredentials(allowCredentials);
		return this;
	}
	
	
	
	/**
	 * Sets 'Access-Control-Max-Age' header, if this header already exists, it is overridden.
	 * @param maxAgeInMinutes  Long value representing minutes.
	 */
	public CorsStage setMaxAge(Long maxAgeInMinutes) {
		cors.setMaxAge(maxAgeInMinutes);
		return this;
	}
	
	/**
	 * Sets 'Access-Control-Max-Age' header, if this header already exists, it is overridden.
	 * @param time  Time value that uses the set TimeUnit.
	 */
	public CorsStage setMaxAge(TimeUnit timeUnit, long time) {
		long minutes = timeUnit.toMinutes(time);
		
		if(minutes < 1) {
			cors.setMaxAge(1L);
		} else {
			cors.setMaxAge(minutes);
		}
		
		return this;
	}
	
	
	
	/**
	 * Sets a custom informational header, if this header already exists, it is overridden.
	 */
	public CorsStage setInfoHeader(String headersName, String info) {
		cors.setInfoHeaderName(headersName);
		cors.setInfoHeaderInfo(info);
		return this;
	}
	
	/**
	 * Sets if does not exist or appends to an existing custom informational header.
	 */
	public CorsStage appendInfoHeader(String headersName, String info) {
		cors.setInfoHeaderName(headersName);
		cors.setInfoHeaderInfo(info);
		cors.setAppendInfoHeader(true);
		return this;
	}
	
	
	
	/**
	 * Finishes building CORS headers.
	 */
	public void build() {
		CorsServletFilter.setServletCorsHeaders(this);
	}
	
	
	/**
	 * Returns Cors object with headers' settings.
	 */
	public Cors getCors() {
		return cors;
	}
	

	
	private void setDefaultCors() {
		
		setAllowOrigin("*");
		setAllowHeaders(HttpHeaders.ORIGIN, HttpHeaders.ACCEPT, HttpHeaders.CONTENT_TYPE);
		setAllowMethods("GET,POST,PUT,DELETE,OPTIONS,HEAD,PATCH");
		setAllowCredentials(true);
		setMaxAge(TimeUnit.HOURS, 24);
		setInfoHeader("X-CORS-Headers", "Powered-by-CorsHeaders");
		
	}
	
	
}