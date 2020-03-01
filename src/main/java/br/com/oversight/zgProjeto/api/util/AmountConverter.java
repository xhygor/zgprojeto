package br.com.oversight.zgProjeto.api.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class AmountConverter implements Converter {

	@Override
	public boolean canConvert(@SuppressWarnings("rawtypes") Class type) {
		return type.equals(BigDecimal.class);
	}

	@Override
	public void marshal(Object source, HierarchicalStreamWriter writer, MarshallingContext context) {
		BigDecimal amount = new BigDecimal(source.toString());
		writer.setValue(amount.toString());
	}

	@Override
	public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
		BigDecimal amount = null;
		try {
			amount = new BigDecimal(reader.getValue());
		} catch (Exception e) {
			Logger.getLogger(AmountConverter.class.getName()).log(Level.SEVERE, null, e);
		}
		return amount;
	}

}
