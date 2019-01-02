package test.app;

import com.google.gson.Gson;

import test.app.json.vo.AppJsonFormatRequestVo;
import test.app.json.vo.AppJsonFormatResponseVo;
import test.app.json.vo.AppJsonFormatVo;

/**
 * AppJsonFormatTransTestMain
 *
 * @author vitec
 * @since 2018. 12. 28.
 * @see
 *
 * <pre>
 * 2018-12-28 vitec - create
 * </pre>
 */
public class AppJsonFormatTransTestMain {

    /**
     * @param args
     */
    public static void main(String[] args) throws Exception {
        AppJsonFormatRequestVo reqVo = new AppJsonFormatRequestVo();
        reqVo.setCustNo("12341234");
        reqVo.setCustName("김종명");
        
        AppJsonFormatResponseVo resVo = new AppJsonFormatResponseVo();
        resVo.setCustId("U00000000001");
        
        AppJsonFormatVo vo = new AppJsonFormatVo();
        
        vo.setEncType("1");
        vo.setKeyVersion("1.0");
        vo.setSendTime("20181228104500");
        vo.setReqData(reqVo);
        vo.setResData(resVo);
        vo.setEncData("");
        
        Gson gson = new Gson();
        String jsonString = gson.toJson(vo);
        System.out.println(jsonString);
        
        AppJsonFormatVo jsonVo = gson.fromJson(jsonString, AppJsonFormatVo.class);
        System.out.println(jsonVo.getResData());
        
        AppJsonFormatVo clonedJson = jsonVo.clone();
        System.out.println(clonedJson.getResData());
    }

}
