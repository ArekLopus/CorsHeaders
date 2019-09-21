package cors.servlet;

public class Cors {
	
	private boolean noCors = false;
	
	private boolean appendAllowOrigin = false;
	private boolean appendAllowHeaders = false;
	private boolean appendExposeHeaders = false;
	private boolean appendAllowMethods = false;
	
	private String allowOrigin = null;		// null to check if set
	private String allowMethods = null;
	private String allowHeaders = null;
	private String exposeHeaders = null;
		
	private Boolean allowCredentials = null;
	private Long maxAge = null;
	
	private String infoHeaderName = null;
	private String infoHeaderInfo = null;
	private boolean appendInfoHeader = false;
	
	
	public String getAllowOrigin() {
		return allowOrigin;
	}

	public void setAllowOrigin(String allowOrigin) {
		this.allowOrigin = allowOrigin;
	}

	public String getAllowMethods() {
		return allowMethods;
	}

	public void setAllowMethods(String allowMethods) {
		this.allowMethods = allowMethods;
	}

	public String getAllowHeaders() {
		return allowHeaders;
	}

	public void setAllowHeaders(String allowHeaders) {
		this.allowHeaders = allowHeaders;
	}

	public String getExposeHeaders() {
		return exposeHeaders;
	}

	public void setExposeHeaders(String exposeHeaders) {
		this.exposeHeaders = exposeHeaders;
	}

	public Boolean isAllowCredentials() {
		return allowCredentials;
	}

	public void setAllowCredentials(Boolean allowCredentials) {
		this.allowCredentials = allowCredentials;
	}

	public Long getMaxAge() {
		return maxAge;
	}

	public void setMaxAge(Long maxAge) {
		this.maxAge = maxAge;
	}
	
	
	public boolean isAppendAllowOrigin() {
		return appendAllowOrigin;
	}

	public void setAppendAllowOrigin(boolean appendAllowOrigin) {
		this.appendAllowOrigin = appendAllowOrigin;
	}

	public boolean isAppendAllowHeaders() {
		return appendAllowHeaders;
	}
	
	public void setAppendAllowHeaders(boolean appendAllowHeaders) {
		this.appendAllowHeaders = appendAllowHeaders;
	}

	public boolean isAppendExposeHeaders() {
		return appendExposeHeaders;
	}

	public void setAppendExposeHeaders(boolean appendExposeHeaders) {
		this.appendExposeHeaders = appendExposeHeaders;
	}

	public boolean isAppendAllowMethods() {
		return appendAllowMethods;
	}

	public void setAppendAllowMethods(boolean appendAllowMethods) {
		this.appendAllowMethods = appendAllowMethods;
	}
	
	
	
	public String getInfoHeaderName() {
		return infoHeaderName;
	}

	public void setInfoHeaderName(String infoHeaderName) {
		this.infoHeaderName = infoHeaderName;
	}

	public String getInfoHeaderInfo() {
		return infoHeaderInfo;
	}

	public void setInfoHeaderInfo(String infoHeaderInfo) {
		this.infoHeaderInfo = infoHeaderInfo;
	}

	public boolean isAppendInfoHeader() {
		return appendInfoHeader;
	}

	public void setAppendInfoHeader(boolean appendInfoHeader) {
		this.appendInfoHeader = appendInfoHeader;
	}
	
	
	
	public boolean isNoCors() {
		return noCors;
	}

	public void setNoCors(boolean noCors) {
		this.noCors = noCors;
	}
	
		
	@Override
	public String toString() {
		return "Cors:"
				+ "\nAllow_Origin=\t\t" + allowOrigin
				+ "\nAllow_Methods=\t\t" + allowMethods
				+ "\nAllow_Headers=\t\t" + allowHeaders
				+ "\nExpose_Headers=\t\t" + exposeHeaders
				+ "\nAllow_Credentials=\t" + allowCredentials
				+ "\nMax_Age=\t\t" + maxAge
				+ "\nInfo_Header=\t\t" + infoHeaderInfo;
	}
	
}
