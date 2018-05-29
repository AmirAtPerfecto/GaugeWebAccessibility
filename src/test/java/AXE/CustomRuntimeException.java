package AXE;

public class CustomRuntimeException extends RuntimeException {
  private static final long serialVersionUID = 1L;

  public CustomRuntimeException(final String reason) {
    super(reason);
  }

  public CustomRuntimeException(final String reason, final Throwable e) {
    super(reason, e);
  }
}
