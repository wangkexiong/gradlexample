package cn.edu.bupt.wangkexiong;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

public class HelloServletTest {

    @Test
    public void testDoGet() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest("GET", "/submit");
        MockHttpServletResponse response = new MockHttpServletResponse();

        new HelloServlet().doGet(request, response);
        String[] lines = response.getContentAsString().split("\n");

        assertEquals("Expected as many lines as We have parameter values", 1, lines.length);
        assertEquals("Hello World", lines[0]);
    }
}
