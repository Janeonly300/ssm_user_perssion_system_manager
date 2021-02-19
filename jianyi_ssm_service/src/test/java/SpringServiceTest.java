import com.atjianyi.pojo.Product;
import com.atjianyi.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author 简一
 * @className SpringServiceTest
 * @Date 2021/2/19 17:34
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext-tx.xml")
public class SpringServiceTest {
    @Autowired
    private ProductService service;
    @Test
    public void show(){
        List<Product> allProducts = service.findAllProducts();
        System.out.println(allProducts);
    }
}
