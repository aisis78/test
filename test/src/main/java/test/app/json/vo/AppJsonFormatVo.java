package test.app.json.vo;

import java.io.Serializable;

/**
 * AppJsonFormatVo
 *
 * @author vitec
 * @since 2018. 12. 28.
 * @see
 *
 *      <pre>
 * 2018-12-28 vitec - create
 *      </pre>
 */
public class AppJsonFormatVo implements Serializable, Cloneable {

    /**
     * 
     */
    private static final long serialVersionUID = -3648888412806691272L;

    /**
     * 암호화 여부 - 요청 데이터 및 응답 데이터에 대한 암호화 여부 지정<br/>
     * (App 에서 전문 구성 시 지정하여 전달 )
     * 
     * <pre>
     * 0: 암호화 안함
     * 1: 요청 전문 암호화 - reqData 에 해당하는 데이터를 암호화하여 encData 에 설정 ( app 에서 설정 )  
     * 2: 응답 전문 암호화 - resData 에 해당하는 데이터를 암호화하여 encData 에 설정 ( server 에서 설정 )
     * 3: 요청, 응답 전문 암호화
     * </pre>
     */
    String encType;

    /**
     * 통신 암호화 키 버전
     */
    String keyVersion;

    /**
     * 전송시간 ( 요청 시간 또는 응답 시간 )
     */
    String sendTime;

    /**
     * 암호화된 데이터 ( reqData 또는 resData )
     */
    String encData;

    IAppJsonFormatBody reqData;

    IAppJsonFormatBody resData;

    public String getEncType() {
        return encType;
    }

    public void setEncType(String encType) {
        this.encType = encType;
    }

    public String getKeyVersion() {
        return keyVersion;
    }

    public void setKeyVersion(String keyVersion) {
        this.keyVersion = keyVersion;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public String getEncData() {
        return encData;
    }

    public void setEncData(String encData) {
        this.encData = encData;
    }

    public IAppJsonFormatBody getReqData() {
        return reqData;
    }

    public void setReqData(IAppJsonFormatBody reqData) {
        this.reqData = reqData;
    }

    public IAppJsonFormatBody getResData() {
        return resData;
    }

    public void setResData(IAppJsonFormatBody resData) {
        this.resData = resData;
    }

    public AppJsonFormatVo clone() throws CloneNotSupportedException {
        return (AppJsonFormatVo) super.clone();
    }
}
