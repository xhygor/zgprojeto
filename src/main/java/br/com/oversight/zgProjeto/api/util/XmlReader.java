package br.com.oversight.zgProjeto.api.util;

import java.io.IOException;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.Dom4JDriver;

import br.com.oversight.zgProjeto.domainServer.entity.PagementoServico;
import lombok.Data;

@Data
public class XmlReader implements Serializable {

	private static final long serialVersionUID = -4769774064125151399L;

	private XStream xstream;

	public XmlReader() {
		this.xstream = new XStream(new Dom4JDriver());
		this.xstream.alias("data", ArrayList.class);
		this.xstream.processAnnotations(PagementoServico.class);
		this.xstream.registerConverter(new DateConverter());
		this.xstream.registerConverter(new AmountConverter());
	}

	@SuppressWarnings("unchecked")
	public List<PagementoServico> converterXML(String url) throws IOException {
		@SuppressWarnings({ "rawtypes", "unused" })
		ArrayList<PagementoServico> enderecos = (ArrayList) this.xstream.fromXML(conect(url));
		return (ArrayList<PagementoServico>) xstream.fromXML(conect(url));
	}

	private URL conect(String urlXml) throws IOException {
		HttpURLConnection con = null;
		URL url = null;
		try {
			url = new URL(urlXml);
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.connect();
			validaGet(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return url;
	}

	private void validaGet(HttpURLConnection con) throws Exception {
		if (con.getResponseCode() != 200) {
			throw new Exception("url invalida!");
		}
	}
}
