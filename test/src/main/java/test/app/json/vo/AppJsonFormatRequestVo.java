package test.app.json.vo;

/**
 * AppJsonFormatRequestVo
 *
 * @author vitec
 * @since 2018. 12. 28.
 * @see
 *
 * <pre>
 * 2018-12-28 vitec - create
 * </pre>
 */
public class AppJsonFormatRequestVo implements IAppJsonFormatBody {

    /**
     * 
     */
    private static final long serialVersionUID = -5280211965631486317L;
    
    String custNo;
    String custName;
    
    public String getCustNo() {
        return custNo;
    }
    public void setCustNo(String custNo) {
        this.custNo = custNo;
    }
    public String getCustName() {
        return custName;
    }
    public void setCustName(String custName) {
        this.custName = custName;
    }
    
}
