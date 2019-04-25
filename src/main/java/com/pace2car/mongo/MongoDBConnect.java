package com.pace2car.mongo;

import com.alibaba.fastjson.JSONObject;
import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author Pace2Car
 * @date 2019/4/18 11:04
 */
public class MongoDBConnect {
    public static String HOST = "127.0.0.1";
    public static int PORT = 27017;
    public static String USERNAME = "mongodb";
    public static String PASSWORD = "123456";
    public static String DATABASE = "mongodb";

    public static void main(String[] args) {
        try {
            System.out.println("MongoDBConnect to database begin");
            // 连接到MongoDB服务 如果是远程连接可以替换“localhost”为服务器所在IP地址
            // ServerAddress()两个参数分别为 服务器地址 和 端口
            ServerAddress serverAddress = new ServerAddress(HOST, PORT);
            List<ServerAddress> addrs = new ArrayList<ServerAddress>();
            addrs.add(serverAddress);

            //MongoCredential.createScramSha1Credential()三个参数分别为 用户名 数据库名称 密码
            MongoCredential credential = MongoCredential.createScramSha1Credential(USERNAME, DATABASE, PASSWORD.toCharArray());
            List<MongoCredential> credentials = new ArrayList<>();
            credentials.add(credential);

            //通过连接认证获取MongoDB连接
            MongoClient mongoClient = new MongoClient(addrs, credentials);
            //连接到数据库
            MongoDatabase mongoDatabase = mongoClient.getDatabase(DATABASE);
            System.out.println("MongoDBConnect to database successfully");

            // 无用户名密码连接
//            // 连接到 mongodb 服务
//            MongoClient mongoClient = new MongoClient( HOST , PORT );
//
//            // 连接到数据库
//            MongoDatabase mongoDatabase = mongoClient.getDatabase(DATABASE);
//            System.out.println("Connect to database successfully");



            MongoCollection<Document> collection = mongoDatabase.getCollection("col");
            System.out.println("集合获取成功");

            // 插入文档
            /**
             * 1. 创建文档 org.bson.Document 参数为key-value的格式
             * 2. 创建文档集合List<Document>
             * 3. 将文档集合插入数据库集合中 mongoCollection.insertMany(List<Document>) 插入单个文档可以用 mongoCollection.insertOne(Document)
             * */
//            Document document = new Document("title", "MongoDB Insert").
//                    append("description", "Java Insert").
//                    append("likes", 300).
//                    append("by", "Pace2Car");
//            List<Document> documents = new ArrayList<>();
//            documents.add(document);
//            collection.insertMany(documents);
//            System.out.println("文档插入成功");

            // 查询文档
            // 正则表达式 模糊匹配
            String regex = "^.*Java.*$";
            Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
            BasicDBObject query = new BasicDBObject();
            query.put("description",pattern);//key为表字段名
            FindIterable<Document> result = collection.find(query);
            MongoCursor<Document> mongoCursor = result.iterator();
            while (mongoCursor.hasNext()) {
//                System.out.println(JSONObject.toJSONString(mongoCursor.next()));
                System.out.println(mongoCursor.next());
            }

            Date date = new Date(1555571848000L);
            System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));

        } catch (MongoClientException e) {
            System.out.println("mongoDB 异常" + e);
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("发生异常" + e);
            e.printStackTrace();
        }
    }
}
