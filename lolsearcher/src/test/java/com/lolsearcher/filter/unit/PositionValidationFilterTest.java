package com.lolsearcher.filter.unit;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.io.IOException;

import javax.servlet.ServletException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockFilterChain;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import com.lolsearcher.filter.parameter.PositionValidationFilter;

@ExtendWith(MockitoExtension.class)
public class PositionValidationFilterTest {
	private final String KEY = "position";
	private final String FAIL_HANDLER_URI = "/invalid";
	
	PositionValidationFilter positionValidationFilter;
	
	MockHttpServletRequest req;
	@Mock
	MockHttpServletResponse rsp;
	@Mock
	MockFilterChain mockChain;
	
	@BeforeEach
	void setup() {
		positionValidationFilter = new PositionValidationFilter();
		req = new MockHttpServletRequest();
	}
	
	@DisplayName("Request의 파라미터 값이 적절한 경우 다음 필터로 이동")
	@NullSource
	@ParameterizedTest
	@ValueSource(strings = {"TOP", "JUNGLE", "MIDDLE", "BOTTOM","UTILITY"})
	void getRequestWithProperParameter(String value) throws IOException, ServletException{
		//given
		req.setParameter(KEY, value);
		//when
		positionValidationFilter.doFilter(req, rsp, mockChain);
		//then
		verify(mockChain, times(1)).doFilter(req, rsp);
		verify(rsp, times(0)).sendRedirect(FAIL_HANDLER_URI);
	}
	
	@DisplayName("Request의 파라미터 값이 없을 경우 다음 필터로 이동")
	@Test
	void getRequestWithNoParameter() throws IOException, ServletException{
		//no given
		//when
		positionValidationFilter.doFilter(req, rsp, mockChain);
		//then
		verify(mockChain, times(1)).doFilter(req, rsp);
		verify(rsp, times(0)).sendRedirect(FAIL_HANDLER_URI);
	}
	
	@DisplayName("Request의 파라미터 값이 적절하지 않을 경우 실패 페이지로 이동")
	@ParameterizedTest
	@ValueSource(strings = {"", " ", "탑","TOP ","top"})
	void getRequestWithImproperParameter(String value) throws IOException, ServletException{
		//given
		req.setParameter(KEY, value);
		//when
		positionValidationFilter.doFilter(req, rsp, mockChain);
		//then
		verify(mockChain, times(0)).doFilter(req, rsp);
		verify(rsp, times(1)).sendRedirect(FAIL_HANDLER_URI);
	}
}
