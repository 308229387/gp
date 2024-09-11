package com.songyongmeng.gp;

import java.io.Serializable;
import java.util.List;

public class LTBean implements Serializable {


    /**
     * ltName : 南都电源
     * ltDate : 2024-09-06
     * ltReason : 容量票反包，中途上冲上车，一度14个点，挺开心，结果回落，预期不太好，电池回流吧。冲高到前高，未能快速冲破，离场。
     * lt_image_list : ["Screenshot_2024-09-09-17-24-04-79_5c5979e609b9ed4a43e94260d67cf51e.webp","Screenshot_2024-09-09-16-46-51-96_5c5979e609b9ed4a43e94260d67cf51e.webp"]
     */

    private String ltName;
    private String ltDate;
    private String ltReason;
    private List<String> lt_image_list;

    public String getLtName() {
        return ltName;
    }

    public void setLtName(String ltName) {
        this.ltName = ltName;
    }

    public String getLtDate() {
        return ltDate;
    }

    public void setLtDate(String ltDate) {
        this.ltDate = ltDate;
    }

    public String getLtReason() {
        return ltReason;
    }

    public void setLtReason(String ltReason) {
        this.ltReason = ltReason;
    }

    public List<String> getLt_image_list() {
        return lt_image_list;
    }

    public void setLt_image_list(List<String> lt_image_list) {
        this.lt_image_list = lt_image_list;
    }
}
