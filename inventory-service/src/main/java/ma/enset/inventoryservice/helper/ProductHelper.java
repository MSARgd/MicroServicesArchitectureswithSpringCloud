package ma.enset.inventoryservice.helper;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;


@Component
public class ProductHelper {
    public <T> void updateIfNotNull(Consumer<T> setter, T value) {
        if (value != null) {
            setter.accept(value);
        }
    }
}
