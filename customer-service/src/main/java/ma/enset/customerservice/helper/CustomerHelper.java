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

    public <T> void updateIfNotNullOrPreserve(Consumer<T> setter, T value, T existingValue) {
        if (value != null) {
            setter.accept(value);
        } else if (existingValue != null) {
            setter.accept(existingValue);
        }
    }
}
