package demo.cmq;

import com.google.gson.Gson;
import com.qcloud.cmq.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class CmqDemo {
    /**
     * log对象
     */
    private static Logger log = LoggerFactory.getLogger(CmqDemo.class);

    public static void main(String[] args) throws Exception {
        Account account = new Account("https://cmq-queue-gz.api.qcloud.com", "AKID4uVpVvk2jDRP7jJLMEuKVSGp8C0c86yf", "bx4va1EC0YqtgGbgWBcnjQvDH5i5CKOG");
        Topic topic = account.getTopic("userportraitRTC");
        topic.batchPublishMessage(Arrays.asList("{\n" +
                "    \"userId\":170,\n" +
                "    \"client\":\"IOS\"\n" +
                "}","{\n" +
                "    \"userId\":1,\n" +
                "    \"client\":\"ANDROID\"\n" +
                "}", "{\n" +
                "    \"userId\":171,\n" +
                "    \"client\":\"HUAWEI\"\n" +
                "}"));
        return;
    }

    private static void cmqQueue() {
        Account account = new Account("https://cmq-queue-gz.api.qcloud.com", "AKID4uVpVvk2jDRP7jJLMEuKVSGp8C0c86yf", "bx4va1EC0YqtgGbgWBcnjQvDH5i5CKOG");
        Queue queue = account.getQueue("sos_test");
        while (true) {
            try {
                List<Message> messages = queue.batchReceiveMessage(17, 0);
                messages.parallelStream().forEach(message -> {
                    System.out.println(new Gson().fromJson(message.msgBody, TreeMap.class));
                });
            } catch (CMQServerException e) {
                if (7000 == e.getErrorCode()) {
                    log.info("没有更多消息");
                    return;
                }
            } catch (Exception e) {
                log.error("接口调用异常！", e);
                return;
            }
        }
        //删除消息
//        queue.batchDeleteMessage(messages.stream().map(message -> message.receiptHandle).collect(Collectors.toList()));
    }
}
