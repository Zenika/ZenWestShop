package com.zenika.cakefactory.util;

/**
 * @author gtinon
 */
public class PhysiqueNonRespecteeException extends RuntimeException {

	public PhysiqueNonRespecteeException() {
	}

	public PhysiqueNonRespecteeException(String message) {
		super(message);
	}

	public PhysiqueNonRespecteeException(String message, Throwable cause) {
		super(message, cause);
	}

	public PhysiqueNonRespecteeException(Throwable cause) {
		super(cause);
	}

	public PhysiqueNonRespecteeException(String message, Throwable cause, boolean enableSuppression,
	                                     boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
