package test.app;

import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.HashMap;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.HttpClients;

import com.google.gson.Gson;

public class AppTransTestMain {

	public static void main(String[] args) throws Exception {
		String os = "1";
		String uuid = "test-uuid";
		String trCode = "MS01";
		String url = String.format("http://localhost:8080/appcardgw/app/%s/%s/%s", os, uuid, trCode);
		
//		String testMessage = "피곤하고 졸립고... 그냥 집에 가고 싶다 ㅡ.ㅜ";
		
		HashMap<String, String> requestData = new HashMap<String, String>();
		requestData.put("custNo", "U123456789012345");
		requestData.put("custNm", "김종명");
		
		String reqJsonString = new Gson().toJson(requestData);

		HttpPost post = new HttpPost(url);
//		post.setEntity(new ByteArrayEntity(testMessage.getBytes(Charset.forName("UTF-8"))));
		post.setEntity(new ByteArrayEntity(reqJsonString.getBytes(Charset.forName("UTF-8"))));

		CloseableHttpResponse response = HttpClients.createDefault().execute(post);
		
//		ResponseEntityProxy proxy = (ResponseEntityProxy)response.getEntity();
//		org.apache.http.impl.execchain.ResponseEntityProxy a;
		
		System.out.println("response.getStatusLine():" + response.getStatusLine().toString());
		
		HttpEntity resEntity = response.getEntity();
		
		InputStream input = resEntity.getContent();
		
		byte[] buf = new byte[1024];
		int readCount = -1;
		while((readCount = input.read(buf)) > -1) {
			System.out.println(readCount + ":" + new String(buf, 0, readCount, Charset.forName("UTF-8")));
		}
		
		
//		EntityUtils.consume(resEntity);
		
//		ByteArrayEntity resEntity = (ByteArrayEntity) response.getEntity();

//		long cl = resEntity.getContentLength();
//		System.out.println("response data length : " + cl);
//		byte[] resData = new byte[(int) cl];
		
//		byte[] resData = EntityUtils.toByteArray(resEntity);
//		resEntity.getContent().read(resData);
		
//		System.out.println(String.format("Response Data : %s", new String(resData)));

		// HttpClientBuilder builder = HttpClientBuilder.create();
		//
		//
		// HttpHeaders header = new HttpHeaders();
		//
		// HttpEntity entity = null;
		//
		// HttpPost post = new HttpPost();
		// post.setURI(new URI("http://localhost:8080/appcardgw/app/1/test-uuid/MS01"));
		// post.setEntity(null);

	}

}
