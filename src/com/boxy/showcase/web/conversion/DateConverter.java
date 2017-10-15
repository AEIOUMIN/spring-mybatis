package com.boxy.showcase.web.conversion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 * 自定义日期转换器
 * @author Administrator
 *
 */
public class DateConverter implements Converter<String, Date> {

	@Override
	public Date convert(String source) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			return format.parse(source);
		} catch (ParseException e) {
		}
		return null;
	}
}
