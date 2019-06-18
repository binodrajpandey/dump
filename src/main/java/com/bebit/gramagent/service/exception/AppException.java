package com.bebit.gramagent.service.exception;

/**
 * Application exception class. As it inherits RutimeException, it is thrown to the top layer unless
 * it is explicitly caught. It has errorCode as additional information.
 * 
 * @author binodraj-pandey
 *
 */
public class AppException extends RuntimeException {
	private static final long serialVersionUID = -2485953079742567823L;

	/**
   * Application error code
   */
  private Integer errorCode;
	

	public AppException(int errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
	}


  public Integer getErrorCode() {
    return errorCode;
  }

  public void setErrorCode(Integer errorCode) {
    this.errorCode = errorCode;
  }

}
