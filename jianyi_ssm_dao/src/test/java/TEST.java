import com.atjianyi.dao.ProductMapper;
import com.atjianyi.pojo.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author 简一
 * @className TEST
 * @Date 2021/2/19 16:19
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext-dao.xml")
public class TEST {
    @Autowired
    private ProductMapper mapper;
    @Test
    public void show(){
        List<Product> allProducts = mapper.findAllProducts();
        System.out.println(allProducts);
    }
}
