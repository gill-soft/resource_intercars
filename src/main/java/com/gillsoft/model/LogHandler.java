package com.gillsoft.model;

import java.io.ByteArrayOutputStream;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogHandler implements SOAPHandler<SOAPMessageContext> {

	private static Logger LOGGER = LogManager.getLogger(LogHandler.class);

	public boolean handleMessage(SOAPMessageContext context) {
		SOAPMessage message = context.getMessage();
		String MESSAGE_OUTBOUND = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY) ? "OUTBOUND MESSAGE\t" : "INBOUND MESSAGE\t";
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			message.writeTo(baos);
			LOGGER.info(MESSAGE_OUTBOUND + baos.toString());
			baos.close();
			return true;
		} catch (Exception e) {
			LOGGER.error(e);
		}
		return false;
	}

	public boolean handleFault(SOAPMessageContext context) {
		SOAPMessage message = context.getMessage();
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			message.writeTo(baos);
			LOGGER.warn("FAULT\t" + baos.toString());
			baos.close();
			return true;
		} catch (Exception e) {
			LOGGER.error(e);
		}
		return false;
	}

	public void close(MessageContext context) {
		// TODO Auto-generated method stub
	}

	public Set<QName> getHeaders() {
		// TODO Auto-generated method stub
		return null;
	}

}
