package br.com.oversight.zgProjeto.api.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class DateConverter implements Converter {

	private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:MM:ss");

	@Override
	public boolean canConvert(@SuppressWarnings("rawtypes") Class type) {
		return type.equals(Date.class);
	}

	@Override
	public void marshal(Object source, HierarchicalStreamWriter writer, MarshallingContext context) {
		Date data = (Date) source;
		writer.setValue(formatter.format(data));
	}

	@Override
	public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
		Date data = null;
		try {
			data = formatter.parse(reader.getValue());
		} catch (Exception e) {
			Logger.getLogger(DateConverter.class.getName()).log(Level.SEVERE, null, e);
		}
		return data;
	}

}
