import org.redisson.Redisson;
import org.redisson.api.RExecutorService;
import org.redisson.api.RLock;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.util.concurrent.TimeUnit;

/**
 * @author wanghanyu
 * @create 2017-06-17 10:38
 */
public class HelloWorld {

    public static void main(String[] args) {
        // 1. Create config object
        Config config = new Config();

        // 2. Create Redisson instance
        RedissonClient redisson = Redisson.create(config);

        // 3. Get object you need
        RMap<String, String> map = redisson.getMap("myMap");

        RLock lock = redisson.getLock("myLock");


        lock.lock(100, TimeUnit.MINUTES);

        lock.unlock();


        RExecutorService executor = redisson.getExecutorService("myExecutorService");
    }

    public void testDouble() {

    }
}
