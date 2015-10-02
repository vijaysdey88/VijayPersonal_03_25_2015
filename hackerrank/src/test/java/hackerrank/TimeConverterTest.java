package hackerrank;

import junit.framework.Assert;
import org.junit.Test;

public class TimeConverterTest {
	
	TimeConverter tc = new TimeConverter();
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldNotAllowConversionOfEmptyString() {
		String converted = tc.convert("");
	}

	@Test
	public void shouldAllowAValidInput() {
		Assert.assertNotNull(tc.convert("11:59:59PM"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldNotAllowInvalidHour() {
		 tc.convert("13:59:59PM");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldNotAllowInvalidMinutes() {
		 tc.convert("12:60:59PM");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldNotAllowInvalidSeconds() {
		 tc.convert("12:59:60PM");
	}
	
	@Test
	public void shouldConvertATimeInAM() {
		Assert.assertEquals("00:59:59", tc.convert("12:59:59AM"));
		Assert.assertEquals("01:59:59", tc.convert("01:59:59AM"));
		Assert.assertEquals("00:00:00", tc.convert("12:00:00AM"));
	}
	
	@Test
	public void shouldConvertATimeInPM() {
		Assert.assertEquals("23:59:59",  tc.convertDirect("11:59:59PM"));
		Assert.assertEquals("12:59:59",  tc.convertDirect("12:59:59PM"));
		Assert.assertEquals("12:00:00",  tc.convertDirect("12:00:00PM"));
	
		Assert.assertEquals("13:01:00",  tc.convertDirect("01:01:00PM"));
	
		Assert.assertEquals("00:40:22", tc.convertDirect("12:40:22AM"));

		Assert.assertEquals("00:59:59", tc.convertDirect("12:59:59AM"));
		Assert.assertEquals("01:59:59", tc.convertDirect("01:59:59AM"));
		Assert.assertEquals("00:00:00", tc.convertDirect("12:00:00AM"));
		Assert.assertEquals("13:01:00",  tc.convertDirect("01:01:00PM"));
		String converted = tc.convertDirect("12:40:22AM");
		Assert.assertEquals("00:40:22", converted);
	}
	
}
