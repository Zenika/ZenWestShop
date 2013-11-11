package com.zenika.cakefactory.util;

import com.google.common.base.Objects;
import org.mockito.ArgumentMatcher;

public class VarargCaptor<T> extends ArgumentMatcher<T[]> implements org.mockito.internal.matchers.VarargMatcher {

	private T[] expectedValues;

	VarargCaptor(T... expectedValues) {
		this.expectedValues = expectedValues;
	}

	@Override
	public boolean matches(Object varargArgument) {
		return Objects.equal(expectedValues, varargArgument);
	}

}
