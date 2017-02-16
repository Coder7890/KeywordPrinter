package keyword.util;

public enum Contants {
  HASH("#"),
  PERIOD("."),
  SPACE(" ");

  private String value;

  private Contants(String value) {
    this.value = value;
  }

  public String getValue() {
    return this.value;
  }
}
