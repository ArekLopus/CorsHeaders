package cors.enums;

// Based on: https://developer.mozilla.org/pl/docs/Web/HTTP/Headers
public enum HttpHeaders {
	
	// Authentication
	WWW_AUTHENTICATE("WWW-Authenticate"),
	AUTHORIZATION("Authorization"),
	PROXY_AUTHENTICATE("Proxy-Authenticate"),
	PROXY_AUTHORIZATION("Proxy-Authorization"),
	
	// Caching
	AGE("Age"),
	CACHE_CONTROL("Cache-Control"),
	EXPIRES("Expires"),
	PRAGMA("Pragma"),
	WARNING("Warning"),
	
	// Client hints
	ACCEPT_CH("Accept-CH"),
	CONTENT_DPR("Content-DPR"),
	DPR("DPR"),
	DOWNLINK("Downlink"),
	SAVE_DATA("Save-Data"),
	VIEWPORT_WIDTH("Viewport-Width"),
	WIDTH("Width"),
	
	// Conditionals
	LAST_MODIFIED("Last-Modified"),
	ETAG("ETag"),
	IF_MATCH("If-Match"),
	IF_NONE_MATCH("If-None-Match"),
	IF_MODIFIED_SINCE("If-Modified-Since"),
	IF_UNMODIFIED_SINCE("If-Unmodified-Since"),
	
	// Connection management
	CONNECTION("Connection"),
	KEEP_ALIVE("Keep-Alive"),
	
	// Content negotiation
	ACCEPT("Accept"),
	ACCEPT_CHARSET("Accept-Charset"),
	ACCEPT_ENCODING("Accept-Encoding"),
	ACCEPT_LANGUAGE("Accept-Language"),
	
	// Controls
	EXPECT("Expect"),
	MAX_FORWARDS("Max-Forwards"),
	
	// Cookies
	COOKIE("Cookie"),
	SET_COOKIE("Set-Cookie"),
	COOKIE2("Cookie2"),
	SET_COOKIE2("Set-Cookie2"),
	
	// CORS
	ACCESS_CONTROL_ALLOW_ORIGIN("Access-Control-Allow-Origin"),
	ACCESS_CONTROL_ALLOW_CREDENTIALS("Access-Control-Allow-Credentials"),
	ACCESS_CONTROL_ALLOW_HEADERS("Access-Control-Allow-Headers"),
	ACCESS_CONTROL_ALLOW_METHODS("Access-Control-Allow-Methods"),
	ACCESS_CONTROL_EXPOSE_HEADERS("Access-Control-Expose-Headers"),
	ACCESS_CONTROL_MAX_AGE("Access-Control-Max-Age"),
	ACCESS_CONTROL_REQUEST_HEADERS("Access-Control-Request-Headers"),
	ACCESS_CONTROL_REQUEST_METHOD("Access-Control-Request-Method"),
	ORIGIN("Origin"),
	TIMING_ALLOW_ORIGIN("Timing-Allow-Origin"),
	
	// Do Not Track
	DNT("DNT"),
	TK("Tk"),
	
	// Downloads
	CONTENT_DISPOSITION("Content-Disposition"),
	
	// Message body information
	CONTENT_LENGTH("Content-Length"),
	CONTENT_TYPE("Content-Type"),
	CONTENT_ENCODING("Content-Encoding"),
	CONTENT_LANGUAGE("Content-Language"),
	CONTENT_LOCATION("Content-Location"),
	
	// Proxies
	FORWARDED("Forwarded"),
	X_FORWARDED_FOR("X-Forwarded-For"),
	X_FORWARDED_HOST("X-Forwarded-Host"),
	X_FORWARDED_PROTO("X-Forwarded-Proto"),
	VIA("Via"),
	
	// Redirects 
	LOCATION("Location"),
	
	// Request context
	FROM("From"),
	HOST("Host"),
	REFERER("Referer"),
	REFERRER_POLICY("Referrer-Policy"),
	USER_AGENT("User-Agent"),
	
	// Response context
	ALLOW("Allow"),
	SERVER("Server"),
	
	// Range requests
	ACCEPT_RANGES("Accept-Ranges"),
	RANGE("Range"),
	IF_RANGE("If-Range"),
	CONTENT_RANGE("Content-Range"),
	
	// Security
	CONTENT_SECURITY_POLICY("Content-Security-Policy"),
	CONTENT_SECURITY_POLICY_REPORT_ONLY("Content-Security-Policy-Report-Only"),
	EXPECT_CT("Expect-CT"),
	PUBLIC_KEY_PINS("Public-Key-Pins"),
	PUBLIC_KEY_PINS_REPORT_ONLY("Public-Key-Pins-Report-Only"),
	STRICT_TRANSPORT_SECURITY("Strict-Transport-Security"),
	UPGRADE_INSECURE_REQUESTS("Upgrade-Insecure-Requests"),
	X_CONTENT_TYPE_OPTIONS("X-Content-Type-Options"),
	X_FRAME_OPTIONS("X-Frame-Options"),
	X_XSS_PROTECTION("X-XSS-Protection"),
	
	// Server-sent events
	PING_FROM("Ping-From"),
	PING_TO("Ping-To"),
	LAST_EVENT_ID("Last-Event-ID"),
	
	// Transfer coding
	TRANSFER_ENCODING("Transfer-Encoding"),
	TE("TE"),
	TRAILER("Trailer"),
	
	// WebSockets
	SEC_WEBSOCKET_KEY("Sec-WebSocket-Key"),
	SEC_WEBSOCKET_EXTENSIONS("Sec-WebSocket-Extensions"),
	SEC_WEBSOCKET_ACCEPT("Sec-WebSocket-Accept"),
	SEC_WEBSOCKET_PROTOCOL("Sec-WebSocket-Protocol"),
	SEC_WEBSOCKET_VERSION("Sec-WebSocket-Version"),
	
	// Other
	DATE("Date"),
	LARGE_ALLOCATION("Large-Allocation"),
	LINK("Link"),
	RETRY_AFTER("Retry-After"),
	SOURCEMAP("SourceMap"),
	UPGRADE("Upgrade"),
	VARY("Vary"),
	X_DNS_PREFETCH_CONTROL("X-DNS-Prefetch-Control"),
	X_FIREFOX_SPDY("X-Firefox-Spdy"),
	X_REQUESTED_WITH("X-Requested-With"),
	X_UA_COMPATIBLE("X-UA-Compatible");
	
	private String name = "None";
	
	private HttpHeaders(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
	
}