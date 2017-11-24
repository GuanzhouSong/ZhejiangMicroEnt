package cs;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.chinaoly.oss.SgsOSSClient;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/entry/prd/spring-entry.xml" })
public class SgsOSSClientJunit {

    @Autowired
    private SgsOSSClient soc;

    public static String inputStream2String(InputStream is) throws IOException{
        ByteArrayOutputStream baos = new ByteArrayOutputStream ();
        int i = -1;
        while ((i = is.read ()) != -1) {
            baos.write (i);
        }
        return baos.toString ();
    }

    @Test
    public void test() throws Exception{
        InputStream in_withcode = new ByteArrayInputStream ("<html>中文辅导费辅导费辅导费</html>".getBytes ("UTF-8"));
        boolean state = soc.putStream ("message/txt/test.txt", in_withcode);
        System.out.println (state);
        InputStream in_withcode2 = soc.getStream ("message/txt/test.txt");
        String str = inputStream2String (in_withcode2);
        System.out.println (str);
        soc.deleteObject ("message/txt/test.txt");
        
         in_withcode2 = soc.getStream ("message/txt/test.txt");
         str = inputStream2String (in_withcode2);
        System.out.println (str);
    }

}
