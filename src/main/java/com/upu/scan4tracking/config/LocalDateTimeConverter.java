//package com.upu.scan4tracking.config;
//
//import java.time.LocalDateTime;
//
//public class LocalDateTimeConverter extends DozerConverter<LocalDateTime, Date> {
//	public LocalDateTimeConverter() {
//		super(LocalDateTime.class, Date.class);
//	}
//
//	@Override
//	public Date convertTo(LocalDateTime source, Date destination) {
//		if (source == null) {
//			return null;
//		}
//		return Date.from(source.atZone(ZoneId.systemDefault()).toInstant());
//	}
//
//	@Override
//	public LocalDateTime convertFrom(Date source, LocalDateTime destination) {
//		if (source == null) {
//			return null;
//		}
//		return LocalDateTime.ofInstant(source.toInstant(), ZoneId.systemDefault());
//	}
//}