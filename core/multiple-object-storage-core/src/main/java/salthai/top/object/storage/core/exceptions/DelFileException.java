package salthai.top.object.storage.core.exceptions;

/**
 * 删除异常
 *
 * @author Kuang HaiBo 2023/11/8 16:13
 */
public class DelFileException extends ObjectStorageException {

	/**
	 * Constructs a new runtime exception with the specified cause and a detail message of
	 * <tt>(cause==null ? null : cause.toString())</tt> (which typically contains the
	 * class and detail message of <tt>cause</tt>). This constructor is useful for runtime
	 * exceptions that are little more than wrappers for other throwables.
	 * @param cause the cause (which is saved for later retrieval by the
	 * {@link #getCause()} method). (A <tt>null</tt> value is permitted, and indicates
	 * that the cause is nonexistent or unknown.)
	 * @since 1.4
	 */
	public DelFileException(Throwable cause) {
		super(cause);
	}

}
