
package prim_java.exception;

// Exception cho lỗi cạnh trùng lặp
public class DuplicateEdgeException extends RuntimeException {
    public DuplicateEdgeException(String message) {
        super(message);
    }
}

