
package prim_java.exception;

// Exception cho lỗi khi tham số đầu vào không hợp lệ
public class InvalidGraphException extends RuntimeException {
    public InvalidGraphException(String message) {
        super(message);
    }
}

