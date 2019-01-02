package test.app;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.Charset;

/**
 * PosTransTestMain
 *
 * @author vitec
 * @since 2018. 12. 24.
 * @see
 *
 * <pre>
 * 2018-12-24 vitec - create
 * </pre>
 */
public class PosTransTestMain {
    static String serverIp = "localhost";
    static int serverPort = 11000;
    
    static Charset defaultCharset = Charset.forName("UTF-8");
    
    /**
     * @param args
     * @throws IOException 
     * @throws UnknownHostException 
     */
    public static void main(String[] args) throws Exception {
        
        String msg = "아주공갈 염소똥! 10원에 몇장?";
        msg = String.format("%04d%s", msg.getBytes(defaultCharset).length, msg);

        byte[] resData = sendMessage(msg.getBytes(defaultCharset));
        
        System.out.println("Response:" + new String(resData, defaultCharset));
    }
    
    static byte[] sendMessage(byte[] data) throws Exception {
        byte[] bResData = null;
        
        try(Socket client = new Socket(serverIp, serverPort)){
            client.getOutputStream().write(data);
            
            byte[] bResSize = new byte[4];
            client.getInputStream().read(bResSize);
            
            int resSize = Integer.parseInt(new String(bResSize, defaultCharset));
            bResData = new byte[resSize];
            client.getInputStream().read(bResData);    
        }catch(Exception ex) {
            ex.printStackTrace();
        }

        return bResData;
    }

}
