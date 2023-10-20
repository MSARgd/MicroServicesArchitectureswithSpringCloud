package ma.enset.customerservice.helper;

import org.springframework.stereotype.Component;

import java.util.function.Consumer;
@Component
public class CustomerHelper {
    public <T> void updateIfNotNull(Consumer<T> setter, T value) {
        if (value != null) {
            setter.accept(value);
        }
    }
}
