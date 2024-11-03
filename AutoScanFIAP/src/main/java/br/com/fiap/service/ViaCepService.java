package br.com.fiap.service;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;

import br.com.fiap.model.Endereco;

public class ViaCepService {

	public Endereco getEndereco(String cep) throws ClientProtocolException, IOException {
		
		Endereco endereco = null;
		
		// request
		HttpGet request = new HttpGet("https://viacep.com.br/ws/" + cep + "/json/");
		
		CloseableHttpClient httpCliente = HttpClientBuilder.create().disableRedirectHandling().build();
		
		//response
		CloseableHttpResponse response = httpCliente.execute(request);
		
		//entitiy
		HttpEntity entity = response.getEntity();
		
		if (entity != null) {
			String resultado = EntityUtils.toString(entity);
			
			Gson gson = new Gson();
			
			endereco = gson.fromJson(resultado, Endereco.class);
		}
		
		return endereco;
	}
	
}
