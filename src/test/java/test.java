import com.miaosha.dao.UserDoMapper;
import com.miaosha.dataobject.UserDo;
import org.junit.Test;

public class test {


    @Test
    public void test(UserDo userDo) {
        userDo.setName("kkkk");
        userDo.setTelephone("123456");
        userDo.setAge(25);

        UserDoMapper userDoMapper;
//userDoMapper.insertSelective(userDo);
    }

}


