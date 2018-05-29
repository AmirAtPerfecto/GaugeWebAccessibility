package AXE;

public class AccessibilityException extends CustomRuntimeException {
  private static final long serialVersionUID = 1L;

  public AccessibilityException(String reason) {
    super(reason);
  }
}
