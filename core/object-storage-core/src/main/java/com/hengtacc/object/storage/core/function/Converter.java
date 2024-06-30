package com.hengtacc.object.storage.core.function;

import java.util.Objects;

/**
 * A converter converts a source object of type {@code S} to a target of type {@code T}.
 *
 * <p>
 * Implementations of this interface are thread-safe and can be shared.
 *
 * <p>
 *
 * @author Keith Donald
 * @author Josh Cummings
 * @since 3.0
 * @param <S> the source type
 * @param <T> the target type
 */
@FunctionalInterface
public interface Converter<S, T> {

	/**
	 * Convert the source object of type {@code S} to target type {@code T}.
	 * @param source the source object to convert, which must be an instance of {@code S}
	 * (never {@code null})
	 * @return the converted object, which must be an instance of {@code T} (potentially
	 * {@code null})
	 * @throws IllegalArgumentException if the source cannot be converted to the desired
	 * target type
	 */
	T convert(S source);

	/**
	 * Construct a composed {@link Converter} that first applies this {@link Converter} to
	 * its input, and then applies the {@code after} {@link Converter} to the result.
	 * @param after the {@link Converter} to apply after this {@link Converter} is applied
	 * @param <U> the type of output of both the {@code after} {@link Converter} and the
	 * composed {@link Converter}
	 * @return a composed {@link Converter} that first applies this {@link Converter} and
	 * then applies the {@code after} {@link Converter}
	 * @since 5.3
	 */
	default <U> Converter<S, U> andThen(Converter<? super T, ? extends U> after) {
		Objects.requireNonNull(after, "'after' Converter must not be null");
		return (S s) -> {
			T initialResult = convert(s);
			return (initialResult != null ? after.convert(initialResult) : null);
		};
	}

}