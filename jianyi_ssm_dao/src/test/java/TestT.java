import com.atjianyi.dao.OrdersMapper;
import com.atjianyi.pojo.Orders;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author 简一
 * @className TestT
 * @Date 2021/2/22 16:33
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext-dao.xml")
public class TestT {
    @Autowired
    private OrdersMapper mapper;

    @Test
    public void show() throws Exception {
        List<Orders> allOrders = mapper.findAllOrders();
        System.out.println(allOrders);
    }
}
