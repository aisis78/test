package test.app.json.vo;

/**
 * AppJsonFormatResponse
 *
 * @author vitec
 * @since 2018. 12. 28.
 * @see
 *
 * <pre>
 * 2018-12-28 vitec - create
 * </pre>
 */
public class AppJsonFormatResponseVo implements IAppJsonFormatBody {

    /**
     * 
     */
    private static final long serialVersionUID = 3851913160729098406L;

    String custId;

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }
    
}
