
package prim_java.exception;

// Exception cho lỗi trạng thái không hợp lệ
public class DisconnectedGraphException extends RuntimeException {
    public DisconnectedGraphException(String message) {
        super(message);
    }
}


