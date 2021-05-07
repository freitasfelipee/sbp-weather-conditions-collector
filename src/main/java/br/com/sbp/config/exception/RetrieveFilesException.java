package br.com.sbp.config.exception;

public class RetrieveFilesException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public RetrieveFilesException() {
		super("Failed to list files.");
	}
	
}