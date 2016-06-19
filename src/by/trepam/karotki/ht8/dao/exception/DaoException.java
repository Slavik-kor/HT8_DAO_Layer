package by.trepam.karotki.ht8.dao.exception;

public class DaoException extends Exception {

	private static final long serialVersionUID = 1L;

	public DaoException() {
	}

	public DaoException(String message) {
		super(message);
	}

	public DaoException(String message, Exception e) {
		super(message, e);
	}

}
