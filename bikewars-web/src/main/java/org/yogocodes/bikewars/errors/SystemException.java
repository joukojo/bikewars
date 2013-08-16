package org.yogocodes.bikewars.errors;

public abstract class SystemException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SystemException(final String msg) {
		super(msg);
	}

	public SystemException(final String msg, final Throwable cause) {
		super(msg, cause);
	}
}
