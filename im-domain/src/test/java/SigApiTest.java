import com.alibaba.fastjson.JSONObject;
import com.bantanger.im.codec.utils.SigAPI;
import com.bantanger.im.service.strategy.pay.Payment;
import com.bantanger.im.service.strategy.pay.PaymentFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

/**
 * @author BanTanger 半糖
 * @Date 2023/4/2 21:06
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = com.bantanger.im.domain.Application.class)
public class SigApiTest {

    @Test
    public void test_sigApi() {
        SigAPI asd = new SigAPI(10001, "bantanger");
        String sign = asd.genUserSig("10001", 100000000);
        JSONObject jsonObject = asd.decodeUserSig(sign);
        System.out.println("sign: " + sign);
        System.out.println("decoder: " + jsonObject.toString());
    }

    @Resource
    private PaymentFactory paymentFactory;

    @Test
    public void Test_Payment() {
        String type = "wechat";
        Payment payment = paymentFactory.getPayment(type);
        double amount = 100.00;
        payment.pay(amount);
        System.out.println("您已使用" + type + "支付了" + amount + "元");
    }

}
