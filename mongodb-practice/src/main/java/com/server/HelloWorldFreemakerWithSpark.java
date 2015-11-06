package com.server;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.study.DBConnection;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class HelloWorldFreemakerWithSpark {

	private static final Configuration CONF = new Configuration();
	static {
		CONF.setClassForTemplateLoading(HelloWorldFreemakerWithSpark.class, "/");
	}

	public static void main(String[] args) {
		final StringWriter writer = new StringWriter();
		Spark.get(new Route("/") {
			@Override
			public Object handle(Request arg0, Response arg1) {
				readHelloTemplate(CONF, writer);
				return writer;
			}
		});
	}

	private static void readHelloTemplate(Configuration conf, StringWriter writer) {
		try {
			Template helloTemplate = conf.getTemplate("hello.ftl");
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("name", "Vijay");
			
			MongoCollection<Document> persons = DBConnection.INSTANCE.getCollection("persons");
			Document p = persons.find(Filters.eq("name", "vijay")).first();
			
			helloTemplate.process(p, writer);
			System.out.println(writer.toString());
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

}
